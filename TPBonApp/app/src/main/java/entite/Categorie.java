package entite;
public class Categorie {
    private int idCategorie;
    private String nameCategorie;
    private String imageCategorie;
    private String descCategorie;
    public Categorie(int idCategorie, String nameCategorie, String imageCategorie, String descCategorie) {
        this.idCategorie = idCategorie;
        this.nameCategorie = nameCategorie;
        this.imageCategorie = imageCategorie;
        this.descCategorie = descCategorie;
    }
    public Categorie() {
    }
    public int getIdCategorie() {
        return idCategorie;
    }
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    public String getNameCategorie() {
        return nameCategorie;
    }
    public void setNameCategorie(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }
    public String getImageCategorie() {
        return imageCategorie;
    }
    public void setImageCategorie(String imageCategorie) {
        this.imageCategorie = imageCategorie;
    }
    public String getDescCategorie() {
        return descCategorie;
    }
    public void setDescCategorie(String descCategorie) {
        this.descCategorie = descCategorie;
    }
}
