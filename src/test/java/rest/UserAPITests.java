package rest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.BL.user.ReadyAPIMethodsForUser;
import rest.builder.userBuilder.UserBuilder;
import rest.models.userModels.UserModel;

import static rest.builder.userBuilder.UserBuilder.userBuilder;

public class UserAPITests {
    private ReadyAPIMethodsForUser methods = new ReadyAPIMethodsForUser();
    private UserBuilder userBuilder;
    private UserModel userModel;

    @BeforeEach
    public void userCreationAndChecking() {
        userModel = userBuilder();
        methods.postOneUser(userModel);
        methods.getOneUserByUserName(userModel);
    }

    @AfterEach
    public void userDeleteAndChecking() {
        methods.deleteOneUserByUserNameAndChecking(userModel);
    }

    @Test
    public void putChangeSomePartsOfUserTest() {
        methods.putSomeChangesForOneUserAndChecking(userModel);
    }

//    @Test
//    public void test() {
//        //userModel = userBuilder();
//        methods.postOneUser(userModel);
//
//    }

}
