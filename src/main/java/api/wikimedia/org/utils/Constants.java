package api.wikimedia.org.utils;

/**
 * Constants
 **/
public class Constants {

    private Constants() {
    }

    //TestNG test group names
    public static final String SEARCH_TEST = "search-test";
    public static final String PAGE_TEST = "page-test";

    //Request Header Constants
    public static final String HEADER_KEY_AUTH = "Authorization";
    public static final String BEARER = "bearer ";

    //Location paths
    public static final String SCHEMA_FILE_LOCATION = "./src/main/resources/jsonSchemaFiles/";

    //Endpoints
    public static final String SEARCH_CONTENT_ENDPOINT = "core/v1/wikipedia/en/search/page";
    public static final String PAGE_DETAILS_ENDPOINT = "core/v1/wikipedia/en/page/";

    //Schema file names
    public static final String PAGE_DETAILS_SCHEMA = "PageDetailsSchema.json";
}
