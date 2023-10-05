package api;

import static api.ApiTemplate.testParams;
import static api.ApiTemplate.testParams2;
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
        testParams(sendJson.getString("name"), "Tomato", "Wrong name");
    }
    public static void jobCheck() {
        testParams(sendJson.getString("job"), "Eat maket", "Wrong job");
    }
    public static void idCheck() {
        testParams2(sendJson.getString("id"), "Wrong id");
    }
    public static void createdAtCheck() {
        testParams2(sendJson.getString("createdAt"), "Wrong creation time");
    }
}
