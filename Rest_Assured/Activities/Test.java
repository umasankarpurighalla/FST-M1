package liveprojects;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)

public class Test { //Set the headers
    Map<String, String> headers = new HashMap<>();
    //Create the contract (pact)
    @Pact(consumer = "UserConsumer", provider = "UserProvider")

    public RequestResponsePact createPact(PactDslWithProvider builder) {
        //Add the headers
        headers.put("Content-Type", "application/json");
        // Create request and response body
        DslPart reqAndResBody = new PactDslJsonBody()
                .numberType("id", 780)
                .stringType("firstName", "Rupam")
                .stringType("lastName", "Rashmi")
                .stringType("email", "xyz@gmail.com");
        //Write the interaction
        return builder.given("POST Request").
                uponReceiving("a request to create a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(reqAndResBody)
                .willRespondWith()
                .status(201)
                .body(reqAndResBody)
                .toPact();

    }
    //Junit test functions
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest(){
        //Request body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 780);
        reqBody.put("firstName", "Rupam");
        reqBody.put("lastName", "Rashmi");
        reqBody.put("email", "xyz@gmail.com");
        //Send request, get response and assert
        given().baseUri("http://localhost:8282").headers(headers).body(reqBody).log().all().
                when().post("/api/users").
                then().statusCode(201).body("email", equalTo("xyz@gmail.com")).log().all();
    }


}
