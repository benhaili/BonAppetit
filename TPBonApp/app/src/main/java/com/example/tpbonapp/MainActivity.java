package com.example.tpbonapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button btnCon;
    Context ctx;
    Button btnCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnCon = findViewById(R.id.button_login);
        ctx = this;
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, MenuCategories.class);
                startActivity(intent);
            }
        });
    }
    private void fromMenuToAccueil() {
        ListView lvCat = (ListView) findViewById(R.id.lvCat);
        lvCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(MainActivity.this, MenuCategories.class)));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg = "";
        //Intent intent = new Intent(MainActivity.this, Settings.class);
        //startActivity(intent);
        int id = item.getItemId();
        switch (id) {
//            case R.id.menu_copyLien:
//                Toast.makeText(MainActivity.this, getString(R.string.menu_copyLien), Toast.LENGTH_LONG).show();
//                break;
            case R.id.menu_menu:
                Toast.makeText(MainActivity.this, getString(R.string.menu_menu), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, MenuCategories.class);
                startActivity(intent);
                break;
            case R.id.menu_panier:
                Toast.makeText(MainActivity.this, getString(R.string.menu_panier), Toast.LENGTH_LONG).show();


//               Intent panier = new Intent(MainActivity.this, PanierActivity.class); // Changer pour PANIER
//               startActivity(panier);

                // YAHYA ATTENTION!!!! Changer pour PANIER.class
                Intent panier = new Intent(MainActivity.this, PanierActivity.class); // Changer pour PANIER
                startActivity(panier);

                Toast.makeText(MainActivity.this, getString(R.string.menu_panier), Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_planCommande:
                Toast.makeText(MainActivity.this, getString(R.string.menu_planCommande), Toast.LENGTH_LONG).show();
                // YAHYA ATTENTION!!!! Changer pour COMMANDE.class
                //          Intent commande = new Intent(MainActivity.this, Commande.class);// Changer pour COMMANDE
                //         startActivity(commande);
                break;
            case R.id.menu_livraison:
                Toast.makeText(MainActivity.this, getString(R.string.menu_livraison), Toast.LENGTH_LONG).show();
                AlertDialog livraison = new AlertDialog.Builder(this)
                        .setTitle("Livraison de 'Bon Appétit'")
                        .setMessage("On fait la livraison 24/7 en 20 minutes!")
                        .setNeutralButton("C'est parfait!", null)
                        .show();
                break;
            case R.id.menu_nousContacter:
                Toast.makeText(MainActivity.this, getString(R.string.menu_nousContacter), Toast.LENGTH_LONG).show();
                AlertDialog nousContacter = new AlertDialog.Builder(this)
                        .setTitle("Adresse de 'Bon Appétit'")
                        .setMessage("2100 Boul. de Maisonneuve E, Montréal, QC H2K 4S1")
                        .setNeutralButton("D'accord!", null)
                        .show();
                break;
            case R.id.menu_horaire:
                Toast.makeText(MainActivity.this, getString(R.string.menu_horaire), Toast.LENGTH_LONG).show();
                AlertDialog horaire = new AlertDialog.Builder(this)
                        .setTitle("Horaire de 'Bon Appétit'")
                        .setMessage("On travaille pour votre plaisir 24/7")
                        .setNeutralButton("J'ai compris", null)
                        .show();
                break;
            case R.id.menu_seRegistrer:
                Intent login = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(login);
                Toast.makeText(MainActivity.this, getString(R.string.menu_seRegistrer), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_fermer:
                Toast.makeText(MainActivity.this, "Restez avec nous SVP", Toast.LENGTH_SHORT).show();
                final androidx.appcompat.app.AlertDialog dialog = new androidx.appcompat.app.AlertDialog.Builder(this)
                        .setTitle("Fermeture de 'Bon Appétit'")
                        .setMessage("Etês-vous sûr?")
                        .setPositiveButton("Oui", null)
                        .setNegativeButton("Cancel", null)
                        .show();
                Button positiveButton = dialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                }));
                break;
        }
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        return true;
    }
}
