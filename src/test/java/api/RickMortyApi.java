package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import static api.ApiTemplate.*;

public class RickMortyApi extends rickMortyParams {
    public static String characterLink = "/character/";
    public static String episodeLink = "/episode/";
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
        Response gettingCharLoc = characterModule(characterLink, id);
        charLoc = optionParseObj(gettingCharLoc, "location", "name");
        charId =  optionParse(gettingCharLoc, "id");
        charSpecies = optionParse(gettingCharLoc, "species");
        charName = optionParse(gettingCharLoc, "name");

        System.out.println("Персонаж: " + charName);
        System.out.println("id: " + charId);
        System.out.println("Вид: " + charSpecies);
        System.out.println("Локация: " + charLoc);
    }
    public static void gettingLastEpisode(){
        Response gettingLastEpisode = characterModule(characterLink, charId);

        int episode = optionParseArray(gettingLastEpisode, "episode");
        lastEpisode = optionParseString(gettingLastEpisode, "episode", episode);
    }
    public static void gettingCharLastEpisode(){
        Response gettingCharLastEpisode = characterModule(episodeLink, lastEpisode);
        int character = optionParseArray(gettingCharLastEpisode, "characters");
        lastChar = optionParseString(gettingCharLastEpisode, "characters", character);

        System.out.println("id последнего персонажа последней локации последнего эпизода, где появлялся " + charName + ": " + lastChar);
    }
    public static void gettingCharInfoLastEpisode(){
        Response gettingCharInfoLastEpisode = characterModule(characterLink, lastChar);
        lastCharName = optionParse(gettingCharInfoLastEpisode, "name");
        lastCharSpecies = optionParse(gettingCharInfoLastEpisode, "species");
        lastCharLocation = optionParseObj(gettingCharInfoLastEpisode, "location", "name");

        System.out.println("Имя данного персонажа: " + lastCharName);
        System.out.println("Вид данного персонажа: " + lastCharSpecies);
        System.out.println("Локация данного персонажа: " + lastCharLocation);
    }
    public static void speciesCheck(String charSpecies, String lastCharSpecies) {
        try {
            Assertions.assertEquals(charSpecies, lastCharSpecies, "Вид не совпадает");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
    public static void locCheck(String charLoc, String lastCharLocation) {
        try {
            Assertions.assertEquals(charLoc, lastCharLocation, "Локации не совпадают");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}
