package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public class PermissionsActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        String permission = Manifest.permission.CALL_PHONE;
        boolean isGranted = ContextCompat.checkSelfPermission(PermissionsActivity.this,permission) == PackageManager.PERMISSION_GRANTED;

        if(!isGranted){  // onaylı değilse
            ActivityCompat.requestPermissions(PermissionsActivity.this,new String[]{permission},REQUEST_CALL);
            // çalışma zamanında onay istenir
        }else{
            String number = "tel:05467830408";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(number));
            startActivity(intent);
        }
    }
}