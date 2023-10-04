package api;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(sendJson.getString("name"), "Tomato");
    }
    public static void jobCheck() {
       Assertions.assertNotEquals(sendJson.getString("job"), "Eat maket");
    }
    public static void idCheck() {
        Assertions.assertNotNull(sendJson.getString("id"));
   }
    public static void createdAtCheck() {
        Assertions.assertNotNull(sendJson.getString("createdAt"));
    }
}
