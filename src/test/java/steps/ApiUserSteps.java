package steps;

import api.users.ApiUser;
import io.qameta.allure.Step;

public class ApiUserSteps {

    private final ApiUser API_USER = new ApiUser();
    private String authToken = null;

    @Step("Verify that user can log in using API request")
    public void loginUser() {
        API_USER.logInUser();
    }

    @Step("Verify that user can be deleted using API request")
    public void deleteUser() {
        API_USER.deleteUser(authToken);
    }

    @Step("Verify that new user can be created using API request")
    public void createUser() {
        authToken = API_USER.registerUser();

    }
}
