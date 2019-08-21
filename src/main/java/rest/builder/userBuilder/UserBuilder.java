package rest.builder.userBuilder;

import org.apache.commons.lang3.RandomStringUtils;
import rest.models.userModels.UserModel;

public class UserBuilder {
   // private ;

    public static UserModel userBuilder() {
        UserModel userModel = UserModel.builder()
                .id(Integer.parseInt(RandomStringUtils.randomNumeric(2)))
                .username(RandomStringUtils.randomAlphabetic(5))
                .firstName(RandomStringUtils.randomAlphabetic(4))
                .lastName(RandomStringUtils.randomAlphabetic(4))
                .email(RandomStringUtils.randomAlphabetic(4) + "@gmail.com")
                //.password(RandomStringUtils.random(10, 3, 7, true, true))
                .password(RandomStringUtils.randomNumeric(5))
                .phone(RandomStringUtils.randomNumeric(5))
                .userStatus(Integer.parseInt(RandomStringUtils.randomNumeric(1)))
                .build();
        return  userModel;
    }
}
