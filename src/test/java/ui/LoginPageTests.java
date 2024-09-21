package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import dataProviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LoginPageSteps;

public class LoginPageTests {

    //    private String email = "asdasdasd";
    private LoginPageSteps loginPageSteps = new LoginPageSteps();
    private final String VALIDATION_ERROR_MESSAGE = "Incorrect username or password";


    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @Test(description = "Email input field is displayed")
    public void emailInputVisibilityCheck() {
        Assert.assertTrue(loginPageSteps.checkEmailInputVisibility());
    }

    @Test(description = "Email can be populated", dataProviderClass = LoginDataProvider.class,
            dataProvider = "usernameTestData")
    public void populateEmail(String email) {
        Assert.assertEquals(loginPageSteps.checkUsernameCanBeInputted(email), email);
    }

    @Test(description = "Password input field is displayed")
    public void passwordInputVisibilityCheck() {
        Assert.assertTrue(loginPageSteps.checkPasswordInputVisibility());
    }

    @Test(description = "Password can be populated", dataProviderClass = LoginDataProvider.class
    , dataProvider = "passwordTestData")
    public void populatePassword(String password){
        Assert.assertEquals(loginPageSteps.checkPasswordCanBePopulated(password), password);
    }

    @Test(description = "Login submit button is visible")
    public void loginSubmitButtonVisibilityCheck(){
        Assert.assertTrue(loginPageSteps.checkLoginSubmitButtonVisibility());
    }

    @Test(description = "Validation error is displayed", dataProviderClass = LoginDataProvider.class,
            dataProvider = "loginAndPasswordTestData")
    public void validationErrorMessageCheck(String username, String password){
        Assert.assertEquals(loginPageSteps.checkValidationErrorMessage(username, password), VALIDATION_ERROR_MESSAGE);
    }


}
