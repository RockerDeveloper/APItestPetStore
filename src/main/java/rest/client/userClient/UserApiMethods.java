package rest.client.userClient;

import io.restassured.response.Response;
import rest.models.userModels.UserModel;

import java.util.List;

import static rest.BL.user.ChangeUser.changeSomeParts;

public class UserApiMethods extends UserClient {

    protected Response postUser(UserModel userModel) {
        return setFil()
                .body(userModel)
                .post();
    }

    public List<UserModel> postListOfUsers(List<UserModel> listOfUser) {
        listOfUser
                .forEach(el -> postUser(el).as(UserModel.class));
        return listOfUser;
    }

    public UserModel[] postUserArray(List<UserModel> listOfUsers) {
        UserModel[] userModels = new UserModel[listOfUsers.size()];
        for (int i = 0; i < userModels.length; i++) {
            userModels[i] = listOfUsers.get(i);
            postUser(userModels[i]);
        }
        return userModels;
    }

    protected Response getUserByUsername(UserModel userModel) {
        return setFil()
                .get(userModel.getUsername());
    }

    protected Response deleteUserByUsername(UserModel userModel) {
        return setFil()
                .delete(userModel.getUsername());
    }

    protected Response putChangesIntoUser(UserModel userModel) {
        return setFil()
                .body(changeSomeParts(userModel))
                .put();
    }

}
