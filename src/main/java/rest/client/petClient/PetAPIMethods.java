package rest.client.petClient;

import io.restassured.response.Response;
import rest.models.petModels.PetModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class PetAPIMethods extends PetClient {

    private Response response;

    public Response postPetStore(PetModel petModel) {
        return setup()
                .body(petModel)
                .post();
    }

    public Response getPetById(PetModel petModel) {
        return response = setup()
                .get(String.valueOf(petModel.getId()))
                .then()
                //.body("id", Matchers.equalTo(petModel.getId()))
                .extract().response();
    }

    public Response getPetByStatus(String status) {
        return response = setup()
//                .pathParam("findByStatus",petJson)
//                .queryParam("?status=" + status)
                .get("/findByStatus/?status=" + status)
                .then()
                .extract()
                .response();
    }

    public Response putPetStore(PetModel petModel) {
        return response = setup()
                .body(petModel)
                .put();
    }

    public List<PetModel> putPetListStore(List<PetModel> petJsonsList) {
        List<PetModel> updatedPedList = new ArrayList<>();
        petJsonsList
                .forEach(el -> updatedPedList.add(putPetStore(el).as(PetModel.class)));

        return updatedPedList;
    }

    public Response deletePetById(PetModel petModel) {
        return response = setup()
                //.pathParam("id", petModel.getId())
                .delete(String.valueOf(petModel.getId()));
    }

    public PetModel petChanges(PetModel petModel) {
        return petModel
                .setStatus("sold")
                .setName("test name");
    }

    public Response petPostUploadImage(String id) {
        File file = new File("C:\\Users\\Максим\\Downloads\\testIMG.jpg");
        return response = setup()
                .pathParam("id", id)
                .contentType("multipart/form-data")
                .multiPart(file)
                //.formParam("", )
                .post("/{id}/uploadImage");
    }
}
