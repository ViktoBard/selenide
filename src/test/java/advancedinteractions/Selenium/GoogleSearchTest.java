package advancedinteractions.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import selenium.core.WebDriverTestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;


@Features("Google Search")
@Stories({"Web-777"})
public class GoogleSearchTest extends WebDriverTestBase{

    private String googleSearch = "https://www.google.com.ua/";
    private String searchText = "Selenium";
    private String firstLinkString = "Selenium - Web Browser Automation";
    private String inputText = "text";

    @Title("Searches fot text on Google")
    @Test
    public void searchTest() {
        webDriver.get(googleSearch);
        By searchLocator = By.id("lst-ib");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();

        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchText));

        List <WebElement> elements;
        elements = webDriver.findElements(By.xpath("//a[contains(text(),'Selenium')]"));
        for (WebElement i : elements) {
            System.out.println(i);
            assertTrue(i.isDisplayed());
            assertTrue(i.getText().contains(searchText));
        }

        By textLocator = By.xpath("//*[contains(text(),'Selenium - Web Browser Automation')]");
        WebElement text = webDriver.findElement(textLocator);
        assertTrue(text.getText().contains(firstLinkString));
        text.click();

        By searchField2 = By.id("q");
        WebElement searchField3 = webDriver.findElement(searchField2);
        searchField3.sendKeys(inputText);
        By clickGo = By.id("submit");
        WebElement clikGoElement = webDriver.findElement(clickGo);
        clikGoElement.click();

//        webDriver.close();
        webDriver.quit();
    }
}