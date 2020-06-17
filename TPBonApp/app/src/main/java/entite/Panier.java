package entite;
public class Panier {
    private int idProduit;
    private int quantite;
    public Panier(int idProduit, int quantite) {
        this.idProduit = idProduit;
        this.quantite = quantite;
    }
    public Panier() {
    }
    public int getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
