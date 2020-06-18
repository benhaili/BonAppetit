package adapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tpbonapp.R;

import java.io.IOException;
import java.util.List;
import entite.Panier;
import entite.Produit;
import manager.ProduitManager;
public class PanierAdapter extends ArrayAdapter <Panier> {
int lt ;
    Context cxt;
    public PanierAdapter(@NonNull Context context, int resource, @NonNull List<Panier> objects) {
        super(context, resource, objects);

    }
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {


            final Panier panier = (Panier)getItem(position);
            final Produit produit = ProduitManager.getById(getContext(), panier.getIdProduit());

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(    R.layout.panier_layout, null);
                ImageView img = convertView.findViewById(R.id.imgProduit);
                try {
                    img.setImageDrawable(Drawable.createFromStream(getContext().getAssets().open("img/"+ produit.getImageProduit()),null));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        TextView prixTotale = convertView.findViewById(R.id.prixTotale);
        prixTotale.setText(produit.getPrixProduit() * panier.getQuantite() + "$");


        return convertView;


    }
}