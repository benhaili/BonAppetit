package com.example.testapi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
public class AdapterLv  extends ArrayAdapter<Produit> {
    int res;
    public AdapterLv(@NonNull Context context, int resource, @NonNull Produit[] objects) {
        super(context, resource, objects);
        res=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Produit produit= getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lvlayout, null);
        }
        TextView catTitre = convertView.findViewById(R.id.ProduitName);

        TextView prix = convertView.findViewById(R.id.Prix);
        ProgressBar progressBar= convertView.findViewById(R.id.progressBar);
        progressBar.setProgress(30);

        catTitre.setText(produit.nomProduit);
        prix.setText(""+produit.prixProduit);

        return convertView;
    }
    }

