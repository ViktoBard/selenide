import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Viktor on 12.07.2017.
 */
public class GmailTest {
    private String gmailLink = "https://www.google.com/intl/ru/gmail/about/";
    private String login = "7267193@gmail.com";
    private String pass = "Alive1990";

    private WebDriver webDriver;

    By singInLocator = By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__sign-in");
    By singInFieldLocator = By.id("identifierId");
    By passInLocator = By.xpath(".//*[@id='password']//input");
    By nextEmailButtonLocator = By.xpath(".//*[@id='identifierNext']");
    By nextPassButtonLocator = By.xpath(".//*[@id='passwordNext']");
    By checkMails = By.xpath(".//*[@jsmodel='nXDxbd']");
    By checkLoginEmailLocator = By.xpath(".//*[@class='gb_wb']");
    By checkLoginLocatorClick = By.cssSelector(".gb_8a.gbii");

    @Test
    public void gmailTest() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Temp\\Programming\\chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        webDriver.get(gmailLink);
        Assert.assertEquals(gmailLink, webDriver.getCurrentUrl());

        WebElement singInButton = webDriver.findElement(singInLocator);
        singInButton.click();

        WebElement singInField = webDriver.findElement(singInFieldLocator);
        singInField.sendKeys(login);
        WebElement nextEmailButton = webDriver.findElement(nextEmailButtonLocator);
        nextEmailButton.click();

        WebElement passField = webDriver.findElement(passInLocator);
        passField.sendKeys(pass);
        WebElement nextPassButton = webDriver.findElement(nextPassButtonLocator);
        nextPassButton.click();

        WebElement loginlocator = webDriver.findElement(checkLoginLocatorClick);
        loginlocator.click();
        WebElement text = webDriver.findElement(checkLoginEmailLocator);
        if (text.getText().contains(login)) {
            System.out.println("Login is successful");
        } else {
            System.out.println("Login is failed");
        }

        List<WebElement> elements;
        elements = webDriver.findElements(checkMails);
        for (WebElement i : elements) {
            System.out.println(i);
            assertTrue(i.isDisplayed());
        }

        webDriver.quit();
    }
}
