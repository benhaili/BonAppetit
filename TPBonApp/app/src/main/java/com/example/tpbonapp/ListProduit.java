package com.example.tpbonapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.CategoriesAdapter;
import adapter.ProduitAdapter;
import entite.Produit;
import manager.CategorieManager;
import manager.ProduitManager;
public class ListProduit extends AppCompatActivity {
    ArrayList<Produit> listPr;
    ListView lvPr;
    Context ctx;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produit);
        ctx=this;
        id= getIntent().getIntExtra("id",0);

        lvPr=findViewById(R.id.lvProduit);
         ProduitAdapter  adapter= new ProduitAdapter(this, R.layout.menu_layout, ProduitManager.getAll(this,id));
        lvPr.setAdapter(adapter);
        listPr=ProduitManager.getAll(this,id);

        lvPr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Produit pr=  listPr.get(position);
                Intent intent = new Intent(ctx,FoodDetail.class);
                intent.putExtra("idProduit",pr.getIdProduit());
                startActivity(intent);

                //Toast.makeText(ctx, "Name : "+pr.getIdProduit(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
