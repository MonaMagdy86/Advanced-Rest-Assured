package testcases;

import POJO.AddTodoPojo;
import apis.todosApis;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Feature("Todo Feature")
public class TodosTest {
    @Story("Get All Todos")
    @Test(description = "Get All Todos")
    public void getAllTodos(){
        Response response=todosApis.getAllTodos();

        assertThat(response.statusCode(),equalTo(200));
}
    @Story("Get All Todos Completed")
    @Test(description = "Get All Todos Completed")
    public void getAllTodosCompleted(){
        Response response=todosApis.getAllTodosCompleted();

        assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Get a Single Todo")
    @Test(description = "Get a Single Todo")
    public void getSingleTodo(){
        Response response =todosApis.getSingleTodo();

        assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Add a Todo")
    @Test(description = "Add a Todo")
    public void addTodo(){
        AddTodoPojo addTodo=new AddTodoPojo("101","4","Mona Todo",true);
        Response response=todosApis.addTodo(addTodo);

        AddTodoPojo returnedTodo=response.body().as(AddTodoPojo.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedTodo.getTitle(),equalTo(addTodo.getTitle()));

    }
    @Story("Delete a Todo")
    @Test(description = "Delete a Todo")
    public void deleteTodo(){
        Response response= todosApis.deleteTodo();

        assertThat(response.statusCode(),equalTo(200));
    }
}