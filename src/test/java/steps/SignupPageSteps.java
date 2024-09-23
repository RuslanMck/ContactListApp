package steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SignupPage;
import pages.SignupPagePlaceholders;

public class SignupPageSteps {

    private final SignupPage SIGNUP_PAGE = new SignupPage();

    @Step("Verify if the sign up form is visible for the user")
    public boolean checkSignupFormVisibility() {
        return SIGNUP_PAGE.signupFormIsVisible();
    }


    /**
     * Method returns true if the placeholder in the input field matches the placeholder from the SignupPagePlaceholders Enum
     * It takes collection of elements (input fields) from the SignupPage.java class by using SIGNUP_PAGE.getSignupForm()
     * Then assign the value of the "id" attribute to a local String variable elementId.
     * Then is compares value of the "placeholder" attribute of an element (input field) with value from the
     * SignupPagePlaceholders Enum. The value from the enum is taken by using elementId in the upper case.
     * The name of the variables in enum should match the value of the "id" attribute in uppercase
     *
     * @return
     */
    @Step("Verify if the placeholder text matches the expected text")
    public boolean verifyThePlaceholdersText() {
        for (SelenideElement element : SIGNUP_PAGE.getSignupForm()) {
            String elementId = element.attr("id");
            boolean placeholderMatches = false;
            placeholderMatches = element.getAttribute("placeholder").equals(SignupPagePlaceholders.valueOf(elementId.toUpperCase()).getPlaceholder());
            if (!placeholderMatches) {
                return false;
            }
        }
        return true;
    }


}
