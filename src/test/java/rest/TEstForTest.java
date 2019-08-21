package rest;

import org.junit.jupiter.api.Test;
import rest.BL.user.ReadyAPIMethodsForUser;
import rest.models.userModels.UserModel;

import static rest.builder.userBuilder.UserBuilder.userBuilder;

public class TEstForTest {
    private ReadyAPIMethodsForUser methods = new ReadyAPIMethodsForUser();
    private UserModel userModel;

    @Test
    public void test() {
        userModel = userBuilder();
        methods.postOneUser(userModel);
        methods.getOneUserByUserName(userModel);
        methods.putSomeChangesForOneUserAndChecking(userModel);
    }
}
