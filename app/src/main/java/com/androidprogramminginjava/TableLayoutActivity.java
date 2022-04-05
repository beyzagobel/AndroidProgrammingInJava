package com.androidprogramminginjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TableLayoutActivity extends AppCompatActivity {

    Button btnKayitOl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        //eventhandlers();
        izin();
        btnKayitOl=findViewById(R.id.btnKayitOl);


    }

    private void izin() {
        String permission = Manifest.permission.CALL_PHONE;
        boolean isGranted= ContextCompat.checkSelfPermission(TableLayoutActivity.this,permission)
                == PackageManager.PERMISSION_GRANTED;
        boolean rationale = ActivityCompat.shouldShowRequestPermissionRationale(
                TableLayoutActivity.this,permission);
        if(!isGranted){

            if(rationale){
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(TableLayoutActivity.this);
                builder.setMessage("Arama Yapabilmek için izine ihtiyaç var");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                 */
                Toast.makeText(TableLayoutActivity.this,"izine ihtiyuaç var",Toast.LENGTH_LONG).show();
            }

        }
    }
/*
    private void eventhandlers() {

        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                izin();
            }
        });
    }

 */
}