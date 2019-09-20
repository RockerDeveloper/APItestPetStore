package rest;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import rest.BL.pet.ReadyAPIMethodsForPet;
import rest.fail.FailPetBuilder;
import rest.fail.FailPetModel;

@Execution(ExecutionMode.CONCURRENT)
@Feature("Invalid Model of Pet")
@ExtendWith(BaseTest.class)
public class FailPetTest  {

    private static Logger logger = Logger.getLogger(FailPetTest.class);
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
        methods.postPetAndCheckIfOperationIsSuccess(petModel);

    }

    @Test
    @Story("Adding one pet with incorrect fields and check if the pet has been placed and update this pet")
    @Description("Name, status and category have a type int and after post change the id and status")
    public void updateFailPet(){
        methods.postPetAndCheckIfOperationIsSuccess(petModel);
        methods.putPetUpgradesAndCheckIfChanged(petModel);

    }
    @Test
    @Story("Adding one pet with incorrect fields and check if the pet has been placed and trying delete pet ")
    @Description("Name, status and category have a type int and after post if the pet has been placed trying to delete it")
    public void deleteFailPet(){
        methods.postPetAndCheckIfOperationIsSuccess(petModel);
        methods.deletePetAndCheckIfDeleted(petModel);//error
    }

}
