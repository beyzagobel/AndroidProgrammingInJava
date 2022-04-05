package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class ValidationActivity1 extends AppCompatActivity {

    private EditText txtIsim,txtSoyisim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation1);

        initComponents();
        registerEventHandlers();
    }

    private void registerEventHandlers() {
      txtIsim.setOnFocusChangeListener(new View.OnFocusChangeListener() {
          @Override
          public void onFocusChange(View view, boolean b) {
              String value = txtIsim.getText().toString();
              //length olabilir
              if(value.length()<1) txtIsim.setError("en az 3 karakter");
          }
      });
    }

    private void initComponents() {
        txtIsim = findViewById(R.id.txtIsım);
        txtSoyisim = findViewById(R.id.txtSoyisim);
    }
}