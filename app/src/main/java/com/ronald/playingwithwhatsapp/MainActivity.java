package com.ronald.playingwithwhatsapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private View.OnClickListener Listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = findViewById(R.id.btnEnviar);

        Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openWhatsApp(view);
                SendToWhatup(view);
            }
        };

        btnEnviar.setOnClickListener(Listener);


    }

    private void openWhatsApp(View view){
        PackageManager pm=getPackageManager();
        try {
            String text = "Esto es una prueba"; // Replace with your own message.
            //String toNumber = "50687994999"; //
            String toNumber = "50688165112"; //
            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            waIntent.putExtra(Intent.EXTRA_TEXT, toNumber);
            waIntent.setType("text/plain");

            waIntent.setPackage("com.whatsapp");


            startActivity(Intent.createChooser(waIntent, "Enviar a..."));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void SendToWhatup(View view){
        PackageManager pm=getPackageManager();
        try {

            String toNumber = "50687994999"; //
            String text = "Texto de prueba";// Replace with your message.


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);

        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

        }
    }


}
