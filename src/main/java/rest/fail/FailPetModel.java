package rest.fail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)

public class FailPetModel {

    @JsonProperty("name")
    private char name;

    @JsonProperty("id")
    private int id;

    @JsonProperty("status")
    private int status;

    public boolean equals(Object o) {
        boolean rezult;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FailPetModel petModel = (FailPetModel) o;
        rezult = id == petModel.getId() &&
                name == petModel.getName() &&
                status == petModel.getStatus()
        ;
        return rezult;

    }
}
