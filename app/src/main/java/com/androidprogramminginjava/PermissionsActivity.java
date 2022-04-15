package com.androidprogramminginjava;

import androidx.annotation.NonNull;
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
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class PermissionsActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private static final int REQUEST_SEND = 1;

    private Button btnIzin;
    private TextView lbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        String permission = Manifest.permission.CALL_PHONE;
        boolean isGranted = ContextCompat.checkSelfPermission(PermissionsActivity.this,permission) == PackageManager.PERMISSION_GRANTED;
 //       boolean rationale = ActivityCompat.shouldShowRequestPermissionRationale(PermissionsActivity.this,permission);

        if(!isGranted){  // onaylı değilse
                ActivityCompat.requestPermissions(PermissionsActivity.this,new String[]{permission},REQUEST_CALL);
                // çalışma zamanında onay istenir
        }else{
            String number = "tel:05467830408";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(number));
            startActivity(intent);
        }



        btnIzin = findViewById(R.id.btnIzin);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUEST_SEND){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"selam");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"uygulama seçiniz"));
            }
        }else{
           lbl.setText("onay gerçekleşemedi");
        }

    }


}