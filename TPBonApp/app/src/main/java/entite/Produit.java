package entite;
public class Produit {
    private int idProduit;
    private String nomProduit;
    private String imageProduit;
    private int idCategorie;
    private double prixProduit;
    public Produit(int idProduit, String nomProduit, String imageProduit, int idCategorie, double prixProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.imageProduit = imageProduit;
        this.idCategorie = idCategorie;
        this.prixProduit = prixProduit;
    }
    public Produit() {
    }
    public int getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
    public String getNomProduit() {
        return nomProduit;
    }
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
    public String getImageProduit() {
        return imageProduit;
    }
    public void setImageProduit(String imageProduit) {
        this.imageProduit = imageProduit;
    }
    public int getIdCategorie() {
        return idCategorie;
    }
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    public double getPrixProduit() {
        return prixProduit;
    }
    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }
}
