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
        try {
            Assertions.assertEquals(sendJson.getString("name"), "Tomato", "Wrong name");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
    public static void jobCheck() {
        try {
            Assertions.assertEquals(sendJson.getString("job"), "Eat maket", "Wrong job");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
    public static void idCheck() {
        try {
            Assertions.assertNotNull(sendJson.getString("id"), "Wrong id");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createdAtCheck() {
        try {
            Assertions.assertNotNull(sendJson.getString("createdAt"), "Wrong creation time");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}
