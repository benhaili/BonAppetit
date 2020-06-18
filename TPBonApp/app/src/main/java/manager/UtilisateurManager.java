package manager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import entite.Produit;
import entite.Utilisateur;
import service.ConnexionBd;
public class UtilisateurManager {
    private static String queryGetById = "select * from user where nom =? and password=?";
    public static Boolean seConnecter(Context context, String nom,String pass) {
        boolean retour = true;

        Cursor cursor = ConnexionBd.getBd(context).rawQuery(queryGetById, new String[] { nom ,pass });
        if( cursor != null && cursor.moveToFirst() ){
            retour= true;
        }
        //  while (cursor.moveToNext()) {
        // if(cursor.getInt(cursor.getColumnIndex("id"))==idD){

else{
    retour=false;
        }
        return retour;
    }

    public static boolean add(Context context, Utilisateur user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nom", user.getNom());
        contentValues.put("email", user.getEmail());
        contentValues.put("tel", user.getTel());
        contentValues.put("password", user.getPassword());
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        long id = bd.insert("user", null, contentValues);
        bd.close();
        return id != -1;
    }

}
