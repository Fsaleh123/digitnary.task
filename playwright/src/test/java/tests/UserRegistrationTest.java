package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class UserRegistrationTest {

    @Test
    public void registerNewUserAndVerify() {
        // Define request body
        String requestBody = "{ \"name\": \"John Doe\", \"email\": \"johndoe@example.com\", \"password\": \"Test@123\" }";

        // Send POST request to register user
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://practice.expandtesting.com/notes/api/users/register")
                .then()
                .statusCode(201) // Expect 201 Created
                .body("message", equalTo("User registered successfully")) // Validate response
                .extract().response();
    }
}
