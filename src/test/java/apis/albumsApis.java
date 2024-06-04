package apis;

import POJO.AddAlbumPojo;
import base.Request_Specification;
import data.Route;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class albumsApis {
    public static Response getAllAlbums(){
       return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.ALBUMS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response geSingleAlbums(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.ALBUMS_ROUTE+"/"+6)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response addAlbum( AddAlbumPojo addAlbum){
        return given()
                .spec(Request_Specification.getReqSpec())
                .body(addAlbum)
                .when()
                .post(Route.ALBUMS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response deleteAlbum(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .delete(Route.ALBUMS_ROUTE+"/"+6)
                .then()
                .log().all()
                .extract().response();
    }

}
