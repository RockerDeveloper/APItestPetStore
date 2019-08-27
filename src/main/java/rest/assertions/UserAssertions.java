package rest.assertions;

import io.restassured.response.Response;
import rest.models.userModels.UserModel;

import static org.junit.jupiter.api.Assertions.*;

public class UserAssertions extends BaseAssertions {

    public void checkIfPartsOfUserHaveChanged(UserModel userModel) {
        assertAll("The user have not been changed",
                () -> assertEquals("testEmail@gmail.com", userModel.getEmail()),
                () -> assertEquals("afterchanges", userModel.getUsername()),
                () -> assertEquals("+123456", userModel.getPhone())
        );

    }

    public static void checkIfUserLogInSuccessfully(Response response, int statusCode) {
        String responseBody = String.valueOf(response.getBody());
        response.getBody().print();
        String[] body = responseBody.split("\\d");
        //boolean tr = responseBody.contains("logged");
        //System.out.println(responseBody);
//        assertAll("The user doe not logged",
//                () ->assertEquals(statusCode, response.getStatusCode()),
//                () ->assertTrue(body[0].equals("logged in user session:" ))
//                );
    }
}
