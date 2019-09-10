package rest.fail;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FailPetClient {

    public static RequestSpecification trueSetUp(){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter())
                .baseUri("http://petstore.swagger.io/v2")
                .basePath("/pet/");
    }
    @Step
    public FailPetModel failPetModelAfterChange(FailPetModel failPetModel){
        return failPetModel
                .setId(12)
                .setStatus(77);
    }
    @Step
    public Response postFailPet(FailPetModel failPetModel){
        return trueSetUp()
                .body(failPetModel)
                .post();
    }
    @Step
    public Response getFailPetById(FailPetModel failPetModel){
        return trueSetUp()
                //.pathParam("id",failPetModel.getId())
                .get(String.valueOf(failPetModel.getId()));
    }
    @Step
    public  Response putFailPet(FailPetModel failPetModel){
        return trueSetUp()
                .body(failPetModelAfterChange(failPetModel))
                .put();
    }
    @Step
    public Response deleteFailPetById(FailPetModel failPetModel){
        return trueSetUp()
                //.pathParam("id",failPetModel.getId())
                .delete(String.valueOf(failPetModel.getId()));
    }

}
