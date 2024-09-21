package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginPageSteps {
    private LoginPage loginPage = new LoginPage();

    @Step("Validate that the email input field is visible for user")
    public boolean checkEmailInputVisibility(){
        return loginPage.emailInputFieldVisibility();
    }
    @Step("Validate that the email input field is visible for user")
    public String checkEmailCanBeInputted(String email){
        loginPage.inputEmail(email);
        return loginPage.getEmailInputValue();
    }

}
