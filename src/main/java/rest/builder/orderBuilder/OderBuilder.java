package rest.builder.orderBuilder;

import org.apache.commons.lang3.RandomStringUtils;
import rest.models.petModels.PetModel;
import rest.models.storeModels.StoreModel;

import static rest.utils.Utils.dateGenerationAndCasting;

public class OderBuilder {
    public static StoreModel orderBuilder(PetModel petModel) {
        int id = Integer.parseInt(RandomStringUtils.randomNumeric(1));
        return new StoreModel().builder()
                .petId(petModel.getId())
                .quantity(Integer.parseInt(RandomStringUtils.randomNumeric(3)))
                .id(id)
                .shipDate(dateGenerationAndCasting())
                .complete(true)
                .status(StoreModel.Status.APPROVED.getValue())
                .build();

    }
}
