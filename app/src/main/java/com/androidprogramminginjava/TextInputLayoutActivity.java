package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutUsername, textInputLayoutPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);

        initComponents();
        registerEventHandlers();
    }

    private void registerEventHandlers() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isUsernameValid = validateEditText(textInputLayoutUsername);
                boolean isPasswordValid = validateEditText(textInputLayoutPassword);

                if(!isUsernameValid){
                    textInputLayoutUsername.setError("Kullanıcı adı hatalı");
                }
                else{
                    textInputLayoutUsername.setError(null);
                }
                if(!isPasswordValid){
                    textInputLayoutPassword.setError("Şifre Hatalı");
                }
                else{
                    textInputLayoutPassword.setError(null);
                }
                if(isUsernameValid && isUsernameValid){
                    Snackbar snackbar = Snackbar.make(view,"Kullanıcı Adı ve Şİfre Geçerli",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }

            private boolean validateEditText(TextInputLayout textInputLayout) {
                String input = textInputLayout.getEditText().getText().toString();
                return input.length()>3;
            }
        });
    }

    private void initComponents() {
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUsername = findViewById(R.id.textInputLayoutUsername);
        btnLogin = findViewById(R.id.btnLogin);
    }
}