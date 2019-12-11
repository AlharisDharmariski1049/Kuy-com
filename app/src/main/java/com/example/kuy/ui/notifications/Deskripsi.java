package com.example.kuy.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kuy.R;

public class Deskripsi extends AppCompatActivity implements View.OnClickListener {
    private TextView nama, desk;
    private ImageView foto;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_deskripsi);
            next = (Button)findViewById(R.id.lokasi);
            next.setOnClickListener(this);

            nama = findViewById(R.id.Nama);
            desk = findViewById(R.id.Deskripsi);
            foto = findViewById(R.id.poto);
            showData();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lokasi:
                    Intent moveIntent = new Intent(Deskripsi.this, DaftarLokasi.class);
                    startActivity(moveIntent);
                    break;
            }
        }

        @SuppressLint("SetTextI18n")
        private void showData() {
            String pres = getIntent().getExtras().getString("MyName");
            switch (pres) {
                case "Avenger":
                    nama.setText("Avenger");
                    foto.setImageDrawable(getResources().getDrawable(R.drawable.avenger));
                    desk.setText("Judul : The Avengers\n"+ "\n" +
                            "Sinopsis : Endgame merupakan sebuah film yang menceritakan kisah  pertarungan akhir dari Thanos yang memusnahkan setengah dari semua kehidupan di alam semesta, Avengers yang tersisa harus melakukan apa yang diperlukan untuk membatalkan perbuatan Titan ini.\n" +"\n"+
                            "Puncak dari 22 film yang saling berhubungan, serial keempat dari kisah Avengers akan menarik penonton untuk menyaksikan titik balik dari perjalanan epik ini.");
                    break;
                case "Spiderman":
                    nama.setText("Spiderman");
                    foto.setImageDrawable(getResources().getDrawable(R.drawable.spiderman));
                    desk.setText("Judul : Spiderman : Home Coming\n"+"\n"+
                            "Sinopsis : Pasca menjadi anggota tim Iron Man di Captain America Civil War (2016), Peter Parker (Matt Holland) pulang ke Queens, New York, dan tinggal bersama Bibi May (Marisa Tomei). Ia pun kembali menjalani rutinitasnya sebagai pelajar di sekolah atas perintah Tony Stark (Robert Downey Jr.) yang menjadi mentornya.\n"+"\n"+
                            "Peter awalnya menuruti semua perintah Tony. Namun, tak bisa dipungkiri jika batinnya berkecamuk. Pasalnya, ia merasa bisa melakukan hal yang lebih besar ketimbang sekedar menangkap penjahat kecil atau menolong orang menemukan alamat.");
                    break;
                case "Joker":
                    nama.setText("Joker");
                    foto.setImageDrawable(getResources().getDrawable(R.drawable.joker));
                    desk.setText("Judul : Joker\n"+ "\n" +
                            "Sinopsis :  Film yang menceritakan asal muasal musuh utama Batman, Joker bakal rilis pada 2 Oktober 2019. Berikut sinopsis film yang dibintangi oleh Joaquin Phoenix dan disutradarai Todd Phillips.\n"+"\n"+
                            "Joker berfokus pada perjalanan sosok komedian gagal, Arthur Fleck (dibintangi Phoenix), pria yang diabaikan oleh masyarakat dan berubah menjadi penjahat yang sangat keji. Titik terbawah hidup Arthur terjadi saat ia diolok-olok oleh presenter yang diperankan Robert De Niro lewat siaran TV nasional. Begitu banyak kekecewaan yang membuatnya menjadi pribadi pahit dan akhirnya, berubah menjadi pembunuh.");
                    break;
                case "Danur":
                    nama.setText("Danur");
                    foto.setImageDrawable(getResources().getDrawable(R.drawable.danur));
                    desk.setText("Judul : Joker\n"+ "\n"+
                            "Sinopsis : Risa adalah seorang gadis indigo — dia memiliki kemampuan untuk melihat makhluk gaib. Sejak kecil, Risa menjalani hidup kesepian\n"+"\n"+
                            "Ketika Risa genap usia delapan tahun, dia berharap dikaruniai teman. Tak disangka, tiga bocah laki-laki sebayanya: Janshen, Peter, dan William hadir secara tiba-tiba. Anehnya, hanya Risa yang dapat melihat mereka. Mereka akhirnya mengungkapkan bahwa mereka adalah hantu orang Indo yang mati saat masa pendudukan Jepang di Hindia Belanda.");
            }
        }
}
