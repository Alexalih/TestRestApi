import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularTests extends AbstractTest{
    @Test
    void WithoutParamsTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .when()
                .get(getBaseUrl()+getSearchRecipes())
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    void WithoutParamsBadauthTest(){
        JsonPath responce = given()
                .when()
                .get(getBaseUrl()+getSearchRecipes())
                .then()
                .assertThat()
                .statusCode(401)
                .extract().body().jsonPath();

    }

    @Test
    void WithQueryParamTest(){
        JsonPath responce = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pizza")
                .get(getBaseUrl()+getSearchRecipes())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().jsonPath();

    }
    @Test
    void With3ParamsTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "cake")
                .queryParam("maxReadyTime", 10)
                .queryParam("fillIngredients", true)
                .when()
                .get(getBaseUrl()+getSearchRecipes())
                .then()
                .assertThat()
                .statusCode(200);
    }
}
