package rest.fail;

import org.apache.commons.lang3.RandomStringUtils;

public class FailPetBuilder {

    public static FailPetModel failPetBuilder(){
        return FailPetModel.builder()
                .id(Integer.parseInt(RandomStringUtils.randomNumeric(3 )))
                .name(Integer.parseInt(RandomStringUtils.randomNumeric(1 )))
                .status(0)
                .category(Integer.parseInt(RandomStringUtils.randomNumeric(1 )))
                .build();


    }
}
