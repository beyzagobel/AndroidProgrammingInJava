package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * FirsProject konusu : 2 tane EditText toplamını Button ile TextView 'a yazdırma
 * @author beyzagobel
 */
public class FirstProject extends AppCompatActivity {


    public final String TAG =FirstProject.class.getName();

    private EditText txtSayi1,txtSayi2;
    private Button btnTopla;
    private TextView lblToplam;

    /*
     * Bir activity başlatıldığı  zaman ilk çalışacak metodumuz onCreate() dir.
     * Uygulama açıldığı zaman aktiviteninn gerçekleştirmesini istediğimiz her olayı bu metoda yazarız.
     * Bu metod aktivite çalışırken sadece bir kere çalışır.
     * Her activity, bir arayüzden sorumludur ve setContentView() ile bu arayüz kontrol edilir.
     * AppCompatActiivity sınıfı daActivity sınıflarının geçmiş sürümlere uyumluluğunu sağlar.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_project);

        initComponents();
        registerEventHandlers();

        Log.i(TAG,"OnCreate() Method Started");

    }

    private void registerEventHandlers() {
        btnTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sayi1 = Integer.parseInt(txtSayi1.getText().toString());
                int sayi2 = Integer.parseInt(txtSayi2.getText().toString());
                lblToplam.setText("Toplam : " + (sayi1 + sayi2));
            }
        });
    }

    private void initComponents() {
        txtSayi1=findViewById(R.id.txtSayi1);
        txtSayi2=findViewById(R.id.txtSayi2);
        btnTopla=findViewById(R.id.btnTopla);
        lblToplam=findViewById(R.id.txtToplam);
    }
}