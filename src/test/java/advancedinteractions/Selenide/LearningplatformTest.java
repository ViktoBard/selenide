package advancedinteractions.Selenide;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.LearningPlatform.LoginPage;
import selenide.pages.LearningPlatform.MainPageAfterLogin;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static selenide.util.PropertiesCache.getProperty;

/**
 * Created by vbarduk on 21.07.2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LearningplatformTest extends SelenideTestBase {
    private String learningPlatformURL = getProperty("url.learningplatform");
    private String email = getProperty("email.correct");
    private String pass = getProperty("password.correct");

    private String successLoginURL = getProperty("url.after.login");
    private String incorrectEmail1 = getProperty("email.incorrect.1");
    private String incorrectEmail2 = getProperty("email.incorrect.2");
    private String incorrectEmail3 = getProperty("email.incorrect.3");
    private String incorrectPass = getProperty("password.incorrect.1");

    private String errorMessage1 = getProperty("message.incorrect.login");
    private String errorMessage2 = getProperty("message.incorrect.pass");

    private String faqURL = getProperty("url.faq");
    private String registrationURL = getProperty("url.registration");
    private String logoutURL = ("url.logout");


    @AfterMethod
    public void closeBrowser() {
        close();
    }

    public void successfulLoginTest() {
        open(learningPlatformURL);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup()
                .enterEmail(email)
                .enterPass(pass)
                .clickLogIn();
    }

    @Test
//  (enabled = false)
    public void a1successfulLoginTest() {
        open(learningPlatformURL);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup()
                .enterEmail(email)
                .enterPass(pass)
                .clickLogIn();
//        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(),successLoginURL);
//        or
        WebDriverRunner.getWebDriver()
                .getCurrentUrl()
                .contains(successLoginURL);
    }

    @Test
    public void a2failedLoginTest() {
        open(learningPlatformURL);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup()
                .enterEmail(incorrectEmail1)
                .enterPass(pass)
                .clickLogIn()
                .checkErrorMessage(errorMessage1);
    }

    @Test
    public void a3failedLoginTest() {
        open(learningPlatformURL);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup()
                .enterEmail(incorrectEmail2)
                .enterPass(pass)
                .clickLogIn()
                .checkErrorMessage(errorMessage1);
    }

    @Test
    public void a4failedLoginTest() {
        open(learningPlatformURL);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup()
                .enterEmail(incorrectEmail3)
                .enterPass(pass)
                .clickLogIn()
                .checkErrorMessage(errorMessage1);
    }

    @Test
    public void a5GoToFAQPageTest() {
        successfulLoginTest();
        MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin();
        mainPageAfterLogin
                .cancelExam()
                .closePopup()
                .goOnFAQPage();
        WebDriverRunner.getWebDriver()
                .getCurrentUrl()
                .contains(faqURL);
    }

    @Test
    public void a5goToRegistration() {
        open(learningPlatformURL);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup()
                .goToRegisrationPage();
        WebDriverRunner.getWebDriver()
                .getCurrentUrl()
                .contains(registrationURL);
    }

    @Test
    public void a6failedLoginTest() {
        open(learningPlatformURL);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup()
                .enterEmail(email)
                .enterPass(incorrectPass)
                .clickLogIn()
                .checkErrorMessage(errorMessage2);
    }

    @Test
    public void a7successfulLoginTestAndLogout() {
        open(learningPlatformURL);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup()
                .enterEmail(email)
                .enterPass(pass)
                .rememberLoginClick()
                .isSelected()
                .clickLogIn();
        MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin();
        mainPageAfterLogin.cancelExam()
                .closePopup()
                .logOut();
        WebDriverRunner.getWebDriver()
                .getCurrentUrl()
                .contains(logoutURL);
        loginPage.checkEmail(email);
        loginPage.checkPass(pass);
    }
}