package com.androidprogramminginjava;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class AutoCompleteTextViewActivity extends AppCompatActivity {


    private AutoCompleteTextView txtBolum;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_auto_complete_text_view);

        initComponents();
        binData();


    }

    private void binData() {
        String[] bolumler = getResources().getStringArray(R.array.engineering);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,bolumler);
        txtBolum.setAdapter(adapter);
    }

    private void initComponents() {
        txtBolum=findViewById(R.id.txtBolum);
    }
}
