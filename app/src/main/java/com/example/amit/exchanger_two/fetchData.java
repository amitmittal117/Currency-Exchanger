package com.example.amit.exchanger_two;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.BufferedReader;
import org.json.*;
import android.util.*;

public class fetchData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataparsed = "";
    String singleParsed = "";
    String res;
    String units;
    String myurl;
    String last;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            res =MainActivity.etfrom.getText().toString()+"_"+MainActivity.etto.getText().toString();
//            myurl = "http://free.currencyconverterapi.com/api/v5/convert?q="+res+"&compact=y";
            myurl = "http://localhost:5000/";
            URL url = new URL(myurl);
            units = MainActivity.etunit.getText().toString();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            data = bufferedReader.readLine();

//            {"INR_USD":{"val":0.01386}}
            JSONArray JA = new JSONArray(data);

            JSONObject JO = new JSONObject(data);

            JSONObject SJO = JO.getJSONObject(res);
            last = SJO.getString("val");

//            JSONObject SJO = JO.getJSONObject(res);
//            last = SJO.getString("val");
//
//            for(int i=0;i<JA.length();i++){
//                JSONObject JO = (JSONObject) JA.get(i);
//                singleParsed = "Value:" + JO;
//
//                dataparsed = dataparsed + singleParsed;
//            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


        MainActivity.data_viewed.setText(this.data);
        MainActivity.data_viewed_parsed.setText(this.res);
        MainActivity.fetched_url.setText(this.myurl);

    }
}
