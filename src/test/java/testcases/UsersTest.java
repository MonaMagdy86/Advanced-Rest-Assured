package testcases;

import apis.usersApis;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Feature("User Feature")
public class UsersTest {

    @Story("Get All Users")
    @Test(description = "Get All Users")
    public void getAllUsers(){
     Response response= usersApis.getAllUsers();

        assertThat(response.statusCode(),equalTo(200));


    }
    @Story("Get a Single User")
    @Test(description = "Get a Single User")
    public void getSingleUser(){
        Response response= usersApis.getSingleUser();

       assertThat(response.statusCode(),equalTo(200));
       assertThat(response.path("name"),equalTo("Ervin Howell"));
    }
    @Story("Get a Single User Not Found")
    @Test(description = "Get a Single User Not Found")
    public void getSingleUserNotFound(){
        Response response= usersApis.getSingleUserNotFound();

        assertThat(response.statusCode(),equalTo(404));
    }
    @Story("Add an User")
    @Test(description = "Add an User")
    public void addUser(){
        File body=new File("src\\test\\resources\\AddUser.json");
        Response response= usersApis.addUser(body);

       assertThat(response.statusCode(),equalTo(201));
       assertThat(response.path("name"),equalTo("Mona"));
    }
    @Story("Update a User")
    @Test(description = "Update a User")
    public void UpdateUser(){
        File body=new File("src\\test\\resources\\UpdateUser.json");
        Response response= usersApis.updateUser(body);

       assertThat(response.statusCode(),equalTo(200));
       assertThat(response.path("name"),equalTo("Magdy"));
    }
    @Story("Delete a User")
    @Test(description = "Delete a User")
    public void DeleteUser(){
        Response response= usersApis.deleteUser();

        assertThat(response.statusCode(),equalTo(200));

    }
}
