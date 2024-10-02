package testUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignupUser {
    private String validationStatus;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public SignupUser() {
    }

    public SignupUser(String validationStatus, String firstName, String lastName, String email, String password) {
        this.validationStatus = validationStatus;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


}
