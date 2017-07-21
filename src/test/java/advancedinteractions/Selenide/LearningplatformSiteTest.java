package advancedinteractions.Selenide;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.LearningPlatform.LoginPage;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by vbarduk on 21.07.2017.
 */
public class LearningplatformSiteTest extends SelenideTestBase{
    private String linkTestRail = "https://learningplatform.openenglish.com/login.html";
    private String login = "shiosaky@gmail.com";
    private String pass = "Test123";



    @BeforeClass
    public void preparation(){
        open(linkTestRail);
        LoginPage loginPage = new LoginPage();
        loginPage.closeCookiesPopup();

    }

    @Test
    public void loginTest (){

    }
}
