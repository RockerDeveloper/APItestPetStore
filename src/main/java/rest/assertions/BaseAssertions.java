package rest.assertions;

import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseAssertions {
    public static void assertContentTypeAndStatusCode(Response response, String contentType, int statusCode) {

        assertAll("The Content type or status code is incorrect",
                () -> assertEquals(contentType, response.getContentType()),
                () -> assertEquals(statusCode, response.getStatusCode(), "The status code is incorrect")
        );

    }
}
