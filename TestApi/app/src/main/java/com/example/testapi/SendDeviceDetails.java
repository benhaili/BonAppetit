package com.example.testapi;
import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class SendDeviceDetails  extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {

        String data = "";

        HttpURLConnection connection = null;
        try {
            URL url=new URL("http://192.168.2.17:8080/listProduits");
             connection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=connection.getInputStream();
            connection.getResponseCode();
            //httpURLConnection = (HttpURLConnection) new URL(params[0]).openConnection();
            connection.setRequestMethod("POST");

            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes("PostData=" + params[0]);
            wr.flush();
            wr.close();

            InputStream in = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);

            int inputStreamData = inputStreamReader.read();
            while (inputStreamData != -1) {
                char current = (char) inputStreamData;
                inputStreamData = inputStreamReader.read();
                data += current;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return data;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.e("TAG", result); // this is expecting a response code to be sent from your server upon receiving the POST data
    }
}