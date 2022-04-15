package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentsActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private Button btnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        btnIntent = findViewById(R.id.btnIntent);
/*
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String adres = "http://bm.mf.duzce.edu.tr";
        intent.setData(Uri.parse(adres));
        startActivity(intent);
        */
/*
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"selam");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,"uygulama seçiniz"));
*/

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"talhakabakus@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"deneme");
                intent.putExtra(Intent.EXTRA_TEXT,"gönderilecek metin");
                intent.setDataAndType(Uri.parse("mailto:byzgbll@gmail.com"),"text/plain");
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(Intent.createChooser(intent,"uygulama seçiniz: "));
                }
            }
        });



/*

        String permission = Manifest.permission.CALL_PHONE;
        boolean isGranted = ContextCompat.checkSelfPermission(IntentsActivity.this,permission) == PackageManager.PERMISSION_GRANTED;

        if(!isGranted){  // onaylı değilse
            ActivityCompat.requestPermissions(IntentsActivity.this,new String[]{permission},REQUEST_CALL);
            // çalışma zamanında onay istenir
        }else{
            String number = "tel:05467830408";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(number));
            startActivity(intent);
        }
*/

    }
}