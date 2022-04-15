package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                startActivityForResult(intent,REQUEST_CODE_KARE_AL);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_KARE_AL){
            if(resultCode == RESULT_OK){
                int gelenSayi = data.getIntExtra("sayi",0);
                Toast.makeText(ResultActivity.this,"Gelen Sayi : "+ gelenSayi ,Toast.LENGTH_LONG ).show();

                txtSayi.setText("gelen sayi" + gelenSayi);

            }else if(resultCode == RESULT_CANCELED){

            }
        }
    }

}