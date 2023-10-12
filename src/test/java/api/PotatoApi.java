package api;

import static api.ApiTemplate.testParams;
import static api.ApiTemplate.testParams2;
import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PotatoApi {
    private static JSONObject sendJson;

    @Step("JSON запрос PUT name, job. Получение объекта JSON")
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
                .filter(new AllureRestAssured())
                .post("api/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
    }

    @Step("Проверка имени")
    public static void nameCheck() {
        testParams(sendJson.getString("name"), "Tomato", "Wrong name");
    }

    @Step("Проверка професси")
    public static void jobCheck() {
        testParams(sendJson.getString("job"), "Eat maket", "Wrong job");
    }

    @Step("Проверка id")
    public static void idCheck() {
        testParams2(sendJson.getString("id"), "Wrong id");
    }

    @Step("Проверка даты создания")
    public static void createdAtCheck() {
        testParams2(sendJson.getString("createdAt"), "Wrong creation time");
    }
}
