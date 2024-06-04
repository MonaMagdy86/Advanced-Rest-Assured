package testcases;

import POJO.AddPhotoPojo;
import apis.photosApis;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Feature("Photos Feature")
public class PhotosTest {
    @Story("Get All Photos")
    @Test(description = "Get All Photos")
    public void getAllPhotos(){
        Response response=photosApis.getAllPhotos();

        assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Get a Single Photo")
    @Test(description = "Get a Single Photo")
    public void getSinglePhoto(){
        Response response=photosApis.getSinglePhoto();

          assertThat(response.statusCode(),equalTo(200));
          assertThat(response.path("albumId"),equalTo(1)) ;
          assertThat(response.path("title"),equalTo("est quas voluptates dignissimos sint praesentium nisi recusandae"));

    }
    @Story("Add a Photo")
    @Test(description = "Add a Photo")
    public void addPhoto(){
        AddPhotoPojo addPhoto=new AddPhotoPojo("5001","2","MonaPhoto","https://via.placeholder.com/600/810b141","https://via.placeholder.com/150/810b14");
       Response response=photosApis.addPhoto(addPhoto);


       AddPhotoPojo returnedPhoto= response.body().as(AddPhotoPojo.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedPhoto.getAlbumId(),equalTo("2"));
        assertThat(returnedPhoto.getTitle(),equalTo("MonaPhoto"));

    }
    @Story("Delete a Photo")
    @Test(description = "Delete a Photo")
    public void deletePhoto(){
        Response response= photosApis.deletePhoto();

        assertThat(response.statusCode(),equalTo(200));

    }
}
