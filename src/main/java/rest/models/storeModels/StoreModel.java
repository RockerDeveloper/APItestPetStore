package rest.models.storeModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StoreModel {

    @JsonProperty("petId")
    private int petId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("id")
    private int id;

    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("complete")
    private boolean complete;

    @JsonProperty("status")
    private String status;

    @Getter
    public static enum Status {
        PLACED("placed"), APPROVED("approved"), DELIVERED("delivered"), STRING("string"), SOLD("sold");
        private String value;

        Status(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean rezult;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StoreModel storeModel = (StoreModel) o;
        rezult = petId == storeModel.getPetId() &&
                quantity == storeModel.getQuantity() &&
                id == storeModel.getId() &&
                status.equals(storeModel.getStatus()) &&
                shipDate.equals(storeModel.getShipDate());
        return rezult;
    }
}