package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {

    // GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
    @Test
    public void getRequestWithQueryParam(){
        Response response =
                given().
                        baseUri("https://petstore.swagger.io/v2/pet").
                        header("Content-Type","application/json").
                        queryParam("status", "alive").
                        log().all().
                        when().
                        get("/findByStatus");
        //Print response body and header
        System.out.println(response.getHeaders());
        System.out.println(response.getBody().asPrettyString());
        String petStatus = response.then().extract().path("[0]['status']");
        Assert.assertEquals(petStatus, "alive");
    }


    // GET https://petstore.swagger.io/v2/pet/{petId}
    @Test
    public void getRequestWithPathParam(){
        given(). //request specification
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type","application/json").
                pathParam("petId", 772322).log().all().
                when().
                get("/{petId}").
                then(). //response specification
                statusCode(200).
                body("name", equalTo("Hansel")).
                body("status", equalTo("alive")).log().all();

    }
}