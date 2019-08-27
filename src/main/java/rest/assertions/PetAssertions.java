package rest.assertions;

import rest.models.petModels.PetModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetAssertions extends BaseAssertions {

    public static void assertPet(PetModel expected, PetModel actual) {
        assertAll("The elements of two objects are not equal",
                () -> assertEquals(expected.getId(), actual.getId(), "IDs are different"),
                () -> assertEquals(expected.getName(), actual.getName(), "Names are different"),
                () -> assertEquals(expected.getCategory().getId(), actual.getCategory().getId(), "IDs are different in category"),
                () -> assertEquals(expected.getCategory().getName(), actual.getCategory().getName(), "Names are different in category"),
                () -> assertEquals(expected.getPhotoUrls(), actual.getPhotoUrls(), "PhotoURLs are different"),
                () -> assertEquals(expected.getTags(), actual.getTags(), "Tags are different"),
                () -> assertEquals(expected.getStatus(), expected.getStatus(), "Status are different"));
    }


    public static void assertIfPetChangedAfterPut(PetModel petModel){
        assertAll("The pet did not changes",
                () -> assertEquals("sold", petModel.getStatus(),"The status have not been changed"),
                () -> assertEquals("testName", petModel.getName(), "The name have not been changed")
        );

    }

}
