package selenide.pages.Stylus;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide.pages.Google.GoogleSearchPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Viktor on 15.07.2017.
 */
public class StylusMainPage {
    private SelenideElement search = $(By.name("q"));

    public StylusMainPage searchFor(String searchText) {
        search.val(searchText).pressEnter();
        //ретёрн, возрврати страницу (ссылку на обьект)
        return this;
    }
}
