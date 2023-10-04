package api;

import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PotatoApi {public static void gettingCharLoc(String id){
    Response gettingCharLoc = given()
            .baseUri("https://reqres.in/")
            .when()
            .get("application/json;charset=UTF-8")
            .then()
            .log().all()
            .statusCode(200)
            .extract()
            .response();
    charLoc = new JSONObject(gettingCharLoc.getBody().asString()).getJSONObject("location").get("name").toString();
    charId = new JSONObject(gettingCharLoc.getBody().asString()).get("id").toString();
    charSpecies = new JSONObject(gettingCharLoc.getBody().asString()).get("species").toString();
}

}
