package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class RickMortyApi {
    public static String charLoc;
    public static String charId;
    public static String lastEpisode;
    public static String lastChar;
    public static String lastCharSpecies;
    public static String lastCharLocation;
    public static String charSpecies;
    public static String charName;
    public static String lastCharName;

    public static void rickMorty(String id){
        Response gettingCharLoc = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + id)
                .then()
                .extract()
                .response();
        charLoc = new JSONObject(gettingCharLoc.getBody().asString()).getJSONObject("location").get("name").toString();
        charId = new JSONObject(gettingCharLoc.getBody().asString()).get("id").toString();
        charSpecies = new JSONObject(gettingCharLoc.getBody().asString()).get("species").toString();
        charName = new JSONObject(gettingCharLoc.getBody().asString()).get("name").toString();
        System.out.println("Персонаж: " + charName);
        System.out.println("id: " + charId);
        System.out.println("Вид: " + charSpecies);
        System.out.println("Локация: " + charLoc);
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
    }
    public static void gettingCharLastEpisode(){
        Response gettingCharLastEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/episode/" + lastEpisode)
                .then()
                .extract()
                .response();
        int character = (new JSONObject(gettingCharLastEpisode.getBody().asString()).getJSONArray("characters").length()-1);
        lastChar = new JSONObject(gettingCharLastEpisode.getBody().asString()).getJSONArray("characters").get(character).toString().replaceAll("[^0-9]", "");
        System.out.println("id последнего персонажа последней локации последнего эпизода, где появлялся " + charName + ": " + lastChar);
    }
    public static void gettingCharInfoLastEpisode(){
        Response gettingCharInfoLastEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + lastChar)
                .then()
                .extract()
                .response();
        lastCharName = new JSONObject(gettingCharInfoLastEpisode.getBody().asString()).get("name").toString();
        lastCharSpecies = new JSONObject(gettingCharInfoLastEpisode.getBody().asString()).get("species").toString();
        lastCharLocation = new JSONObject(gettingCharInfoLastEpisode.getBody().asString()).getJSONObject("location").get("name").toString();
        System.out.println("Имя данного персонажа: " + lastCharName);
        System.out.println("Вид данного персонажа: " + lastCharSpecies);
        System.out.println("Локация данного персонажа: " + lastCharLocation);
    }

    public static void speciesCheck() {
        Assertions.assertNotEquals(charSpecies, lastCharSpecies, "Вид не совпадает");
    }
    public static void locCheck() {
        Assertions.assertEquals(charLoc, lastCharLocation, "Локации не совпадают");
    }
}
