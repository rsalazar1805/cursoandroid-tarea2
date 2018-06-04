package com.ronald.playingwithwhatsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private View.OnClickListener Listener;
    private String message;
    private String number;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(requiredData()){
                    sendToWhatup(view);
                }
                else{
                    Popups errorPopup = new Popups();
                    errorPopup.show(getFragmentManager(),"Test");
                }

            }
        };

        btnEnviar.setOnClickListener(Listener);

    }

    private boolean requiredData() {
        EditText inputCountryCode = findViewById(R.id.editTxtCountryCode);
        EditText inputNumber = findViewById(R.id.editTxtNumber);
        EditText inputMessage = findViewById(R.id.editTxtMessage);

        code = inputCountryCode.getText().toString();
        number = inputNumber.getText().toString();
        message = inputMessage.getText().toString();

        if (number.isEmpty())
        {
            return message.isEmpty() ? false : true;
        }
        else {
            return (message.isEmpty() || code.isEmpty()) ? false : true;
        }
    }

    private void sendToWhatup(View view){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ code + number +"&text="+message));
            startActivity(intent);

        }
        catch (Exception e){
            //e.printStackTrace();
            Toast.makeText(MainActivity.this,R.string.noWhatapp,Toast.LENGTH_LONG).show();

        }
    }

}
