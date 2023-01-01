package methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Pet;
import org.apache.http.client.HttpResponseException;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Method {

    public Response postMethod(Pet pet) {
        RestAssured.baseURI = "https://petstore.swagger.io";
        String body = pet.toString();

        Response response1 = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .log().all()
                .request("POST", "/v2/pet")
                .then()
                .extract().response();

        return response1;

    }

    public Response getMethod(String id) {

        RestAssured.baseURI = "https://petstore.swagger.io";
        Response response = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .request("GET", "/v2/pet/"+ id +"")
                .then()
                .extract().response();

        return response;

    }
    public Response putMethod(Pet pet) {
        RestAssured.baseURI = "https://petstore.swagger.io";
        String body = pet.toString();

        Response response1 = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .log().all()
                .request("PUT", "/v2/pet")
                .then()
                .extract().response();

        return response1;
    }

    public Response deleteMethod(String id) {
        Response response1 = null;

            response1 = given()
                    .contentType("application/json")
                    .accept(ContentType.JSON)
                    .when()
                    .log().all()
                    .request("DELETE", "/v2/pet/"+id)
                    .then()
                    .extract().response();

        return response1;
    }
}
