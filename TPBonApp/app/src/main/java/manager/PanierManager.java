package manager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entite.Panier;
import entite.Produit;
import service.ConnexionBd;
public class PanierManager {
    private static String queryGetByMenu = "select * from panier";
    public static ArrayList<Panier> getPaniers(Context ctx) {
        ArrayList<Panier> panier = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor cursor = bd.rawQuery(queryGetByMenu, new String[]{});
        while (cursor.moveToNext()) {
            panier.add(new Panier(cursor.getInt(0), cursor.getInt(1)));
        }

        ConnexionBd.close();
        return panier;
    }

    private static String queryGetProduit = "select * from panier where idProduit=?";
    public static Panier produitExist(Context ctx, int idProduit)
    {
        Panier produitPanier = null;
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor cursor = bd.rawQuery(queryGetProduit, new String[]{String.valueOf(idProduit)});
        while (cursor.moveToNext()) {
            produitPanier = new Panier(cursor.getInt(0), cursor.getInt(1));
        }

        ConnexionBd.close();

        return produitPanier;
    }

    public static void deleteProduitPanier (Context ctx, int idProduit){
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.delete("panier", "id= ?", new String[]{String.valueOf(idProduit)});
        ConnexionBd.close();
    }

    private static String queryAdd = "insert into panier (idProduit, quantite) values (?, ?)";
    public static boolean add(Context context, Panier panier) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("idProduit", panier.getIdProduit());
        contentValues.put("quantite", panier.getQuantite());



        SQLiteDatabase bd = ConnexionBd.getBd(context);
        long id = bd.insert("panier", null, contentValues);
        bd.close();
        return id != -1;
    }
    }

