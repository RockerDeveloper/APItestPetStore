package rest.assertions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import rest.models.userModels.UserModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAssertions {
    public void userContentTypeJsonAndStatusCode(Response response, int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        assertEquals(String.valueOf(ContentType.JSON), response.getContentType());
    }

    public void checkIfPartsOfUserHaveChanged(UserModel userModel) {
        assertAll("The user have not been changed",
                () -> assertEquals("testEmail@gmail.com", userModel.getEmail()),
                () -> assertEquals("afterchanges", userModel.getUsername()),
                () -> assertEquals("+123456", userModel.getPhone())
        );

    }
}
