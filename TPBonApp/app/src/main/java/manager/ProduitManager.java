package manager;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import entite.Categorie;
import entite.Produit;
import service.ConnexionBd;
public class ProduitManager {
    private static String queryGetAll = "SELECT * from produit where idCategorie=?";

    //private static String queryGetById = "select * from recette where id =?";
    public static ArrayList<Produit> getAll(Context context, int idCat) {
        ArrayList<Produit> retour = new ArrayList<>();
        Cursor cursor = ConnexionBd.getBd(context).rawQuery(queryGetAll, new String[] { idCat + "" });

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("idProduit"));
            String nom = cursor.getString(cursor.getColumnIndex("nomProduit"));
            double prix = cursor.getDouble(cursor.getColumnIndex("prix"));
            String imagSrc = cursor.getString(cursor.getColumnIndex("imageProduit"));
             int idCategorie = cursor.getInt(cursor.getColumnIndex("idCategorie"));
            Produit pr = new Produit(id, nom, imagSrc,idCategorie,prix);
            retour.add(pr);
        }
        return retour;
    }
    private static String queryGetById = "select * from produit where idProduit =?";
    public static Produit getById(Context context, int idProduit) {
        Produit retour = new Produit();

        Cursor cursor = ConnexionBd.getBd(context).rawQuery(queryGetById, new String[] { idProduit + "" });
        if( cursor != null && cursor.moveToFirst() ){
            retour.setIdProduit(cursor.getInt(cursor.getColumnIndex("idProduit"))); ;
            retour.setNomProduit(cursor.getString(cursor.getColumnIndex("nomProduit")));
            retour.setImageProduit(cursor.getString(cursor.getColumnIndex("imageProduit")));
            retour.setPrixProduit(cursor.getDouble(cursor.getColumnIndex("prix")));
            cursor.close();
        }
        //  while (cursor.moveToNext()) {
        // if(cursor.getInt(cursor.getColumnIndex("id"))==idD){


        return retour;
    }
}
