package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LoginPageSteps;

public class LoginPageTests {

    private String email = "asdasdasd";
    private LoginPageSteps loginPageSteps = new LoginPageSteps();


    @BeforeClass
    public void setUp(){
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @Test
    public void check(){
        Assert.assertTrue(loginPageSteps.checkEmailInputVisibility());
    }

    @Test
    public void setAdnCheckLogin(){
        Assert.assertEquals(loginPageSteps.checkEmailCanBeInputted(email), email);
    }


}
