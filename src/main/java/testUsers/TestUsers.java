package testUsers;

import lombok.Getter;

@Getter
public class TestUsers {

    private SignupUser userWithInvalidFirstName = new SignupUser("InvalidFirstName", "",
            "Lastname", "some_email@test.com", "passWORD123!");
    private SignupUser userWithInvalidLastName = new SignupUser("InvalidLastName", "Firstname",
            "", "some_email@test.com", "passWORD123!");
    private SignupUser userWithInvalidEmail = new SignupUser("InvalidEmail", "Firstname",
            "Lastname", "some_emailtest.com", "passWORD123!");
    private SignupUser userWithInvalidPassword = new SignupUser("InvalidPassword", "Firstname",
            "Lastname", "some_email@test.com", "");
    private SignupUser validUser = new SignupUser("InvalidPassword", "Firstname",
            "Lastname", "some_email@test.com", "passWORD123");
}
