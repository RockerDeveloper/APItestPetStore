package rest.assertions.petAssertions;

import rest.models.petModels.PetModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionBodyPet {

//    private static PetModel actual;
//    private  SoftAssert softAssertions = new SoftAssert();
//
//    public static PetAssert assertThat(PetModel petModel) {
//        actual = petModel;
//        return new PetAssert();
//    }
//
//    public PetAssert hasId(int id) {
//
//        int actualId = actual.getId();
//        softAssertions.assertEquals(actualId, id);
//
//        return this;
//
//    }
//
//    public PetAssert hasName(String name) {
//        String actualName = actual.getName();
//        softAssertions.assertEquals(actualName, name);
//        return this;
//    }
//
//    public PetAssert hasCategory(CategoryModel categoryModel) {
//        CategoryModel actualCategoryModel = actual.getCategory();
//        softAssertions.assertEquals(actualCategoryModel, categoryModel);
//        softAssertions.assertAll();
//        return this;
//    }
//
//    public PetAssert hasListOfPhotoUrls(List<String> photooUrls) {
//
//        List<String> actualPhotoUrls = actual.getPhotoUrls();
//        softAssertions.assertEquals(actualPhotoUrls, photooUrls);
//
//        return this;
//
//    }
//
//    public PetAssert hasListOfTagsItems(List<TagsItemsModel> tagsItemsModelList) {
//
//
//        List<TagsItemsModel> actualTagsItemsList = actual.getTagsItems();
//        for (int i = 0; i < actualTagsItemsList.size(); i++) {
//            softAssertions.assertEquals(actualTagsItemsList.get(i), tagsItemsModelList.get(i));
//        }
//        softAssertions.assertAll();
//        return this;
//    }
//
//
//    public PetAssert hasStatus(String status) {
//        String actualStatus = actual.getStatus();
//        softAssertions.assertEquals(actualStatus, status);
//        softAssertions.assertAll();
//        return this;
//    }
//
//
//    public void isEqualTo(PetModel petModel) {
//        softAssertions.assertEquals(actual, petModel);
//
//        softAssertions.assertAll();
//    }

    public void assertPet(PetModel expected, PetModel actual) {
        assertAll("The elements of two objects are not equal",
                () -> assertEquals(expected.getId(), actual.getId(), "IDs are different"),
                () -> assertEquals(expected.getName(), actual.getName(), "Names are different"),
                () -> assertEquals(expected.getCategory().getId(), actual.getCategory().getId(), "IDs are different in category"),
                () -> assertEquals(expected.getCategory().getName(), actual.getCategory().getName(), "Names are different in category"),
                () -> assertEquals(expected.getPhotoUrls(), actual.getPhotoUrls(), "PhotoURLs are different"),
                () -> assertEquals(expected.getTags(), actual.getTags(), "Tags are different"),
                () -> assertEquals(expected.getStatus(), expected.getStatus(), "Status are different"));
    }

    public void assertEqualsPet(PetModel expected, PetModel actual) {
        assertEquals(expected, actual);
    }
//    public void responseAssertions(StoreModel expected, StoreModel actual){
//        assertAll(
//                ()-> assertEquals(expected.getBody(),actual.getBody()),
//                ()-> assertEquals(200,actual.getStatusCode()),
//                ()-> assertEquals(expected.getContentType(),)
//        );
//
//    }
//    public void checkIfStatusCodeIs200(StoreModel response){
//        assertEquals(200,response.getStatusCode());
//    }
//    public void
}
