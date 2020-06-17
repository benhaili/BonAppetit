package com.example.tpbonapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import adapter.CategoriesAdapter;
import manager.CategorieManager;
import service.ConnexionBd;
public class MenuCategories extends AppCompatActivity {
    ListView lvRecette;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_categories);
        ctx=this;
        ConnexionBd.copyBdFromAssets(this);
        lvRecette=findViewById(R.id.lvCat);


        CategoriesAdapter adapter = new CategoriesAdapter(this, R.layout.menu_layout, CategorieManager.getAll(this));
        lvRecette.setAdapter(adapter);

        lvRecette.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ctx,ListProduit.class);
                intent.putExtra("id",position+1);
                startActivity(intent);

            }
        });

    }
}
