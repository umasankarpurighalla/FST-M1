package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;

public class SpecificationTest {
    private static final Logger log = LoggerFactory.getLogger(SpecificationTest.class);
    RequestSpecification requestSpect;
    ResponseSpecification responseSpec;
    int petId;

    @BeforeClass
    public void setUp() {
        requestSpect = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                //  .addHeader("Authorization","token ghp_apsfnqpekngpqinv")
                //  .setAuth(RestAssured.config("ghp_askfnapengr"))
                .build();
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .expectResponseTime(lessThanOrEqualTo(3000L))
                //Long L
                //float f
// Build response specification
                .build();
    }

    @Test(priority = 1)
    public void postRequest() {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 77232);
        reqBody.put("name", "Riley");
        reqBody.put("status", "alive");
        Response response = given().spec(requestSpect).body(reqBody).when().post();
        petId = response.then().extract().path("id");
        response.then().spec(responseSpec);

    }

    @Test(priority = 2)
    public void getRequest() {
        given().spec(requestSpect).pathParam("petId", petId)
                .when().get("/{petId}")
                .then().spec(responseSpec);
    }

    @Test(priority = 3)
    public void deletRequest() {
        given().spec(requestSpect).pathParam("petId", petId)
                .when().delete("/{petId}")
                .then().statusCode(200).body("message", equalTo("" + petId));

    }
}
