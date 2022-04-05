package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CompoundButtonsActivity extends AppCompatActivity {

    private ToggleButton tglButton;
    private Switch swtButton;
    CheckBox chkButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_buttons);

        initComponents();
        registerEventHandlers();
    }

    private void registerEventHandlers() {
        tglButton_onClick();
        switchCheckBox_onChackedChanged();
        radioGroup_onChackedChanged();
        //   chkButton_onChackedChanged()
        //   swtButton_onChackedChanged();

    }

    private void tglButton_onClick() {
        tglButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String metin = "";
                if (tglButton.isChecked())
                    metin = "Kayıt Başladı. ";
                else
                    metin = "Kayıt Durduruldu. ";
                Toast toast = Toast.makeText(CompoundButtonsActivity.this, metin, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    private void switchCheckBox_onChackedChanged() {
        CompoundButton.OnCheckedChangeListener cmp = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                String metin = "";
                if (compoundButton.isChecked()) {
                    metin = "Altyazı açık";
                } else {
                    metin = "Altyazı Kapalı";
                }
                Toast.makeText(CompoundButtonsActivity.this, metin, Toast.LENGTH_LONG).show();

            }
        };
        swtButton.setOnCheckedChangeListener(cmp);
        chkButton.setOnCheckedChangeListener(cmp);
    }

    private void radioGroup_onChackedChanged() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                String metin = "";
                if (checkedId == R.id.radioVar) {
                    metin = "Altyazı açık";
                } else {
                    metin = "Altyazı Kapalı";
                }
                Toast.makeText(CompoundButtonsActivity.this, metin, Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initComponents() {
        tglButton = findViewById(R.id.tglButton);
        swtButton = findViewById(R.id.swtButton);
        chkButton = findViewById(R.id.chkButton);
        radioGroup = findViewById(R.id.radioGrp);
    }

    /*
           private void chkButton_onChackedChanged() {
               chkButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                   }
               });
           }
             private void swtButton_onChackedChanged() {
               chkButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                   }
               });
           }
       */

}