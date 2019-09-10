package rest.BL.order;

import io.restassured.response.Response;
import rest.client.orderClient.StoreApiMethods;
import rest.models.storeModels.StoreModel;
import rest.utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rest.assertions.BaseAssertions.assertContentTypeAndStatusCode;
import static rest.utils.ParseIntoClass.parseIntoOrder;

public class ReadyAPIMethodsForOrder extends StoreApiMethods {
    private Response response;

    public void postOrderAndCheckIfPosted(StoreModel storeModel){
        response = postOrder(storeModel);
        assertEquals(storeModel, parseIntoOrder(response));
        response = getOrderById(storeModel);
        assertContentTypeAndStatusCode(response, "application/json", Utils.statusCode.SUCCESS.getStatusCode() );
    }

    public void deleteOrderAndCheckIfDeleted(StoreModel storeModel){
        response = deleteOrder(storeModel);
        response = getOrderById(storeModel);
        assertContentTypeAndStatusCode(response, "application/json",Utils.statusCode.NOTFOUND.getStatusCode() );
    }
}
