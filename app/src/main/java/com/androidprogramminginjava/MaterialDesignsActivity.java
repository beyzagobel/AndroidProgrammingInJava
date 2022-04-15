package com.androidprogramminginjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MaterialDesignsActivity extends AppCompatActivity {

    private Slider slider;
    private TextView lblDeger;
    private FloatingActionButton floatingActionButton;
    private TextInputLayout textInputlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_designs);

        initComponents();
        registerEventHandlers();
    }

    private void registerEventHandlers() {
        slider_onValueChange();
        floatingActionButton_onClick();


    }

    private void floatingActionButton_onClick() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,"FAB MENUYE TIKLANDI",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }


    private void slider_onValueChange() {
        slider.addOnChangeListener(new Slider.OnChangeListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {

                lblDeger.setText("Değer : " + value);
            }
        });
    }

    private void initComponents() {
        slider = findViewById(R.id.slider);
        lblDeger = findViewById(R.id.lblDeger);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        textInputlayout = findViewById(R.id.textInputlayout);
    }
}