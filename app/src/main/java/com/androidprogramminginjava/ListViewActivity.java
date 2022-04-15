package com.androidprogramminginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

public class ListViewActivity extends AppCompatActivity {

    private ListView listGunler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initComponents();
        loadData();
        registerEventHandlers();
    }

    private void registerEventHandlers() {
        listGunler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String secim = listGunler.getItemAtPosition(position).toString();
                String mesaj = "Seçim : " + secim ;
                Snackbar snackbar = Snackbar.make(view,mesaj,Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }

    private void loadData() {

        String[] gunler = getResources().getStringArray(R.array.gunler);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, android.R.id.text1,gunler);
        listGunler.setAdapter(arrayAdapter);
    }

    private void initComponents() {
        listGunler = findViewById(R.id.listGunler);
    }
}