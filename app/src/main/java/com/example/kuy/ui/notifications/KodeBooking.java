package com.example.kuy.ui.notifications;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kuy.MainActivity;
import com.example.kuy.R;
import com.google.firebase.auth.FirebaseAuth;


public class KodeBooking extends Activity  {
    Button btnlogOut;
    FirebaseAuth mFirebaseAuth;
    private ImageView qrKode;
    private TextView lokasi, kode, biaya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kode_booking);
        lokasi = findViewById(R.id.tempat);
        btnlogOut= findViewById(R.id.btnlogout);
        kode = findViewById(R.id.id);
        biaya = findViewById(R.id.harga);
        qrKode = (ImageView) findViewById(R.id.qr);
        showData();
        btnlogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(KodeBooking.this, MainActivity.class);
                startActivity(intToMain);
            }
        });

    }






    @SuppressLint("SetTextI18n")
    private void showData() {
        String pres = getIntent().getExtras().getString("MyName");
        switch (pres) {
            case "MBK":
                lokasi.setText("XXI Boemi Kedaton");
                kode.setText("15F111019");
                biaya.setText("Rp.50.000");
                break;
            case "Trans":
                lokasi.setText("CGV Transmart Lampung");
                kode.setText("05C021119");
                biaya.setText("Rp.45.000");
                break;
            case "Kartini":
                lokasi.setText("Mal Kartini XXI The Premiere");
                kode.setText("09B101119");
                biaya.setText("Rp.40.000");
                break;
        }
    }


}
