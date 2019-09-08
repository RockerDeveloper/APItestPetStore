package rest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import rest.BL.pet.ReadyAPIMethodsForPet;
import rest.fail.FailPetBuilder;
import rest.fail.FailPetModel;

@Execution(ExecutionMode.CONCURRENT)
@Feature("Invalid Model of Pet")
public class FailPetTest {

    private ReadyAPIMethodsForPet methods = new ReadyAPIMethodsForPet();
    private FailPetModel petModel;

    @BeforeEach
    public void setup() {
        petModel = FailPetBuilder.failPetBuilder();
    }

    @Test
    @Story("Adding one pet with incorrect fields and check if the pet has been placed")
    @Description("Name, status and category have a type int")
    public void postFailPetAndGetIt() {
        methods.postPetAndcheckIfOperationIsSucces(petModel);

    }

    @Test
    @Story("Adding one pet with incorrect fields and check if the pet has been placed and update this pet")
    @Description("Name, status and category have a type int and after post change the id and status")
    public void updateFailPet(){
        methods.postPetAndcheckIfOperationIsSucces(petModel);
        methods.putPetUpgradesAndCheckIfChanged(petModel);

    }
    @Test
    @Story("Adding one pet with incorrect fields and check if the pet has been placed and trying delete pet ")
    @Description("Name, status and category have a type int and after post if the pet has been placed trying to delete it")
    public void deleteFailPet(){
        methods.postPetAndcheckIfOperationIsSucces(petModel);
        methods.deletePetAndCheckIfDeleted(petModel);//error
    }
}
