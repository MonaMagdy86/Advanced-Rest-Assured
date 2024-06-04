package apis;

import POJO.AddTodoPojo;
import base.Request_Specification;
import data.Route;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class todosApis {
    public static Response getAllTodos(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.TODOS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response getAllTodosCompleted(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .queryParam("completed","true")
                .when()
                .get(Route.TODOS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response getSingleTodo(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.TODOS_ROUTE+"/"+10)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response addTodo( AddTodoPojo addTodo){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .body(addTodo)
                .when()
                .post(Route.TODOS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response deleteTodo(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .delete(Route.TODOS_ROUTE+"/"+10)
                .then()
                .log().all()
                .extract().response();
    }
}
