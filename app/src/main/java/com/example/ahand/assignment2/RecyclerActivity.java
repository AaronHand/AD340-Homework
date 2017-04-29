package com.example.ahand.assignment2;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RecyclerActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        try {
            new getAutos().execute();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private class getAutos extends AsyncTask<Void, Void, String>{

        private getAutos() throws MalformedURLException {}



        @Override
        protected String doInBackground(Void... params) {

            StringBuilder response = new StringBuilder();
            HttpURLConnection urlConnection;
            try {

                URL url = new URL("https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json");
                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Accept","application/json");

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null){
                    response.append(line);
                }

                urlConnection.disconnect();


            } catch (Exception e){
                e.printStackTrace();
            }
            Log.d("--",response.toString());
            return response.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Log.d("-RESULT-",result);

            ArrayList<Automobile> autos = new ArrayList<>();
            try {
                Log.i("--","made it.");

                JSONObject object = (JSONObject) new JSONTokener(result).nextValue();

                JSONArray array = object.getJSONArray("Results");

                for(int i=0; i<array.length(); i++){
                    JSONObject jo = array.getJSONObject(i);
                    autos.add(new Automobile(jo.getInt("Make_ID"),jo.getString("Make_Name")));

                }



//                for(int i=0; i<jsonArray.length(); i++){
//                    JSONObject ja = jsonArray.getJSONObject(i);
//                    autos.add(new Automobile(ja.getInt("Make_ID"),ja.getString("Make_Name")));
//                }

                RecyclerView rvAutomobiles = (RecyclerView) findViewById(R.id.recyclerView);
                CustomAdapter adapter = new CustomAdapter(autos,getApplicationContext());

                rvAutomobiles.setAdapter(adapter);

                rvAutomobiles.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


            } catch (JSONException e){
                e.printStackTrace();
            }
        }
    }



}
