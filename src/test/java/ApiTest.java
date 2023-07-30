import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    public void testRandomUser() {
        given().when().get("https://randomuser.me/api/").then().statusCode(201);
    }
}
