package api.wikimedia.org.tests.search;

import api.wikimedia.org.base.ApiBase;
import api.wikimedia.org.utils.Constants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static api.wikimedia.org.utils.Constants.SEARCH_CONTENT_ENDPOINT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.hasItem;

public class SearchContentTest extends ApiBase {

    @DataProvider
    public Object[][] dataProviderSearchValidations() {
        return new Object[][]{
                // search text, expected title
                {"furry rabbits", "Sesame Street"},
                {"scary monsters", "Carlos Alomar"}  //This is an additional test case to elaborate the effective usage of data providers
        };
    }

    @Test(dataProvider = "dataProviderSearchValidations", groups = {Constants.API_REG, Constants.SEARCH_TEST})
    public void validateSearchContent(String searchQuery, String expectedTitle) {
        sendGetRequestWithQuery("q", searchQuery, SEARCH_CONTENT_ENDPOINT)
                .then()
                    .log().everything()
                    .assertThat()
                    .statusCode(SC_OK)
                    .body("pages.title", hasItem(expectedTitle));
    }
}
