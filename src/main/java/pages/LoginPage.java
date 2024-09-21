package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;


@Getter
public class LoginPage {

    private SelenideElement emailInputField = Selenide.$("#email");
    private SelenideElement passwordInputField = Selenide.$("#password");
    private SelenideElement submitButton = Selenide.$("#submit");
    private SelenideElement errorMessage = Selenide.$("#error");
    private SelenideElement signupButton = Selenide.$("#signup");

    public boolean emailInputFieldVisibility() {
        return emailInputField.is(Condition.visible);
    }

    public boolean passwordInputFieldVisibility() {
        return passwordInputField.is(Condition.visible);
    }

    public boolean submitButtonVisibility() {
        return submitButton.is(Condition.visible);
    }

    public boolean errorMessageVisibility() {
        return errorMessage.is(Condition.visible);
    }

    public boolean signupButtonVisibility() {
        return signupButton.is(Condition.visible);
    }

    public void inputEmail(String email){
        emailInputField.setValue(email);
    }

    public void inputPassword(String password){
        passwordInputField.setValue(password);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getEmailInputValue(){
        return emailInputField.getValue();
    }


}
