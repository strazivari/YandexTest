package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


public class PotatoApi {

    public static JSONObject getJSONFromFile(String path) throws IOException {
        // (1) Read JSON file into a string and attempt to parse it.
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        String json = new String(encoded, "UTF-8");
        json.put("name", "Tomato");
        json.put("job", "Eat maket");
        return null;
    }
    public static void postRequest() throws IOException {
    Response postRequest = given()
            .baseUri("https://reqres.in/")
            .when()
            .get("application/json;charset=UTF-8")
            .then()
            .log().all()
            .statusCode(200)
            .extract()
            .response();
    JSONObject potatoInfo = new JSONObject();
}
    public static void nameCheck() {
        Assertions.assertEquals(charLoc, lastCharLocation, "Вид не совпадает");
    }

    public static void jobCheck() {
        Assertions.assertNotEquals(charSpecies, lastCharSpecies, "Локации не совпадают");
    }
    public static void idCheck() {
        Assertions.assertNotEquals(charSpecies, lastCharSpecies, "Локации не совпадают");
    }
    public static void createdAtCheck() {
        Assertions.assertNotEquals(charSpecies, lastCharSpecies, "Локации не совпадают");
    }
}
