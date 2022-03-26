package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * @author beyzagobel
 */

public class AutoCompleteTextViewActivity extends AppCompatActivity {


    private AutoCompleteTextView txtBolum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        initComponents();
        bindData();
    }

    private void bindData() {
        /**
         * @param bolumler res/strings.xml klasöründeki engineering isimli aray'ı buradaki değişkene atar
         */
        String[] bolumler = getResources().getStringArray(R.array.engineering);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,bolumler);
        txtBolum.setAdapter(adapter);
    }

    private void initComponents() {
        txtBolum = findViewById(R.id.txtBolum);
    }
}