package selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LingueeMainPage {
    private SelenideElement searchLocator = $(By.xpath(".//*[@id='queryinput']"));

    public LingueeMainPage searchText(String word) {
        searchLocator.val(word);
        return this;
    }
}
