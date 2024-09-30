package api;

import org.testng.annotations.Test;
import steps.ApiUserSteps;

public class ApiUserTests {

    private final ApiUserSteps API_USER_STEPS = new ApiUserSteps();

    @Test()
    public void verifyUserRegistration(){
        System.out.println("verifyUserRegistration()");
        API_USER_STEPS.createUser();
    }


    @Test(priority = 1)
    public void verifyUserLoginRequest(){
        System.out.println("verifyUserLoginRequest()");
        API_USER_STEPS.loginUser();
    }

    @Test(priority = 2)
    public void verifyUserDeletion(){
        System.out.println("verifyUserDeletion()");
        API_USER_STEPS.deleteUser();
    }
}
