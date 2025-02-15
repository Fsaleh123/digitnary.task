package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class HealthCheckTest {

    @Test
    public void verifyAPIHealth() {
        RestAssured
                .given()
                .accept("application/json")
                .when()
                .get("https://practice.expandtesting.com/notes/api/health-check")
                .then()
                .statusCode(200) // Ensure HTTP 200 OK
                .body("status", equalTo("OK")); // Validate response body
    }
}
