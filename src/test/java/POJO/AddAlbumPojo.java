package POJO;

public class AddAlbumPojo {
    private String id;
    private String userId;
    private String title;
public AddAlbumPojo(){}
    public AddAlbumPojo(String id,String userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
