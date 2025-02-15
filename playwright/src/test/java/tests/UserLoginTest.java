package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class UserLoginTest {

    @Test
    public void LoginUserAndVerifyProfile() {
        // Define login request body
        String loginRequest = "{ \"email\": \"johndoe@example.com\", \"password\": \"Test@123\" }";

        // Send POST request to login
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(loginRequest)
                .when()
                .post("https://practice.expandtesting.com/notes/api/users/login")
                .then()
                .statusCode(200) // Expect 200 OK
                .body("message", equalTo("User logged in successfully")) // Validate success message
                .extract().response();

        // Extract authentication token
        String authToken = response.jsonPath().getString("token");
        System.out.println("Auth Token: " + authToken);

        // Fetch user profile using the token
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken) // Pass token in header
                .when()
                .get("https://practice.expandtesting.com/notes/api/users/profile")
                .then()
                .statusCode(200) // Expect 200 OK
                .body("email", equalTo("johndoe@example.com")) // Verify email in profile
                .body("name", not(empty())); // Ensure name exists
    }
}