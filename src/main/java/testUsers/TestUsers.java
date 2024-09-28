package testUsers;

import lombok.Getter;

@Getter
public class TestUsers {

    private SignupUser userWithInvalidFirstName = new SignupUser("InvalidFirstName", "",
            "Lastname", "email@test.com", "passWORD123!");
    private SignupUser userWithInvalidLastName = new SignupUser("InvalidLastName", "Firstname",
            "", "email@test.com", "passWORD123!");
    private SignupUser userWithInvalidEmail = new SignupUser("InvalidEmail", "Firstname",
            "Lastname", "emailtest.com", "passWORD123!");
    private SignupUser userWithInvalidPassword = new SignupUser("InvalidPassword", "Firstname",
            "Lastname", "email@test.com", "");
    private SignupUser validUser = new SignupUser("InvalidPassword", "Firstname",
            "Lastname", "email+qwe@test.com", "passWORD123");
}
