import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    public void testGetUser() {
        given()
                .when()
                .get("https://reqres.in/api/users/1")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(1))
                .body("data.email", equalTo("george.bluth@reqres.in"))
                .body("data.first_name", equalTo("George"))
                .body("data.last_name", equalTo("Bluth"));

    }

    @Test
    public void testGetManyUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .statusCode(200)
                .body("page", equalTo(1))
                .body("per_page", equalTo(6))
                .body("total", equalTo(12))
                .body("data", hasSize(6));
    }

    @Test
    public void testCreateUser() {
        String body = "{\"name\":\"John\",\"job\":\"Engineer\"}";
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("John"))
                .body("job", equalTo("Engineer"))
                .body("", hasKey("id"));
    }
}
