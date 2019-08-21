package rest.models.userModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

public class UserModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("userStatus")
    private int userStatus;


    @Override
    public boolean equals(Object o) {
        boolean rezult;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        rezult = firstName.equals(userModel.getFirstName()) &&
                lastName.equals(userModel.getLastName()) &&
                password.equals(userModel.getPassword()) &&
                userStatus == userModel.getUserStatus() &&
                phone.equals(userModel.getPhone()) &&
                id == userModel.getId() &&
                email.equals(userModel.getEmail()) &&
                username.equals(userModel.getUsername());
        return rezult;
    }
}