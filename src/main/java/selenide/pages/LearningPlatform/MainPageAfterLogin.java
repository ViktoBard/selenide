package selenide.pages.LearningPlatform;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPageAfterLogin {
    private SelenideElement faqLocator = $(By.xpath(".//*[@id='header']//*[@href='/support/faq.html']"));
    private SelenideElement ayudaMenuLocator = $(By.xpath(".//*[@id='nav-help']//span"));
    private SelenideElement cancelExam = $(By.xpath(".//*[@id='confirmPopup']//a[1]"));
    private SelenideElement closePopup = $(".ui-icon.ui-icon-closethick");
    private SelenideElement cuentaMenuLocator = $(By.xpath(".//*[@id='account-menu-nav']"));
    private SelenideElement logOutLocator = $(By.xpath(".//*[@id='account-menu']//*[@href='/j_spring_security_logout']"));

    public MainPageAfterLogin cancelExam() {
        cancelExam.click();
        return this;
    }

    public MainPageAfterLogin closePopup() {
        closePopup.shouldBe(visible).click();
        closePopup.click();
        return this;
    }

    public MainPageAfterLogin goOnFAQPage() {
        ayudaMenuLocator.hover();
        faqLocator.click();
        return this;
    }
    public MainPageAfterLogin logOut() {
        cuentaMenuLocator.hover();
        logOutLocator.click();
        return this;
    }
}