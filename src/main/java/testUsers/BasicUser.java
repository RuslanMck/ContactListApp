package testUsers;

import lombok.Getter;

@Getter
public abstract class BasicUser {

    public BasicUser(String validationStatus, String firstName, String lastName, String email, String password) {
        this.validationStatus = validationStatus;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    String validationStatus;
    String firstName;
    String lastName;
    String email;
    String password;
}
