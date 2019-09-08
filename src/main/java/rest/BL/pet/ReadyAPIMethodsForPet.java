package rest.BL.pet;

import io.restassured.response.Response;
import rest.client.petClient.PetAPIMethods;
import rest.fail.FailPetClient;
import rest.fail.FailPetModel;
import rest.models.petModels.PetModel;
import rest.utils.Utils;

import static rest.assertions.PetAssertions.assertContentTypeAndStatusCode;
import static rest.assertions.PetAssertions.assertIfPetChangedAfterPut;

public class ReadyAPIMethodsForPet {
    private FailPetClient failPetClient = new FailPetClient() ;
    private PetModel model;
    private PetAPIMethods petAPIMethods = new PetAPIMethods();
    private Response response;
    private FailPetClient failMethods = new FailPetClient();

    public void postPetAndCheckIfOperationIsSuccess(PetModel petModel){
        response = petAPIMethods.postPetStore(petModel);
        assertContentTypeAndStatusCode(response, "application/json",
                Utils.statusCode.SUCCESS.getStatusCode());
        response = petAPIMethods.getPetById(petModel);
        assertContentTypeAndStatusCode(response, "application/json",
                Utils.statusCode.SUCCESS.getStatusCode());
    }

    public void postPetAndcheckIfOperationIsSucces(FailPetModel failPetModel){
        response = failMethods.postFailPet(failPetModel);
        assertContentTypeAndStatusCode(response, "application/json",
                Utils.statusCode.SERVERERROR.getStatusCode());
        response = failMethods.getFailPetById(failPetModel);
        assertContentTypeAndStatusCode(response, "application/json",
                Utils.statusCode.NOTFOUND.getStatusCode());

    }

    public void deletePetAndCheckIfDeleted(PetModel petModel){
        response = petAPIMethods.deletePetById(petModel);
        assertContentTypeAndStatusCode(response, "application/json",
                Utils.statusCode.SUCCESS.getStatusCode());
        response = petAPIMethods.getPetById(petModel);
        assertContentTypeAndStatusCode(response, "application/json",
                Utils.statusCode.NOTFOUND.getStatusCode());
    }

    public void deletePetAndCheckIfDeleted(FailPetModel petModel){
        assertContentTypeAndStatusCode(failPetClient.deleteFailPetById(petModel), ""
       // , Utils.statusCode.NOTFOUND.getStatusCode() );
                , Utils.statusCode.SERVERERROR.getStatusCode() );
    }

    public void putPetUpgradesAndCheckIfChanged(PetModel petModel){
        model = petAPIMethods.petChanges(petModel);
        response = petAPIMethods.putPetStore(model);
        assertIfPetChangedAfterPut(model);
        assertContentTypeAndStatusCode(response, "application/json",
                Utils.statusCode.SUCCESS.getStatusCode());
    }

    public void putPetUpgradesAndCheckIfChanged(FailPetModel petModel){
        assertContentTypeAndStatusCode(failMethods.putFailPet(petModel),
                "application/json", Utils.statusCode.SERVERERROR.getStatusCode());
    }

}
