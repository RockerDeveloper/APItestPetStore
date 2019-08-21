package rest.client.orderClient;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class StoreClient {
    public static final String ORDERPASS = "order/";

    public RequestSpecification setSpec() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter())
                .baseUri("http://petstore.swagger.io/v2")
                .basePath("/store/");

    }
}
