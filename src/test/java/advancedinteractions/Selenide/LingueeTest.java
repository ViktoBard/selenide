package advancedinteractions.Selenide;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.LingueeMainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class LingueeTest extends SelenideTestBase{
    private String linguee = "http://www.linguee.de/deutsch-englisch/";
    private String word = "Hallo";

    @Test
    public void searchWordLingueeTest(){
        open(linguee);
        LingueeMainPage lingueeMainPage = new LingueeMainPage();


        switchTo().frame("iframeResult");
        $(By.xpath("html/body/button")).click();

        lingueeMainPage.searchText(word);
    }
}
