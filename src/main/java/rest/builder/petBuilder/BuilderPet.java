package rest.builder.petBuilder;

import org.apache.commons.lang3.RandomStringUtils;

import rest.models.petModels.CategoryModel;
import rest.models.petModels.PetModel;
import rest.models.petModels.TagsItemModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BuilderPet {
    private static List<String> petStatus;
    private static Random randomNumber;

    public static PetModel petBuilder() {
        randomNumber = new Random();
        petStatus = new ArrayList<>();
        petStatus.add("available");
        petStatus.add("pending");
        petStatus.add("sold");
        //int id = Integer.parseInt(RandomStringUtils.randomNumeric(3));//629496
        int id = 12;
        String name = RandomStringUtils.randomAlphabetic(7);
        return PetModel.builder()
                .id(id)
                .category(
                        CategoryModel.builder()
                                .id(id)
                                .name(name)
                                .build()
                )
                .name(name)
                .photoUrls(Collections.singletonList(RandomStringUtils.randomAlphabetic(10)))
                .tags(
                        Collections.singletonList(TagsItemModel.builder()
                                .id(id)
                                .name(name)
                                .build())
                )
                .status(petStatus.get(randomNumber.nextInt(petStatus.size())))
                .build();
    }
}
