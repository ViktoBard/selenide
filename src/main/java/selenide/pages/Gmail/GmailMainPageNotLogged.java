package selenide.pages.Gmail;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Viktor on 15.07.2017.
 */
public class GmailMainPageNotLogged {
    private SelenideElement singInLocator = $(By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__sign-in"));

    public void clickOnLoginPage() {
        singInLocator.click();
    }
}
