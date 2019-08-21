package rest.client.orderClient;

import io.restassured.response.Response;
import rest.models.storeModels.StoreModel;

public class StoreApiMethods extends StoreClient {
    private Response response;

    public Response getStoreByInventory() {
        return setSpec()
                .get("inventory");
    }

    public Response getOrderById(StoreModel storeModel){
        return setSpec()
                .get(ORDERPASS+ storeModel.getId())
                .then()
                .extract()
                .response();
    }

    public Response postOrder(StoreModel storeModel){
        return setSpec()
                .body(storeModel)
                .post(ORDERPASS);
    }

    public Response deleteOrder(StoreModel storeModel){
        return setSpec()
                .delete(ORDERPASS+ storeModel.getId());
    }

}
