package selenide.pages.Google;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Viktor on 15.07.2017.
 */
public class GoogleSearchPage {
    private SelenideElement search = $(By.name("q"));

    public GoogleSearchPage searchFor(String searchText) {
        search.val(searchText).pressEnter();
        //ретёрн, возрврати страницу (ссылку на обьект)
        return this;
    }
}