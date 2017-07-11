import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class GoogleSearchTest {

    private String googleSearch = "https://www.google.com.ua/";
    private String searchText = "Selenium";
    private String searchText2 = " ";
    private WebDriver webDriver;
    private String firstLinkString = "Selenium - Web Browser Automation";
    private String inputText = "text";

    @Test
    public void searchTest() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Temp\\Programming\\chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get(googleSearch);
        By searchLocator = By.id("lst-ib");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();

        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchText));

        List<WebElement> elements;
        elements = webDriver.findElements(By.cssSelector(".r>a"));
        for (WebElement i : elements) {
            System.out.println(i.isDisplayed());
            assertTrue(i.getText().contains(searchText));
        }

//        List<WebElement> elements = webDriver.findElements(By.ByTagName.tagName("a"));
//
//        assertTrue(!elements.isEmpty());
//        System.out.println(elements.size());


//        By textLocator = By.xpath("//*[contains(text(),'Selenium - Web Browser Automation')]");
//        WebElement text = webDriver.findElement(textLocator);
//        assertTrue(text.getText().contains(firstLinkString));
//        text.click();
//
//        By searchField2 = By.id("q");
//        WebElement searchField3 = webDriver.findElement(searchField2);
//        searchField3.sendKeys(inputText);
//        By clickGo = By.id("submit");
//        WebElement clikGoElement = webDriver.findElement(clickGo);
//        clikGoElement.click();

//webDriver.close();
        webDriver.quit();
    }
}