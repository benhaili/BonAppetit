package com.example.tpbonapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

import entite.Produit;
import manager.ProduitManager;
public class FoodDetail extends AppCompatActivity {
    TextView foodName,foodPrice,foodDesc;
    ImageView foodImage;
    Produit p;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCar;
    ElegantNumberButton numberButton;
    Context ctx;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ctx=this;
        foodImage=findViewById(R.id.img_food);
        foodDesc=findViewById(R.id.foodDesc);
        foodPrice=findViewById(R.id.food_prix);
        foodName=findViewById(R.id.food_name);
        btnCar=findViewById(R.id.btnCart);
        numberButton=findViewById(R.id.numberBtn);
        collapsingToolbarLayout=findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);
        id= getIntent().getIntExtra("idProduit",0);
         p= ProduitManager.getById(ctx,id);
        foodName.setText(p.getNomProduit());
        foodPrice.setText(""+p.getPrixProduit()+"$");
        try {
            foodImage.setImageDrawable(Drawable.createFromStream(this.getAssets().open("img/"+p.getImageProduit()),null));
        } catch (IOException e) {
            e.printStackTrace();
        }





    }

}
