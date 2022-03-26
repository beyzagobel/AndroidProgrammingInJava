package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Evet Handling
 *
 * @author beyzagobel
 */

public class SecondProject extends AppCompatActivity {

    TextView lblClick;
    Button btnClick;
    private int adet = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_project);

        initComponents();
        registerEventHandlers();

        Toast.makeText(getApplicationContext(),"WELCOME",Toast.LENGTH_SHORT).show();

    }

    private void registerEventHandlers() {
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adet++;
                lblClick.setText(adet+" defa tıklanıldı.");

            }
        });
    }

    private void initComponents() {
        lblClick = findViewById(R.id.lblClick);
        btnClick = findViewById(R.id.btnClick);
    }

}