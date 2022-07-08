package Intermedio.APIs.Gatos;

public class GatosFav {
    
    private String id;
    private String image_id;
    private String apikey = new Gatos().getApiKey();
    private Imagex image;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getImage_id() {
        return image_id;
    }
    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
    public String getApikey() {
        return apikey;
    }
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
    public Imagex getImage() {
        return image;
    }
    public void setImage(Imagex image) {
        this.image = image;
    }

    
}
