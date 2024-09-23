package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;


@Getter
public class LoginPage {

    private final SelenideElement EMAIL_INPUT_FIELD = Selenide.$("#email");
    private final SelenideElement PASSWORD_INPUT_FIELD = Selenide.$("#password");
    private final SelenideElement SUBMIT_BUTTON = Selenide.$("#submit");
    private final SelenideElement VALIDATION_ERROR_MESSAGE = Selenide.$("#error");
    private final SelenideElement SIGN_UP_BUTTON = Selenide.$("#signup");

    public boolean emailInputFieldVisibility() {
        return EMAIL_INPUT_FIELD.is(Condition.visible);
    }

    public boolean passwordInputFieldVisibility() {
        return PASSWORD_INPUT_FIELD.is(Condition.visible);
    }

    public boolean submitButtonVisibility() {
        return SUBMIT_BUTTON.is(Condition.visible);
    }

    public boolean errorMessageVisibility() {
        return VALIDATION_ERROR_MESSAGE.is(Condition.visible);
    }

    public boolean signupButtonVisibility() {
        return SIGN_UP_BUTTON.is(Condition.visible);
    }

    public void setUsername(String username) {
        EMAIL_INPUT_FIELD.setValue(username);
    }

    public void setPassword(String password) {
        PASSWORD_INPUT_FIELD.setValue(password);
    }

    public void clickSubmitButton() {
        SUBMIT_BUTTON.click();
    }

    public String getEmailInputValue() {
        return EMAIL_INPUT_FIELD.getValue();
    }

    public String getPasswordInputValue() {
        return PASSWORD_INPUT_FIELD.getValue();
    }

    public String getErrorMessageText() {
        VALIDATION_ERROR_MESSAGE.shouldBe(Condition.visible);
        return VALIDATION_ERROR_MESSAGE.getText();
    }

    public String clickSignUpButton() {
        SIGN_UP_BUTTON.click();
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

}
