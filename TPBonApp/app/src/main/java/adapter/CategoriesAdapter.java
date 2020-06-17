package adapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tpbonapp.R;

import java.io.IOException;
import java.util.List;

import entite.Categorie;
public class CategoriesAdapter extends ArrayAdapter<Categorie> {
    int res;
    public CategoriesAdapter(@NonNull Context context, int resource, @NonNull List<Categorie> objects) {
        super(context, resource, objects);
        res = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Categorie categorie= getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_layout, null);
        }
        TextView catTitre = convertView.findViewById(R.id.menu_name);

        ImageView catImage = convertView.findViewById(R.id.menu_image);

        catTitre.setText(categorie.getNameCategorie());
        try {
            catImage.setImageDrawable(Drawable.createFromStream(getContext().getAssets().open("img/"+categorie.getImageCategorie()),null));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertView;
    }
}
