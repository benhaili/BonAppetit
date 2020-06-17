package com.example.tpbonapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import adapter.CategoriesAdapter;
import adapter.ProduitAdapter;
import manager.CategorieManager;
import manager.ProduitManager;
public class ListProduit extends AppCompatActivity {
    ListView lvPr;
    Context ctx;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produit);
        id= getIntent().getIntExtra("id",0);
        lvPr=findViewById(R.id.lvProduit);
         ProduitAdapter  adapter= new ProduitAdapter(this, R.layout.menu_layout, ProduitManager.getAll(this,id));
        lvPr.setAdapter(adapter);

    }
}
