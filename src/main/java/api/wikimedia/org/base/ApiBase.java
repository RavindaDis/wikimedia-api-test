package api.wikimedia.org.base;

import api.wikimedia.org.utils.Constants;
import api.wikimedia.org.utils.EnvConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;


/**
 * Base API Class - This needs to be extended for API testing related classes
 **/
public abstract class ApiBase {

    private static final Logger log = LoggerFactory.getLogger(ApiBase.class);

    /**
     * Create request specification
     *
     * @return built request specification
     */
    public static RequestSpecification createRequestSpec() {
        EnvConfig envConfig = ConfigFactory.create(EnvConfig.class);

        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri(envConfig.url());
        requestBuilder.addHeader(Constants.HEADER_KEY_AUTH, Constants.BEARER.concat(envConfig.token()));
        log.info("Creating request specification");
        return requestBuilder.build();
    }


    /**
     * Send a basic get request with a path param
     *
     * @param endpoint  - endpoint as a String
     * @param pathParam - path parameter as a String
     * @return response
     */
    public static Response sendGetRequestWithPath(String endpoint, String pathParam) {
        return given()
                .spec(createRequestSpec())
                .when()
                .get(endpoint.concat(pathParam));
    }

    /**
     * Send a basic get request with a query parameter
     *
     * @param queryKey   - key of the query parameter
     * @param queryValue - value of the query parameter
     * @param endpoint   - endpoint as a String
     * @return response object
     */
    public static Response sendGetRequestWithQuery(String queryKey, String queryValue, String endpoint) {
        return given()
                .spec(createRequestSpec())
                .queryParam(queryKey, queryValue)
                .when()
                .get(endpoint);
    }
}
