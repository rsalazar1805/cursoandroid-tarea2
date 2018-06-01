package com.ronald.playingwithwhatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import cz.msebera.android.httpclient.*;


public class MainActivity extends AppCompatActivity {

    private View.OnClickListener Listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);

        Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APICaller();
            }
        };

        btnEnviar.setOnClickListener(Listener);


    }

    private void APICaller() {
        Toast.makeText(this, "Ha hecho click", Toast.LENGTH_LONG).show();

        RequestParams rp = new RequestParams();
        rp.add("username", "aaa"); rp.add("password", "aaa@123");



        //HttpUtils.post("api/users/2", rp, new JsonHttpResponseHandler() {
        HttpUtils.post("api/users/2", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Log.d("asd", "---------------- this is response : " + response);

                    try {
                        JSONObject serverResp = new JSONObject(response.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                Log.d("asd", "---------------- this is response : ");

            }
        });
    }
}
