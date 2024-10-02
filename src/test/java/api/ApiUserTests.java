package api;

import org.testng.annotations.Test;
import steps.ApiUserSteps;

public class ApiUserTests {

    private final ApiUserSteps API_USER_STEPS = new ApiUserSteps();

    @Test(description = "Registration API request check")
    public void verifyUserRegistration(){
        API_USER_STEPS.createUser();
    }


    @Test(priority = 1, description = "Login API request check")
    public void verifyUserLoginRequest(){
        API_USER_STEPS.loginUser();
    }

    @Test(priority = 2, description = "Delete User API request check")
    public void verifyUserDeletion(){
        API_USER_STEPS.deleteUser();
    }
}
