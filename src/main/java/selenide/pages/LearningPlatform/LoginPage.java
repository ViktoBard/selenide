package selenide.pages.LearningPlatform;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide.pages.Google.GoogleSearchPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by vbarduk on 21.07.2017.
 */
public class LoginPage {
    private SelenideElement cookiesLocator = $(By.xpath(".//*[@class='black-btn migration-continue-btn']"));

    public LoginPage closeCookiesPopup() {
        cookiesLocator.click();
        //ретёрн, возрврати страницу (ссылку на обьект)
        return this;
    }

}
