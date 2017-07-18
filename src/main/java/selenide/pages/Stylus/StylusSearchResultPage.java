package selenide.pages.Stylus;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Viktor on 15.07.2017.
 */
public class StylusSearchResultPage {
    private ElementsCollection linksResults = $$(By.xpath(".//span[contains(text(),'Sony Xperia Z2')]"));

    public ElementsCollection getLinksResults() {
        return linksResults;
    }
}
