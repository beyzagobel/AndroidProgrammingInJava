package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ValidationActivity2 extends AppCompatActivity {

    private EditText txtIsim,txtSoyisim;
    private Button btnKaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation2);

        initComponents();
        registerEventHandlers();
    }
    private void btnKaydet_onClick() {
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ValidationActivity2.this,"Kaydetme İşlemi Başarılı",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initComponents() {
        txtIsim = findViewById(R.id.txtIsım);
        txtSoyisim = findViewById(R.id.txtSoyisim);
        btnKaydet = findViewById(R.id.btnKaydet);
    }

    private void registerEventHandlers() {
        btnKaydet_onClick();

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                boolean checkOnIsim = checkEditText(txtIsim);
                boolean checkOnSoyisim = checkEditText(txtSoyisim);

                if(checkOnIsim && checkOnSoyisim){
                    btnKaydet.setVisibility(View.VISIBLE);
                }else {
                    btnKaydet.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        txtIsim.addTextChangedListener(textWatcher);
        txtSoyisim.addTextChangedListener(textWatcher);
    }

    private boolean checkEditText(EditText editText){
        String value = editText.getText().toString();

        if(value.length()<3){
            editText.setError("Bu alana en az 3 karakter giriniz");
            return false;
        }else
            return true;

    }




}