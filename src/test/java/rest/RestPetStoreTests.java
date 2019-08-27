package rest;

import io.restassured.response.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.BL.pet.ReadyAPIMethodsForPet;
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
    private PetModel petModel;
    private ReadyAPIMethodsForPet methods = new ReadyAPIMethodsForPet();
    private Response response;

    @BeforeEach
    void setUp() {
        petClient = new PetClient();
        petModel = petBuilder();
    }

    @Test
    public void testPetInfoById() {
        response = petClient.setup()
                .get(String.valueOf(12))
                .then()
                .extract().response();
        assertEquals(200, response.getStatusCode());
        PetModel as = parseIntoPet(response);
        System.out.println(as);

    }

    @Test
    public void testUploadImageForPet(){
        response = petPostUploadImage("7");
    }

    @Test
    public void testPetPost() {
        PetModel petsample = petBuilder();
        response = postPetStore(petsample);
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
        PetModel example = petBuilder();
        Response responseByGet = getPetById(example);
        PetModel test = parseIntoPet(responseByGet);
        test.setName("testName");
        test.setCategory(CategoryModel.builder().name("testName").build());
        response = putPetStore(test);
        assertEquals(200, response.getStatusCode());

    }

    @Test
    public void testDeletePetById() {
        PetModel petModel = petBuilder();
        response = postPetStore(petModel);
        Response responseById = getPetById(petModel);
        PetModel createdPet = parseIntoPet(responseById);
        response = deletePetById(petModel);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testGetPetByStatus() {
        List<PetModel> responseByStatus = Arrays.asList(getPetByStatus("sold")
                .as(PetModel[].class));

        responseByStatus.stream()
                .limit(1)
                .forEach(System.out::println);
    }

    @Test
    public void testPutPetList() {
        List<PetModel> petModelList = IntStream.range(0, 20)
                .mapToObj(el -> petBuilder())
                .collect(Collectors.toList());

        List<PetModel> updatedPetModels = new PetAPIMethods().putPetListStore(petModelList);
        assertFalse(CollectionUtils.isEqualCollection(petModelList, updatedPetModels));
    }

    @Test
    public void testPutPetAfterChanges() {
        PetModel beforeChages = petBuilder();
        PetModel result = petChanges(beforeChages);
        response = getPetById(beforeChages);
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

    @Test
    public void petTest(){
        methods.postPetAndCheckIfOperationIsSuccess(petModel);
        methods.putPetUpgradesAndCheckIfChanged(petModel);
        methods.deletePetAndCheckIfDeleted(petModel);

    }
}
