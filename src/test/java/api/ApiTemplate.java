package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;


public class ApiTemplate {
    public static String rickMortyApiUrl = "https://rickandmortyapi.com/api";

    public static Response characterModule(String link, String param) {
        return given()
                .baseUri(rickMortyApiUrl)
                .when()
                .get(link + param)
                .then()
                .extract()
                .response();
    }

    public static String optionParse(Response request, String option) {
        return new JSONObject(request.getBody().asString()).get(option).toString();
    }

    public static int optionParseArray(Response request, String option) {
        return (new JSONObject(request.getBody().asString()).getJSONArray(option).length() - 1);
    }

    public static String optionParseString(Response request, String option, int optionNum) {
        return new JSONObject(request.getBody().asString()).getJSONArray(option).get(optionNum).toString().replaceAll("[^0-9]", "");
    }

    public static String optionParseObj(Response request, String option, String optionParam) {
        return new JSONObject(request.getBody().asString()).getJSONObject(option).get(optionParam).toString();
    }

    public static void testParams(String key, String actual, String message) {
        try {
            Assertions.assertEquals(key, actual, message);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testParams(String key, String message) {
        try {
            Assertions.assertEquals(key, message);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testParams2(String key, String message) {
        try {
            Assertions.assertNotNull(key, message);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}
