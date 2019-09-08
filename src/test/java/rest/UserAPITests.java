package rest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import rest.BL.user.ReadyAPIMethodsForUser;
import rest.models.userModels.UserModel;

import static rest.builder.userBuilder.UserBuilder.userBuilder;

@Execution(ExecutionMode.CONCURRENT)

public class UserAPITests {
    private ReadyAPIMethodsForUser methods = new ReadyAPIMethodsForUser();
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
        methods.singInAndLogOutUser(userModel);
    }


}
