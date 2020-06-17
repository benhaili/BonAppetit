package service;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import sqliteHelper.CategorieHelper;
public class ConnexionBd {
    private static SQLiteDatabase bd;
    public static String nomBd = "dbTp";
    private static int version = 1;
    public static SQLiteDatabase getBd(Context ctx) {
        CategorieHelper helper = new CategorieHelper(ctx, nomBd, null, version);
        bd = helper.getWritableDatabase();
        return bd;
    }
    public static void close() {
        bd.close();
    }
    public static void copyBdFromAssets(Context context) {

        File bdApp = context.getDatabasePath(nomBd);
        if (bdApp.exists())
            return;

        AssetManager assetManager = context.getAssets();
        try {
            InputStream in = assetManager.open("dbTp.db");
            FileOutputStream out = new FileOutputStream(bdApp);
            byte[] buffer = new byte[256];
            while (in.read(buffer) != -1) {
                out.write(buffer);
                buffer = new byte[256];
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
