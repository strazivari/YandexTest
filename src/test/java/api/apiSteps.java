package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class apiSteps {
    public static String charLoc;
    public static String charId;
    public static String lastEpisode;
    public static String lastChar;
    public static String episodeLastChar;
    public static void gettingCharLoc(String id){
        Response gettingCharLoc = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + id)
                .then()
                .log().all()
                .extract()
                .response();
        charLoc = new JSONObject(gettingCharLoc.getBody().asString()).getJSONObject("location").get("name").toString();
        charId = new JSONObject(gettingCharLoc.getBody().asString()).get("id").toString();
    }
    public static void gettingLastEpisode(){
        Response gettingLastEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + charId)
                .then()
                .extract()
                .response();
        int episode = (new JSONObject(gettingLastEpisode.getBody().asString()).getJSONArray("episode").length()-1);
        lastEpisode = new JSONObject(gettingLastEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
        System.out.println(lastEpisode);
    }
    public static void gettingCharLastEpisode(){
        Response gettingCharLastEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/episode/" + lastEpisode)
                .then()
                .log().all()
                .extract()
                .response();
        int character = (new JSONObject(gettingCharLastEpisode.getBody().asString()).getJSONArray("characters").length()-1);
        lastChar = new JSONObject(gettingCharLastEpisode.getBody().asString()).getJSONArray("characters").get(character).toString().replaceAll("[^0-9]", "");
        System.out.println(lastChar);
    }
    public static void gettingCharInfoLastEpisode(){
        Response gettingCharInfoLastEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + lastChar)
                .then()
                .log().all()
                .extract()
                .response();
        
        String obj = new JSONObject(gettingCharInfoLastEpisode.getBody().asString()).getJSONObject("species").toString();

    }
}
