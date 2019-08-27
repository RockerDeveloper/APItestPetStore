package rest.BL.pet;

import io.restassured.response.Response;
import rest.client.petClient.PetAPIMethods;
import rest.fail.FailPetClient;
import rest.fail.FailPetModel;
import rest.models.petModels.PetModel;

import static rest.assertions.PetAssertions.assertContentTypeAndStatusCode;
import static rest.assertions.PetAssertions.assertIfPetChangedAfterPut;

public class ReadyAPIMethodsForPet {
    private PetModel model;
    private PetAPIMethods petAPIMethods = new PetAPIMethods();
    private Response response;
    private FailPetClient failMethods = new FailPetClient();

    public void postPetAndCheckIfOperationIsSuccess(PetModel petModel){
        response = petAPIMethods.postPetStore(petModel);
        assertContentTypeAndStatusCode(response, "application/json", 200);
        response = petAPIMethods.getPetById(petModel);
        assertContentTypeAndStatusCode(response, "application/json", 200);
    }

    public void postPetAndcheckIfOperationIsSucces(FailPetModel failPetModel){
        response = failMethods.postFailPet(failPetModel);
        assertContentTypeAndStatusCode(response, "application/json", 405);
        response = failMethods.getFailPetById(failPetModel);
        assertContentTypeAndStatusCode(response, "application/json", 404);

    }

    public void deletePetAndCheckIfDeleted(PetModel petModel){
        response = petAPIMethods.deletePetById(petModel);
        assertContentTypeAndStatusCode(response, "application/json", 200);
        response = petAPIMethods.getPetById(petModel);
        assertContentTypeAndStatusCode(response, "application/json", 404);
    }

    public void putPetUpgradesAndCheckIfChanged(PetModel petModel){
        model = petAPIMethods.petChanges(petModel);
        response = petAPIMethods.putPetStore(model);
        assertIfPetChangedAfterPut(model);
        assertContentTypeAndStatusCode(response, "application/json", 200);
    }
}
