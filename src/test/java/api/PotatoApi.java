package api;

import static api.ApiTemplate.testPotato;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PotatoApi {
    private static JSONObject sendJson;
    public static JSONObject getJSONFromFile() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get("src/test/resources/potato.json"));
        JSONObject json = new JSONObject(encoded, "UTF-8");
        json.put("name", "Tomato");
        json.put("job", "Eat maket");
        sendJson = new JSONObject(postRequest(json).getBody().asString());
        return null;
    }
    public static Response postRequest(JSONObject json) {
        return given()
                .baseUri("https://reqres.in/")
                .contentType("application/json;charset=UTF-8")
                .when()
                .body(json.toString())
                .post("api/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
}
    public static void nameCheck() {
        testPotato("name", "Tomato", "Wrong name");
    }
    public static void jobCheck() {
        testPotato("job", "Eat maket", "Wrong job");
    }
    public static void idCheck() {
        testPotato("id", "Wrong id");
    }
    public static void createdAtCheck() {
        testPotato("createdAt", "Wrong creation time");
    }
}
