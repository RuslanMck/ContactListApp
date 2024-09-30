package steps;

import api.users.ApiUser;
import io.qameta.allure.Step;

public class ApiUserSteps {

    private final ApiUser API_USER = new ApiUser();
    private String authToken = null;

    @Step
    public void loginUser() {
        API_USER.logInUser();
    }

    @Step
    public void deleteUser() {
        API_USER.deleteUser(authToken);
    }

    @Step
    public void createUser() {
        authToken = API_USER.registerUser();
    }
}
