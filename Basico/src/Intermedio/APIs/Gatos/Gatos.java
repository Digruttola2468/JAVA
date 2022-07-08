package Intermedio.APIs.Gatos;

public class Gatos {
    private String id;
    private String url;
    protected static final String apiKey = "DEMO-API-KEY";
    private String image;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getApiKey() {
        return apiKey;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    
}
