package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import testUsers.BasicUser;

import java.util.Objects;

@Getter
public class SignupPage {


    private final ElementsCollection signupForm = Selenide.$$x("//form[@id='add-user']//input");
    private final SelenideElement submitButton = Selenide.$("#submit");
    private final SelenideElement validationErrorText = Selenide.$("#error");

    public void test() {
        System.out.println(signupForm.size());
        signupForm.get(1).shouldHave(Condition.attribute("placeholder", "Last Name"));

        for (SelenideElement element : signupForm) {
            String elementId = element.attr("id");
            element.shouldHave(Condition.attribute("placeholder", SignupPagePlaceholders.valueOf(elementId.toUpperCase()).getPlaceholder()));
        }

    }

    public boolean signupFormIsVisible() {
        for (SelenideElement element : signupForm) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void populateSignupForm(BasicUser user) {
        for (SelenideElement element : signupForm) {
            switch (Objects.requireNonNull(element.getAttribute("id"))) {
                case ("firstName"):
                    element.setValue(user.getFirstName());
                    break;
                case ("lastName"):
                    element.setValue(user.getLastName());
                    break;
                case ("email"):
                    element.setValue(user.getEmail());
                    break;
                case ("password"):
                    element.setValue(user.getPassword());
                    break;
                default:
                    System.out.println();

            }
        }
    }

    public String getErrorText(){
        validationErrorText.shouldBe(Condition.visible);
        return validationErrorText.getText();
    }


}
