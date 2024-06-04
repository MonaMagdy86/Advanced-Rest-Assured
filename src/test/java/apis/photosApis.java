package apis;

import POJO.AddPhotoPojo;
import base.Request_Specification;
import data.Route;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class photosApis {
    public static Response getAllPhotos(){
      return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.PHOTOS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response getSinglePhoto(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.PHOTOS_ROUTE +"/"+40)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response addPhoto( AddPhotoPojo addPhoto){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .body(addPhoto)
                .when()
                .post(Route.PHOTOS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response deletePhoto(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .delete(Route.PHOTOS_ROUTE +"/"+40)
                .then()
                .log().all()
                .extract().response();
    }
}
