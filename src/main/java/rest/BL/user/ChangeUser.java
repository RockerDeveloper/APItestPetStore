package rest.BL.user;

import rest.models.userModels.UserModel;

public class ChangeUser {

    public static UserModel changeSomeParts(UserModel userModel) {
        return userModel
                .setEmail("testEmail@gmail.com")
                .setUsername("afterchanges")
                .setPhone("+123456");
    }
}
