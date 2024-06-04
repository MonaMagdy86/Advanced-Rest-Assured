package testcases;

import POJO.AddAlbumPojo;
import apis.albumsApis;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Feature("Albums Feature")
public class AlbumsTest {
    @Story("Get All Albums")
    @Test(description = "Get All Albums")
    public void getAllAlbums(){

       Response response=  albumsApis.getAllAlbums();

       assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Get a Single Album")
    @Test(description = "Get a Single Album")
    public void getSingleAlbum(){
        Response response=albumsApis.geSingleAlbums();

        assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Add an Album")
    @Test(description = "Add an Album")
    public void addAlbum(){
        AddAlbumPojo addAlbum=new AddAlbumPojo("101","4","Mona Album");
        Response response=albumsApis.addAlbum(addAlbum);

        AddAlbumPojo returnedAlbum=response.body().as(AddAlbumPojo.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedAlbum.getTitle(),equalTo(addAlbum.getTitle()));
    }
    @Story("Delete an Album")
    @Test(description = "Delete an Album")
    public void deleteAlbum(){
        Response response=albumsApis.deleteAlbum();

        assertThat(response.statusCode(),equalTo(200));
    }
}
