package liveprojects;

import

import com.sun.net.httpserver.Request;

import java.util.HashMap;

@ExtendWith(PactConsumerTestExt.class)

public class consumertest {
    // set the headers

    Map<String,String> headers =new HashMap<>();
    //Create the contract(Pact)
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        //Add the headers
        headers.put("Content-Type", "application/json");
        //Create the request and response body
        DslPart reqAndResBody = new PactDSLJsonBody()
                .numberType(name: "id", number 983)
                .stringType (name: ="firtsname", example: "uma")
                .stringType(name: ="lastName", example: "sankar")
                .stringType(name: ="email", example: "uma@example.com" );
        //write the interation
        return builder.giver(state "POST Request").
                uponReceiving (description: "a request to crate a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(reqAndResBody)
                .willRespondWith()
                .status(201)
                .body(reqAndResBody)
                .toPact();
    }

            //JUnit Test function
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")

}
