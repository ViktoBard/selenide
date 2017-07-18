package selenide.pages.Google;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Viktor on 15.07.2017.
 */
public class GoogleSearchResultPage {
    private ElementsCollection linksResults = $$(".r>a");

    public ElementsCollection getLinksResults() {
        return linksResults;
    }
}
