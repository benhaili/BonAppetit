package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    private String nomProduit;
    private String imageProduit;
    private int idCategorie;
    private double prixProduit;
    public Produit(long idProduit, String nomProduit, String imageProduit, int idCategorie, double prixProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.imageProduit = imageProduit;
        this.idCategorie = idCategorie;
        this.prixProduit = prixProduit;
    }
    public Produit() {
    }

    

    public Produit(String nomProduit, String imageProduit, int idCategorie, double prixProduit) {
		super();
		this.nomProduit = nomProduit;
		this.imageProduit = imageProduit;
		this.idCategorie = idCategorie;
		this.prixProduit = prixProduit;
	}
	public long getIdProduit() {
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
