package rest;

import io.restassured.response.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.client.petClient.PetAPIMethods;
import rest.client.petClient.PetClient;
import rest.models.petModels.CategoryModel;
import rest.models.petModels.PetModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static rest.BL.ParseIntoClass.parseIntoPet;
import static rest.builder.petBuilder.BuilderPet.petBuilder;

public class RestPetStoreTests extends PetAPIMethods {
    private PetClient petClient;

    @BeforeEach
    void setUp() {
        petClient = new PetClient();
    }

    @Test
    public void testPetInfoById() {
        Response response2 = new PetAPIMethods().petPostUploadImage("7");

        Response response = petClient.setup()
                .get(String.valueOf(629496))
                .then()
                .extract().response();
        assertEquals(200, response.getStatusCode());
        PetModel as = parseIntoPet(response);
        System.out.println(as);

    }

    @Test
    public void testPetPost() {
        PetModel petsample = petBuilder();
        Response response = postPetStore(petsample);
        assertEquals(200, response.getStatusCode());
        assertEquals(12, petsample.getId());
    }

    @Test
    public void testPetGetById() {
        PetModel example = petBuilder();
        Response responseByGet = getPetById(example);
        PetModel as = parseIntoPet(responseByGet);
        assertEquals(as.getId(), example.getId());
    }

    @Test
    public void testPutPetStore() {
//        StoreModel responseByGet = getPetById(629496);
//        PetModel result = responseByGet.as(PetModel.class);
//        PetModel putexample = petBuilder();
//        StoreModel response = putPetStore(putexample,629496);
//        putexample = response.as(PetModel.class);
//        assertNotEquals(result.getName(),putexample.getName());
//        System.out.println(result);
//
//        StoreModel responseByGet = getPetById(629496);
//        PetModel result = responseByGet.as(PetModel.class);
//        RestAssured.given()
//                .pathParam("id",629496)
//                .pathParam("status", "available")
//                .when()
//                .put("/reverse/{id}/{status}")
//                .then()
//                .extract().response();
        PetModel example = petBuilder();
        Response responseByGet = getPetById(example);
        PetModel test = parseIntoPet(responseByGet);
        test.setName("testName");
        test.setCategory(CategoryModel.builder().name("testName").build());
        Response response = putPetStore(test);
        assertEquals(200, response.getStatusCode());


//        String id ="629496";
//            String changes = "{\r\n"+
//            "\"id\": \"629496\",\r\n"+
//            "\"category\": {\r\n"+
//            "\"name\":\"put_test_pet\",\r\n"+
//            "},\r\n"+
//            "\"name\":\"put_test_pet\",\r\n"+
//            "\"photoUrls\":\"[\"\r\n"+
//            "\"nXYlziLgtP\"\r\n"+
//            "\"],\"\r\n"+
//            "\"tags\":[\"\r\n"+
//            "\"{\"\r\n"+
//            "\"id\": \"629496\",\r\n"+
//            "\"name\":\"put_test_pet\",\r\n"+
//            "},\r\n"+
//            "\"],\"\r\n"+
//            "\"status\":\"available\"\r\n"+
//            "},\r\n";
        // StoreModel response = putPetStore(id,changes);

    }

    @Test
    public void testDeletePetById() {
        PetModel petModel = petBuilder();
        Response responseById = getPetById(petModel);
        PetModel createdPet = parseIntoPet(responseById);
        Response response = deletePetById(petModel);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testGetPetByStatus() {
        List<PetModel> responseByStatus = Arrays.asList(getPetByStatus("sold")
                .as(PetModel[].class));

        responseByStatus.stream()
                .limit(1)
                .forEach(System.out::println);
//        List<PetModel> listOfPetsWithStatus = new ArrayList<>();
//        listOfPetsWithStatus.add(responseByStatus.as(PetModel.class));
//        assertEquals(200, responseByStatus.getStatusCode());


    }

    @Test
    public void testPutPetList() {
        List<PetModel> petModelList = IntStream.range(0, 20)
                .mapToObj(el -> petBuilder())
                .collect(Collectors.toList());

        List<PetModel> updatedPetModels = new PetAPIMethods().putPetListStore(petModelList);
        assertTrue(CollectionUtils.isEqualCollection(petModelList, updatedPetModels));
    }

    @Test
    public void testPutPetAfterChanges() {
        PetModel beforeChages = petBuilder();
        PetModel result = petChanges(beforeChages);
        Response response = getPetById(beforeChages);
        response = putPetStore(result);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void fullCycleTest() {
        PetModel petModel = petBuilder();
        postPetStore(petModel);
        Response responseGetById = getPetById(petModel);
        petModel = petChanges(petModel);
        deletePetById(petModel);
        Response responseGetByIdAfterDelete = getPetById(petModel);
        assertNotEquals(responseGetById.getStatusCode(), responseGetByIdAfterDelete.getStatusCode());
    }
}
