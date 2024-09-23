package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import steps.SignupPageSteps;

public class SignupPageTests {

    private final String SIGNUP_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com/addUser";
    private final SignupPageSteps SIGNUP_PAGE_STEPS = new SignupPageSteps();

    @BeforeClass
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(SIGNUP_PAGE_URL);
    }

    @Test(description = "Sign up form is displayed")
    public void signupFormVisibilityCheck(){
        Assert.assertTrue(SIGNUP_PAGE_STEPS.checkSignupFormVisibility());
    }

    @Test(description = "Placeholders text is correct")
    public void placeholdersTextCheck(){
        Assert.assertTrue(SIGNUP_PAGE_STEPS.verifyThePlaceholdersText());
    }
}
