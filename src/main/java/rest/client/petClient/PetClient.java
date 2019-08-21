package rest.client.petClient;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PetClient {

    public RequestSpecification setup() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter())
                .baseUri("http://petstore.swagger.io/v2")
                .basePath("/pet/");
    }

}
