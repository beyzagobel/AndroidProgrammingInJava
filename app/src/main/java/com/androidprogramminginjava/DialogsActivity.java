package com.androidprogramminginjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.google.android.material.snackbar.Snackbar;

public class DialogsActivity extends AppCompatActivity {

    private Button btnAlertDialog,btnMultiChoiceDialog,btnTimePickerDialog,btnDatePickerDialog,btnProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        initComponents();
        registerEventHandlers();
    }

    private void registerEventHandlers() {
        btnAlertDialog_onClick();
        btnMultiChoiceDialog_onClick();
        btnTimePickerDialog_onClick();
    }

    private void btnTimePickerDialog_onClick() {
        btnTimePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
                  @Override
                  public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                      String strMinute = String.valueOf(minute);
                      String strHour = String.valueOf(hourOfDay);
                      if(minute < 10){
                          strMinute = "0" + minute;
                      }
                      if(hourOfDay < 10){
                          strHour = "0" + hourOfDay;
                      }
                      String msg = "Seçim : " + strHour + ":" + strMinute ;
                      Snackbar snackbar = Snackbar.make(view,msg,Snackbar.LENGTH_LONG);
                      snackbar.show();
                  }
              };

              TimePickerDialog timePickerDialog = new TimePickerDialog(DialogsActivity.this,time,9,0,true);
              timePickerDialog.setTitle("Saat Ayarı");
              timePickerDialog.show();
            }
        });
    }

    private void btnMultiChoiceDialog_onClick() {
        btnMultiChoiceDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] items = new String[]{"C#","Java","PHP","C"};
                final boolean[] chechks = new boolean[]{false,false,false,false};

                AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this);
                builder.setTitle("Bildiğiniz Programlama Dilleri ? ");


                builder.setPositiveButton("Seçimi Tamamla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int witch) {

                            String msg = "Bilinen Programlama Dilleri : ";
                            for(int  i = 0 ; i < items.length; i++){
                                if(chechks[i]){
                                    msg+= "\n" + "- " + items[i];
                                }
                            }
                            Snackbar snackbar = Snackbar.make(view,msg,Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                });

                builder.setMultiChoiceItems(items, chechks, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int witch, boolean isChecked) {
                        String bilinmeDurumu = isChecked ? "biliniyor" : "bilinmiyor";
                        String s = items[witch] + " " + bilinmeDurumu;
                        Snackbar snackbar = Snackbar.make(view,s,Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void btnAlertDialog_onClick() {
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if(which == AlertDialog.BUTTON_NEGATIVE || which == AlertDialog.BUTTON_NEUTRAL){

                            Snackbar snackbar = Snackbar.make(view,"İşlem İptal edildi",Snackbar.LENGTH_LONG);
                            snackbar.show();

                        }else if(which == AlertDialog.BUTTON_POSITIVE){
                            Snackbar snackbar = Snackbar.make(view,"Çıkış başarıyla gerçekleşti",Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this);
                builder.setTitle("Emin misiniz ?");
                builder.setMessage("Çıkış Yapmak İstediğinizden Emin Misiniz ?");
                builder.setPositiveButton("EVET",dialog);
                builder.setNegativeButton("HAYIR",dialog);
                builder.setNeutralButton("IPTAL",dialog);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

/*
                builder.setPositiveButton("EVET",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

 */
            }
        });
    }

    private void initComponents() {
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnMultiChoiceDialog = findViewById(R.id.btnMultiChoiseDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnProgressDialog = findViewById(R.id.btnProgressDialog);
    }
}