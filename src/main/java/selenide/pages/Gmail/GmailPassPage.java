package selenide.pages.Gmail;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Viktor on 15.07.2017.
 */
public class GmailPassPage {
    private SelenideElement passElement = $(By.xpath(".//*[@id='password']//input"));


    public GmailPassPage enterPass(String pass) {
        passElement.val(pass).pressEnter();
        //ретёрн, возрврати страницу (ссылку на обьект)
        return this;
    }
}
