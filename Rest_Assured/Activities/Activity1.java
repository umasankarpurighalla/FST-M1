package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Activity1 {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int petId;
    @BeforeClass
    public void setUp(){
        //Request Specifications
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type","application/json")
                .build();
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .expectResponseTime(lessThanOrEqualTo(3000L))
                .build();

    }
    @Test(priority = 1)
    // Post https://petstore.swagger.io/v2/pet
    public void PostRequest(){
        //create a request body
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("id", 770);
        reqBody.put("name", "Fiona");
        reqBody.put("status", "alive");


        //Save the response
        Response response = given().spec(requestSpec).body(reqBody).when().post();
        petId = response.then().extract().path("id");
        //Assertions
        response.then().spec(responseSpec);

    }
    @Test(priority = 2)
    // Get  https://petstore.swagger.io/v2/pet/{petId}
    public void getRequest(){
        //sent request, get response and assert
        given().spec(requestSpec).pathParam("petId", petId).
                when().get("/{petId}").
                then().spec(responseSpec);

    }

    @Test(priority = 3)
    // Delete https://petstore.swagger.io/v2/pet/{petId}
    public void deleteRequest(){
        //sent request, get response and assert
        given().spec(requestSpec).pathParam("petId", petId).
                when().delete("/{petId}").
                then().statusCode(200).body("message", equalTo("" + petId));

    }
}