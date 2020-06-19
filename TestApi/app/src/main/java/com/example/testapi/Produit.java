package com.example.testapi;
import org.json.JSONObject;
public class Produit {
    String nomProduit;
    String imageProduit;
    int     idCategorie;
    double prixProduit;
    public Produit(String nomProduit, String imageProduit, int idCategorie, double prixProduit) {
        this.nomProduit = nomProduit;
        this.imageProduit = imageProduit;
        this.idCategorie = idCategorie;
        this.prixProduit = prixProduit;
    }

}
