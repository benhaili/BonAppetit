package com.example.testapi;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
public class FetchData extends AsyncTask<Void, Void, ArrayList<Produit>> {
    String data="";
    String parsedData="";
    String singleParsed="";
    ArrayList<Produit> produits;
    @Override
    protected ArrayList<Produit> doInBackground(Void... voids) {
        try {
            URL url=new URL("http://192.168.2.17:8080/listCommandes");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=connection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while (line!=null){
                line=bufferedReader.readLine();
                data=data+line;


            }
            JSONArray jsonArray=new JSONArray(data);

            for (int i=0;i<jsonArray.length();i++){
                JSONObject object= (JSONObject) jsonArray.get(i);
                singleParsed="NomProduit :"+object.get("nomProduit")+"\n"+
                        "qte :"+object.get("qte")+"\n"+
                        "prixTotal :"+object.get("prixTotal")+"\n";

                parsedData=parsedData+singleParsed+"\n";
              //  ArrayList<Produit> produits=new ArrayList<Produit>();
                //produits.add(new Produit((String)object.get("nomProduit"),(String)object.get("imageProduit"),(int)object.get("idCategorie"),(Double) object.get("prixProduit")));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return produits;
    }
    @Override
    protected void onPostExecute(ArrayList<Produit> aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.tvData.setText(this.parsedData);
        //MainActivity.lv.app



    }
}
