package apis;

import base.Request_Specification;
import data.Route;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;

public class usersApis {
    public static Response getAllUsers(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.USERS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response getSingleUser(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.USERS_ROUTE+"/"+2)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response getSingleUserNotFound(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.USERS_ROUTE+"/"+23)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response addUser( File body){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .body(body)
                .when()
                .post(Route.USERS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response updateUser(File body){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch(Route.USERS_ROUTE+"/"+10)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response deleteUser(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .delete(Route.USERS_ROUTE+"/"+2)
                .then()
                .log().all()
                .extract().response();
    }
}
