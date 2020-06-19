package adapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tpbonapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import entite.Panier;
import entite.Produit;
import manager.ProduitManager;
public class PanierAdapter extends ArrayAdapter <Panier> {
int lt ;
public String URL="http://192.168.2.17:8080/listCommandes";
public RequestQueue requestQueue;
    Context cxt;
    public PanierAdapter(@NonNull Context context, int resource, @NonNull List<Panier> objects) {
        super(context, resource, objects);

    }
    @NonNull
    @Override
    public View getView(final int position, @NonNull View convertView, @NonNull ViewGroup parent) {


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
        final Button btnValider= convertView.findViewById(R.id.valider);
        prixTotale.setText(produit.getPrixProduit() * panier.getQuantite() + "$");
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestQueue=Volley.newRequestQueue(getContext());
                String data = "{"+
                        "\"nomProduit\":\"" +produit.getNomProduit()+"\","+

                        "\"qte\":" + panier.getQuantite()+","+
                        "\"prixTotal\":" + produit.getPrixProduit()*panier.getQuantite()+""+

                        "}";
                Submit(data);
                btnValider.setEnabled(false);


               // Toast.makeText(getContext(), "position : "+position, Toast.LENGTH_SHORT).show();
            }
        });



        return convertView;


    }
     void Submit(String data)
    {
        final String savedata= data;


        requestQueue = Volley.newRequestQueue(getContext().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres=new JSONObject(response);
                    Toast.makeText(getContext().getApplicationContext(),objres.toString(),Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    Toast.makeText(getContext().getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

                }
                Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext().getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                Log.v("VOLLEY", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return savedata == null ? null : savedata.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    //Log.v("Unsupported Encoding while trying to get the bytes", data);
                    return null;
                }
            }

        };
        requestQueue.add(stringRequest);
    }

}