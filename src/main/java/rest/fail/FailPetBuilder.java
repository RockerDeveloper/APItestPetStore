package rest.fail;

public class FailPetBuilder {

    public static FailPetModel failPetBuilder(){
        return FailPetModel.builder()
                .id(Integer.parseInt("asddsa"))
                .name('5')
                .status(0)
                .build();


    }
}
