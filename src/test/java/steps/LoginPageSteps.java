package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginPageSteps {
    private final LoginPage LOGIN_PAGE = new LoginPage();

    @Step("Validate that the email input field is visible for user")
    public boolean checkEmailInputVisibility() {
        return LOGIN_PAGE.emailInputFieldVisibility();
    }

    @Step("Validate that the password input field is visible for user")
    public boolean checkPasswordInputVisibility(){
        return LOGIN_PAGE.passwordInputFieldVisibility();
    }

    @Step("Validate that the username can be populated and populated data is displayed in the email input field")
    public String checkUsernameCanBeInputted(String username) {
        LOGIN_PAGE.setUsername(username);
        return LOGIN_PAGE.getEmailInputValue();
    }

    @Step("Validate that the password can be populated and populated data is displayed in the email input field")
    public String checkPasswordCanBePopulated(String password){
        LOGIN_PAGE.setPassword(password);
        return LOGIN_PAGE.getPasswordInputValue();
    }

    @Step("Verify that the login submit button is visible for user")
    public boolean checkLoginSubmitButtonVisibility(){
        return LOGIN_PAGE.submitButtonVisibility();
    }

    @Step("Verify that the validation error message is displayed after trying to login with invalid login or password")
    public String checkValidationErrorMessage(String username, String password){
        LOGIN_PAGE.setUsername(username);
        LOGIN_PAGE.setPassword(password);
        LOGIN_PAGE.clickSubmitButton();
        return LOGIN_PAGE.getErrorMessageText();
    }

    @Step("Verify that the Sing Up button is visible for the user")
    public boolean checkSignUpButtonVisibility(){
        return LOGIN_PAGE.signupButtonVisibility();
    }

    @Step("Verify that the user is redirected to the correct page after clicking the Sign Up button")
    public String navigateToSignUpPage(){
        return LOGIN_PAGE.clickSignUpButton();
    }

}
