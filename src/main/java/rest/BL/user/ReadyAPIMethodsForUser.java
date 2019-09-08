package rest.BL.user;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import rest.assertions.UserAssertions;
import rest.client.userClient.UserApiMethods;
import rest.models.userModels.UserModel;
import rest.utils.Utils;

import static rest.BL.ParseIntoClass.parseIntoUser;
import static rest.assertions.BaseAssertions.assertContentTypeAndStatusCode;
import static rest.assertions.UserAssertions.checkIfUserLogInSuccessfully;

public class ReadyAPIMethodsForUser extends UserApiMethods {
    private UserAssertions userAssertions = new UserAssertions();
    private Response response;


    public void postOneUser(UserModel userModel) {
        response = postUser(userModel);
        assertContentTypeAndStatusCode(response, "application/json", Utils.statusCode.SUCCESS.getStatusCode());
    }

    public void getOneUserByUserName(UserModel userModel) {
        response = getUserByUsername(userModel);
        assertContentTypeAndStatusCode(response, "application/json", Utils.statusCode.SUCCESS.getStatusCode());
        Assertions.assertEquals(userModel, parseIntoUser(response));
    }

    public void deleteOneUserByUserNameAndChecking(UserModel userModel) {
        response = deleteUserByUsername(userModel);
        assertContentTypeAndStatusCode(response, "application/json", Utils.statusCode.SUCCESS.getStatusCode());
        response = getUserByUsername(userModel);
        Assertions.assertEquals(404, response.getStatusCode());
    }

    public void putSomeChangesForOneUserAndChecking(UserModel userModel) {
        response = putChangesIntoUser(userModel);
        userAssertions.checkIfPartsOfUserHaveChanged(parseIntoUser(response));
    }

    public void singInAndLogOutUser(UserModel userModel) {
        response = logInUserByUsernameAndPassword(userModel);
        checkIfUserLogInSuccessfully(response, Utils.statusCode.SUCCESS.getStatusCode());
    }
}
