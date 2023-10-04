package api;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class apiSteps {
    public static void someApiFunc(String id) {
        RequestSpecification req = given()
                .baseUri("https://rickandmortyapi.com/api");
        req.get("/character/"+id)
                .then()
                .log().all()
                .extract()
                .response();
                        


    }
}
