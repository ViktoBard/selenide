package selenide.pages.Gmail;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Viktor on 15.07.2017.
 */
public class GmailMainPageLogged {
    private SelenideElement checkLoginLocatorClick = $(By.cssSelector(".gb_8a.gbii"));
    private SelenideElement checkLoginEmailLocator = $(By.xpath(".//*[@class='gb_wb']"));
    private ElementsCollection checkMails = $$(By.xpath(".//*[@jsmodel='nXDxbd']"));

    public GmailMainPageLogged checkLoginLocator() {
        checkLoginLocatorClick.click();
        return this;
    }

    public GmailMainPageLogged checkLoginEmail(String login) {
        checkLoginEmailLocator.text().contains(login);
        return this;
    }
}
