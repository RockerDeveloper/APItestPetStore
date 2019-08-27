package rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import rest.client.userClient.UserApiMethods;
import rest.models.userModels.UserModel;

import static rest.builder.userBuilder.UserBuilder.userBuilder;

public class FailPetTest {
    private UserApiMethods userApiMethods = new UserApiMethods();

@Test
    public void test(){
    UserModel userModel = userBuilder();
    Response response = userApiMethods.logInUserByUsernameAndPassword(userModel);
    System.out.println(response.getBody().print());
}
}
