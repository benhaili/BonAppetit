package com.example.tpbonapp;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.PanierAdapter;
import entite.Panier;
import manager.PanierManager;
import manager.ProduitManager;

import static com.example.tpbonapp.R.id.food_name;
public class PanierActivity extends AppCompatActivity {
    ListView lst;
    TextView total_prix;
    Button mg;
    Button valider;
    ImageView img;
    EditText quantite;
    EditText description;
    EditText msg;
    Button envoi;
    Context cxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        lst = findViewById(R.id.listeProduit);
        quantite = findViewById(R.id.numberBtn);
        mg = findViewById(R.id.retour);
        mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ArrayList<Panier> listePanier = PanierManager.getPaniers(this);
        total_prix = findViewById(R.id.prixTotale);
        double prixTotal = 0;
        //total_prix.setText("Total : "+prixTotal+" $");
        //this.lst  = findViewById(R.id.listeProduit);
        PanierAdapter panierAdaptater = new PanierAdapter(this, R.layout.panier_layout, listePanier);
        lst.setAdapter(panierAdaptater);
    }
    @SuppressLint("WrongViewCast")
    private void initActivity() {
        description = findViewById(food_name);
        quantite = findViewById(R.id.numberBtn);
        envoi = findViewById(R.id.valider);
    }
    private void createOnclick() {
        envoi.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage(description.getText().toString(), null, quantite.getText().toString(), null, null);
                Toast.makeText(cxt, "Name : Commande envoyer", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


