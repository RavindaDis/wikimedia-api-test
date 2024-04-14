package api.wikimedia.org.tests.search;

import api.wikimedia.org.base.ApiBase;
import api.wikimedia.org.utils.Constants;
import org.testng.annotations.Test;

import java.io.File;

import static api.wikimedia.org.helpers.PageDetailsHelper.getPageKeyFromTitle;
import static api.wikimedia.org.utils.Constants.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

public class PageDetailsTest extends ApiBase {

    @Test(groups = {Constants.PAGE_TEST})
    public void validatePageDetails() {
        String title = "Sesame Street";
        String pageKey = getPageKeyFromTitle(title);

        sendGetRequestWithPath(PAGE_DETAILS_ENDPOINT, pageKey)
                .then()
                    .log().everything()
                    .assertThat()
                    .statusCode(SC_OK)
                    .body(matchesJsonSchema(new File(SCHEMA_FILE_LOCATION.concat(PAGE_DETAILS_SCHEMA))))
                    .body("latest.timestamp", greaterThan("2023-08-17"));
    }
}
