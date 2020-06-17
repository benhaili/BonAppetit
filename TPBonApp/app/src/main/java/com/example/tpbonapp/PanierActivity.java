package com.example.tpbonapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.PanierAdapter;
import entite.Panier;
import manager.PanierManager;
import manager.ProduitManager;
public class PanierActivity extends AppCompatActivity {
    ListView lst;
    TextView total_prix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Context cxt ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        lst=findViewById(R.id.listeProduit);

        ArrayList<Panier> listePanier = PanierManager.getPaniers(this);

        total_prix = findViewById(R.id.prixTotale);
        double prixTotal = 0;

        //total_prix.setText("Total : "+prixTotal+" $");

        //this.lst  = findViewById(R.id.listeProduit);
        PanierAdapter panierAdaptater = new PanierAdapter(this, R.layout.panier_layout, listePanier);

        lst.setAdapter(panierAdaptater);
    }
}



