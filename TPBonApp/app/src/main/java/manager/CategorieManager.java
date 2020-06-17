package manager;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import entite.Categorie;
import service.ConnexionBd;
public class CategorieManager {
    private static String queryGetAll = "SELECT * from categorie";
    // private static String queryGetByIdCat = "select * from recette where idCategorie =?";
    //private static String queryGetById = "select * from recette where id =?";
    public static ArrayList<Categorie> getAll(Context context) {
        ArrayList<Categorie> retour = new ArrayList<>();
        Cursor cursor = ConnexionBd.getBd(context).rawQuery(queryGetAll, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("idCategorie"));
            String description = cursor.getString(cursor.getColumnIndex("descCategorie"));
            String nom = cursor.getString(cursor.getColumnIndex("nomCategorie"));
            String imagSrc = cursor.getString(cursor.getColumnIndex("imageCategorie"));
            // int icCat = cursor.getInt(cursor.getColumnIndex("idCategorie"));
            Categorie cat = new Categorie(id, nom, imagSrc,description);
            retour.add(cat);
        }
        return retour;
    }

}
