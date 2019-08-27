package rest.BL.order;

import io.restassured.response.Response;
import rest.client.orderClient.StoreApiMethods;
import rest.models.storeModels.StoreModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rest.BL.ParseIntoClass.parseIntoOrder;
import static rest.assertions.BaseAssertions.assertContentTypeAndStatusCode;

public class ReadyAPIMethodsForOrder extends StoreApiMethods {
    private Response response;

    public void postOrderAndCheckIfPosted(StoreModel storeModel){
        response = postOrder(storeModel);
        assertEquals(storeModel, parseIntoOrder(response));
        response = getOrderById(storeModel);
        assertContentTypeAndStatusCode(response, "application/json",200 );
    }

    public void deleteOrderAndCheckIfDeleted(StoreModel storeModel){
        response = deleteOrder(storeModel);
        response = getOrderById(storeModel);
        assertContentTypeAndStatusCode(response, "application/json",404 );
    }
}