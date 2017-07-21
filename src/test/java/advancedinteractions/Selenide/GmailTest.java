package advancedinteractions.Selenide;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.Gmail.GmailLoginPage;
import selenide.pages.Gmail.GmailMainPageLogged;
import selenide.pages.Gmail.GmailMainPageNotLogged;
import selenide.pages.Gmail.GmailPassPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Viktor on 12.07.2017.
 */
public class GmailTest extends SelenideTestBase {
    private String gmailLink = "https://www.google.com/intl/ru/gmail/about/";
    private String login = "7267193@gmail.com";
    private String pass = "Alive1990";


    @Test
    public void gmailTest() {
        open(gmailLink);
        WebDriverRunner.getWebDriver().getCurrentUrl().contains(gmailLink);
        GmailMainPageNotLogged gmailMainPageNotLogged = new GmailMainPageNotLogged();
        gmailMainPageNotLogged.clickOnLoginPage();

        GmailLoginPage gmailLoginPage = new GmailLoginPage();
        gmailLoginPage.enterLogin(login);

        GmailPassPage gmailPassPage = new GmailPassPage();
        gmailPassPage.enterPass(pass);

        GmailMainPageLogged gmailMainPageLogged = new GmailMainPageLogged();
        gmailMainPageLogged.checkLoginLocator();
        gmailMainPageLogged.getLinksResults().shouldHave(size(38));
        gmailMainPageLogged.checkLoginEmail(login);
    }
}
