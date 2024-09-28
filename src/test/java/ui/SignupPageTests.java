package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import steps.SignupPageSteps;
import testUsers.TestUsers;
import validationErrors.ValidationErrors;

public class SignupPageTests {

    private final String SIGNUP_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com/addUser";
    private final SignupPageSteps SIGNUP_PAGE_STEPS = new SignupPageSteps();
    private final TestUsers TEST_USERS = new TestUsers();
    private final ValidationErrors validationErrors = new ValidationErrors();

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(SIGNUP_PAGE_URL);
    }

    @Test(description = "Sign up form is displayed")
    public void signupFormVisibilityCheck() {
        Assert.assertTrue(SIGNUP_PAGE_STEPS.checkSignupFormVisibility());
    }

    @Test(description = "Placeholders text is correct")
    public void placeholdersTextCheck() {
        Assert.assertTrue(SIGNUP_PAGE_STEPS.verifyThePlaceholdersText());
    }

    @Test(description = "Firstname input validation error text is correct")
    public void firstnameInputValidationCheck() {
        Assert.assertEquals(SIGNUP_PAGE_STEPS.signupFormValidation(TEST_USERS.getUserWithInvalidFirstName()), validationErrors.getFIRSTNAME_VALIDATION_ERROR());
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @Test(description = "Lastname input validation error text is correct")
    public void lastnameInputValidationCheck() {
        Assert.assertEquals(SIGNUP_PAGE_STEPS.signupFormValidation(TEST_USERS.getUserWithInvalidLastName()), validationErrors.getLASTNAME_VALIDATION_ERROR());
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @Test(description = "Email input validation error text is correct")
    public void emailInputValidationCheck() {

        Assert.assertEquals(SIGNUP_PAGE_STEPS.signupFormValidation(TEST_USERS.getUserWithInvalidEmail()), validationErrors.getEMAIL_VALIDATION_ERROR());
        WebDriverRunner.getWebDriver().navigate().refresh();

    }

    @Test(description = "Password input validation error text is correct")
    public void passwordInputValidationCheck() {
        Assert.assertEquals(SIGNUP_PAGE_STEPS.signupFormValidation(TEST_USERS.getUserWithInvalidPassword()), validationErrors.getPASSWORD_VALIDATION_ERROR());
        WebDriverRunner.getWebDriver().navigate().refresh();

    }
    @Test(description = "Valid user submit check")
    public void validUSerSubmitCheck() {
        SIGNUP_PAGE_STEPS.signupValidUser(TEST_USERS.getValidUser());

    }

    @AfterClass
    public void tearDown(){
        //TODO Execute API request to delete signed up user. Authorization token can be taken from the POST Log In User
        // request in the 'Contact List Documentation' Postman collection
    }
}
