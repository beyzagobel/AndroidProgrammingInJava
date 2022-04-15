package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MenusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        switch (menuItem.getItemId()){
            case R.id.menuAc:
                Toast.makeText(this,"Aç menu elemanı seçildi",Toast.LENGTH_LONG).show();
                break;
            case  R.id.menuKaydet:
                Toast.makeText(this,"Kaydet menu elemanı seçildi",Toast.LENGTH_LONG).show();
                break;
            case  R.id.menuyazdir:
                Toast.makeText(this,"Yazdir menu elemanı seçildi",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);

    }
}