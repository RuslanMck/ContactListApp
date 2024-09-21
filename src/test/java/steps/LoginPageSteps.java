package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.Waiter;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginPageSteps {
    Waiter waiter = new Waiter();
    private LoginPage loginPage = new LoginPage();

    @Step("Validate that the email input field is visible for user")
    public boolean checkEmailInputVisibility() {
        return loginPage.emailInputFieldVisibility();
    }

    @Step("Validate that the password input field is visible for user")
    public boolean checkPasswordInputVisibility(){
        return loginPage.passwordInputFieldVisibility();
    }

    @Step("Validate that the username can be populated and populated data is displayed in the email input field")
    public String checkUsernameCanBeInputted(String username) {
        loginPage.setUsername(username);
        return loginPage.getEmailInputValue();
    }

    @Step("Validate that the password can be populated and populated data is displayed in the email input field")
    public String checkPasswordCanBePopulated(String password){
        loginPage.setPassword(password);
        return loginPage.getPasswordInputValue();
    }

    @Step("Verify that the login submit button is visible for user")
    public boolean checkLoginSubmitButtonVisibility(){
        return loginPage.submitButtonVisibility();
    }

    @Step("Validate that the validation error message is displayed after trying to login with invalid login or password")
    public String checkValidationErrorMessage(String username, String password){
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickSubmitButton();
        //TODO Add waiter to see the error message
        return loginPage.getErrorMessageText();
    }

}
