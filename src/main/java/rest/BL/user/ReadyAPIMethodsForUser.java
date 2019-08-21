package rest.BL.user;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import rest.assertions.UserAssertions;
import rest.client.userClient.UserApiMethods;
import rest.models.userModels.UserModel;

import static rest.BL.ParseIntoClass.parseIntoUser;

public class ReadyAPIMethodsForUser extends UserApiMethods {
    private UserAssertions userAssertions = new UserAssertions();
    private Response response;
    private UserModel userChanged;


    public void postOneUser(UserModel userModel) {
        response = postUser(userModel);
        userAssertions.userContentTypeJsonAndStatusCode(response,200);
    }

    public void getOneUserByUserName(UserModel userModel){
        response = getUserByUsername(userModel);
        userAssertions.userContentTypeJsonAndStatusCode(response,200);
        Assertions.assertEquals(userModel,parseIntoUser(response));
    }

    public void deleteOneUserByUserNameAndChecking(UserModel userModel){
        response = deleteUserByUsername(userModel);
        userAssertions.userContentTypeJsonAndStatusCode(response,200);
        response = getUserByUsername(userModel);
        Assertions.assertEquals(404,response.getStatusCode());
    }

    public void putSomeChangesForOneUserAndChecking(UserModel userModel){
        response = putChangesIntoUser(userModel);
        userAssertions.checkIfPartsOfUserHaveChanged(parseIntoUser(response));
    }
}
