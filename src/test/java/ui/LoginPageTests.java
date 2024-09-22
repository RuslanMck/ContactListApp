package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dataProviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LoginPageSteps;

public class LoginPageTests {

    private final LoginPageSteps LOGIN_PAGE_STEPS = new LoginPageSteps();
    private final String VALIDATION_ERROR_MESSAGE = "Incorrect username or password";
    private final String SIGN_UP_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com/addUser";
    private final String LOGIN_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com/";


    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(LOGIN_PAGE_URL);
    }

    @Test(description = "Email input field is displayed")
    public void emailInputVisibilityCheck() {
        Assert.assertTrue(LOGIN_PAGE_STEPS.checkEmailInputVisibility());
    }

    @Test(description = "Email can be populated", dataProviderClass = LoginDataProvider.class,
            dataProvider = "usernameTestData")
    public void populateEmail(String email) {
        Assert.assertEquals(LOGIN_PAGE_STEPS.checkUsernameCanBeInputted(email), email);
    }

    @Test(description = "Password input field is displayed")
    public void passwordInputVisibilityCheck() {
        Assert.assertTrue(LOGIN_PAGE_STEPS.checkPasswordInputVisibility());
    }

    @Test(description = "Password can be populated", dataProviderClass = LoginDataProvider.class
    , dataProvider = "passwordTestData")
    public void populatePassword(String password){
        Assert.assertEquals(LOGIN_PAGE_STEPS.checkPasswordCanBePopulated(password), password);
    }

    @Test(description = "Login submit button is visible")
    public void loginSubmitButtonVisibilityCheck(){
        Assert.assertTrue(LOGIN_PAGE_STEPS.checkLoginSubmitButtonVisibility());
    }

    @Test(description = "Validation error is displayed", dataProviderClass = LoginDataProvider.class,
            dataProvider = "loginAndPasswordTestData")
    public void validationErrorMessageCheck(String username, String password){
        Assert.assertEquals(LOGIN_PAGE_STEPS.checkValidationErrorMessage(username, password), VALIDATION_ERROR_MESSAGE);
    }

    @Test(description = "Sign up button is displayed")
    public void signUpButtonVisibilityCheck(){
        Assert.assertTrue(LOGIN_PAGE_STEPS.checkSignUpButtonVisibility());
    }

    @Test(description = "Sign up page navigation check")
    public void singUpPageNavigationCheck(){
        Assert.assertEquals(LOGIN_PAGE_STEPS.navigateToSignUpPage(), SIGN_UP_PAGE_URL);
        WebDriverRunner.getWebDriver().navigate().to(LOGIN_PAGE_URL);
    }


}
