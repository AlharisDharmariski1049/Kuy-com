package com.example.kuy.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kuy.R;

import java.util.ArrayList;
import java.util.Collections;

public class DaftarLokasi extends AppCompatActivity {
    private String[] lokasi = {"MBK","Trans","Kartini"};
    private ArrayList<String> data;

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private LokasiAdapter adapter;
    private ArrayList<lokasi> heroes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_lokasi);
        adapter = new LokasiAdapter(this);
        ListView listView = findViewById(R.id.list_lokasi);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, lokasi);
        listView.setAdapter(adapter);

        prepares();
        addItems();

        data = new ArrayList<>() ;
        getData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String getName = data.get(position);
                Intent sendData = new Intent(DaftarLokasi.this, KodeBooking.class);
                sendData.putExtra("MyName",getName);
                startActivity(sendData);
            }
        });
    }
    private void getData() {
        Collections.addAll(data, lokasi);
    }
    private void addItems() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            lokasi hero = new lokasi();
            hero.setGambar(dataPhoto.getResourceId(i, -1));
            hero.setNama(dataName[i]);
            hero.setDeskripsi(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setLokasi(heroes);
    }

    private void prepares() {
        dataName = getResources().getStringArray(R.array.data_nama);
        dataDescription = getResources().getStringArray(R.array.alamat);
        dataPhoto = getResources().obtainTypedArray(R.array.gambar_lokasi);
    }
}
