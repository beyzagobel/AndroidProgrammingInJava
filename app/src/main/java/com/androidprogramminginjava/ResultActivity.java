package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_KARE_AL = 1 ;
    private EditText txtSayi;
    private Button btnGonder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initComponenta();
        registerEventHandlers();
    }

    private void initComponenta() {
        txtSayi = findViewById(R.id.txtSayi);
        btnGonder = findViewById(R.id.btnGonder);

    }

    private void registerEventHandlers() {
        btnGonder_onClick();
    }

    private void btnGonder_onClick() {
        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this,DestinationActivity.class);
                intent.putExtra("sayi",Integer.parseInt(txtSayi.getText().toString()));
                startActivity(intent);
            }
        });
    }

}