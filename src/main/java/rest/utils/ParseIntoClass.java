package rest.utils;

import io.restassured.response.Response;
import rest.models.petModels.PetModel;
import rest.models.storeModels.StoreModel;
import rest.models.userModels.UserModel;

public class ParseIntoClass {
    public static PetModel parseIntoPet(Response response) {

        return response.as(PetModel.class);
    }

    public static StoreModel parseIntoOrder(Response response) {
        return response.as(StoreModel.class);
    }

    public static UserModel parseIntoUser(Response response) {
        return response.as(UserModel.class);
    }
}
