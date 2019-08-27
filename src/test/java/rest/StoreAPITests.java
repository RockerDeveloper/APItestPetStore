package rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.BL.order.ReadyAPIMethodsForOrder;
import rest.client.orderClient.StoreApiMethods;
import rest.client.petClient.PetAPIMethods;
import rest.client.petClient.PetClient;
import rest.models.petModels.PetModel;
import rest.models.storeModels.StoreModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rest.BL.ParseIntoClass.parseIntoOrder;
import static rest.builder.orderBuilder.OderBuilder.orderBuilder;
import static rest.builder.petBuilder.BuilderPet.petBuilder;

public class StoreAPITests extends StoreApiMethods {
    private Response response;
    private PetModel petModel;
    private StoreModel storeModel;
    private StoreModel expected;
    private StoreModel actual;
    private ReadyAPIMethodsForOrder methods = new ReadyAPIMethodsForOrder();

    @BeforeEach
    public void setUp() {
        petModel = petBuilder();
        PetClient petClient = new PetAPIMethods();
        ((PetAPIMethods) petClient).postPetStore(petModel);

    }

    @Test
    public void postOrderTest() {
        storeModel = orderBuilder(petModel);
        response = postOrder(storeModel);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getOrderByIdTest() {
        storeModel = orderBuilder(petModel);
        response = getOrderById(storeModel);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getOrderByStatusTest() {
        response = getStoreByInventory();
        assertEquals(200, response.getStatusCode());

    }

    @Test
    public void deleteOrderById() {
        storeModel = orderBuilder(petModel);
        response = deleteOrder(storeModel);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void orderLifeCycleTest() {
        storeModel = orderBuilder(petModel);
        response = postOrder(storeModel);
        assertEquals(storeModel, parseIntoOrder(response));

        expected = parseIntoOrder(response);
        response = getOrderById(storeModel);
        actual = parseIntoOrder(response);
        assertEquals(expected, actual);

        response = deleteOrder(storeModel);
        assertEquals(200, response.getStatusCode());
        response = getOrderById(expected);
        assertEquals(404, response.getStatusCode());
    }

    @Test
    public void orderTest(){
        storeModel = orderBuilder(petModel);
        methods.postOrderAndCheckIfPosted(storeModel);
        methods.deleteOrderAndCheckIfDeleted(storeModel);
    }
}
