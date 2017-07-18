package selenide.pages.Gmail;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Viktor on 15.07.2017.
 */
public class GmailLoginPage {
    private SelenideElement loginElement = $(By.id("identifierId"));


    public GmailLoginPage enterLogin(String login) {
        loginElement.val(login).pressEnter();
        //ретёрн, возрврати страницу (ссылку на обьект)
        return this;
    }
}
