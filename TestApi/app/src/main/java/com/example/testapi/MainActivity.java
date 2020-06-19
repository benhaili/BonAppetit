package com.example.testapi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    public static TextView tvData;
    public static ListView lv;



    public static ArrayList<Produit>listPr;
    private RequestQueue requestQueue;
   // private RequestQueue mQueue;
    Button btnShowData,send;
    String URL="http://192.168.2.17:8080/listCommandes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData=findViewById(R.id.data);
        btnShowData=findViewById(R.id.buttonAfficher);
     //   send=findViewById(R.id.sendData);
     //  lv=findViewById(R.id.lv);
        requestQueue=Volley.newRequestQueue(this);


        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchData fetchData=new FetchData();
                fetchData.execute();

               //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.id.lv,list);
               // jsonParse();
            }
        });
       /* send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "{"+
                        "\"nomProduit\":" + "\"TestPostAndroid\","+

                        "\"qte\":" + "1,"+
                        "\"prixTotal\":" + "158"+
                        "}";
                Submit(data);

            }

        });*/

    }
    private void Submit(String data)
    {
        final String savedata= data;


        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres=new JSONObject(response);
                    Toast.makeText(getApplicationContext(),objres.toString(),Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

                }
                Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

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
