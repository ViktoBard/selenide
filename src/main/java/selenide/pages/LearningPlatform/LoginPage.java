package selenide.pages.LearningPlatform;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by vbarduk on 21.07.2017.
 */
public class LoginPage {
    private SelenideElement cookiesLocator = $(By.xpath(".//*[@class='black-btn migration-continue-btn']"));
    private SelenideElement emailFieldLocator = $(By.xpath(".//*[@id='username']"));
    private SelenideElement passFieldLovator = $(By.xpath(".//*[@id='password']"));
    private SelenideElement logInButtonLocator = $(By.xpath(".//*[@id='login-btn']"));
    private SelenideElement errorMessage = $(By.xpath(".//*[@class='tooltipster-content']"));
    private SelenideElement registerButton = $("#sign-up");
    private SelenideElement rememberMeButton = $(By.xpath(".//*[@for='rememberLogin']"));

    public LoginPage closeCookiesPopup() {
        cookiesLocator.click();
        return this;
    }

    public LoginPage enterEmail(String email) {
        emailFieldLocator.val(email);
        return this;
    }

    public Condition checkEmail(String email) {
        emailFieldLocator.val();
        return value(email);
    }

    public Condition checkPass(String pass) {
        passFieldLovator.val();
        return value(pass);
    }

    public LoginPage enterPass(String pass) {
        passFieldLovator.val(pass);
        return this;
    }

    public LoginPage clickLogIn() {
        logInButtonLocator.click();
        return this;
    }

    public LoginPage checkErrorMessage(String errorMessage) {
        this.errorMessage.shouldHave(text(errorMessage));
        return this;
    }

    public LoginPage goToRegisrationPage() {
        registerButton.click();
        return this;
    }

    public LoginPage rememberLoginClick() {
        rememberMeButton.click();
        return this;
    }

    public LoginPage isSelected() {
        rememberMeButton.isSelected();
        return this;
    }
}