package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DestinationActivity extends AppCompatActivity {

    private TextView lblGelenSayi;
    private Button btnKaresiniAlGonder;
    private Intent incomingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        initComponenta();
        registerEventHandlers();
    }

    private void registerEventHandlers() {
        btnKaresiniAlGonder_onClick();
    }

    private void btnKaresiniAlGonder_onClick() {
        btnKaresiniAlGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                Integer gelenSayi = Integer.parseInt(lblGelenSayi.getText().toString());
                returnIntent.putExtra("sayi",gelenSayi*gelenSayi);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }



    private void initComponenta() {

        lblGelenSayi = findViewById(R.id.txtGelenSayi);
        btnKaresiniAlGonder = findViewById(R.id.btnKaresiniAlGonder);

        incomingIntent = getIntent();
        Integer sayi = incomingIntent.getIntExtra("sayi",0);
        lblGelenSayi.setText(sayi.toString());

    }

}