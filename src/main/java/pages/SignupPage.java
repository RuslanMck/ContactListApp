package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class SignupPage {

    private final ElementsCollection signupForm = Selenide.$$x("//form[@id='add-user']//input");

    public void test(){
        System.out.println(signupForm.size());
        signupForm.get(1).shouldHave(Condition.attribute("placeholder", "Last Name"));

        for(SelenideElement element : signupForm){
            String elementId = element.attr("id");
            element.shouldHave(Condition.attribute("placeholder", SignupPagePlaceholders.valueOf(elementId.toUpperCase()).getPlaceholder()));
        }

    }

    public boolean signupFormIsVisible(){
        for (SelenideElement element : signupForm){
            if (!element.isDisplayed()){
                return false;
            }
        }
        return true;
    }



}
