package springboot.ready.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import springboot.ready.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = { Application.class })
public class ApiControllerIT {

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void canCallApiWithDefaults() throws Exception {
        given().when()
                .get("/api")
                .then()
                .statusCode(200)
                .body("firstname",equalTo("john"))
                .body("name",equalTo("doe"));
    }

    @Test
    public void canCallApiWithParameters() throws Exception {
        given().when()
                .get("/api?firstname=carl&lastname=smith")
                .then()
                .statusCode(200)
                .body("firstname",equalTo("carl"))
                .body("name",equalTo("smith"));
    }

    @Test
    public void canCallApiWithParameterAndDefault() throws Exception {
        given().when()
                .get("/api?firstname=carl")
                .then()
                .statusCode(200)
                .body("firstname",equalTo("carl"))
                .body("name",equalTo("doe"));
    }
}