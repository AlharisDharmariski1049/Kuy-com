package com.example.kuy.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kuy.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    List<Model> main_list;
    RecyclerView.Adapter adapter;
    private int[] mImage = new int[]{
            R.drawable.jokerr, R.drawable.avengerr, R.drawable.danurr,R.drawable.spidermann




    };




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CarouselView carouselView = view.findViewById(R.id.caro);
        carouselView.setPageCount(mImage.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImage[position]);
            }
        });


        main_list = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        main_list.add(new Model(R.drawable.avenger,"Avenger","Endgame merupakan sebuah film yang menceritakan kisah  pertarungan akhir dari Thanos yang memusnahkan setengah dari semua kehidupan di alam semesta, Avengers yang tersisa harus melakukan apa yang diperlukan untuk membatalkan perbuatan Titan ini.\n"+ "\n"+
                                        "Puncak dari 22 film yang saling berhubungan, serial keempat dari kisah Avengers akan menarik penonton untuk menyaksikan titik balik dari perjalanan epik ini.","Judul : Avenger\n"+"\n"+"Sinopsis : "));
        main_list.add(new Model(R.drawable.spiderman,"Spiderman","Pasca menjadi anggota tim Iron Man di Captain America Civil War (2016), Peter Parker (Matt Holland) pulang ke Queens, New York, dan tinggal bersama Bibi May (Marisa Tomei). Ia pun kembali menjalani rutinitasnya sebagai pelajar di sekolah atas perintah Tony Stark (Robert Downey Jr.) yang menjadi mentornya.\n"+ "\n" +
                                        "Peter awalnya menuruti semua perintah Tony. Namun, tak bisa dipungkiri jika batinnya berkecamuk. Pasalnya, ia merasa bisa melakukan hal yang lebih besar ketimbang sekedar menangkap penjahat kecil atau menolong orang menemukan alamat.","Judul : Spiderman\n"+"\n"+"Sinopsis : "));
        main_list.add(new Model(R.drawable.joker,"Joker","Film yang menceritakan asal muasal musuh utama Batman, Joker bakal rilis pada 2 Oktober 2019. Berikut sinopsis film yang dibintangi oleh Joaquin Phoenix dan disutradarai Todd Phillips.\n"+ "\n" +
                                         "Joker berfokus pada perjalanan sosok komedian gagal, pria yang diabaikan oleh masyarakat dan berubah menjadi penjahat yang sangat keji. Titik terbawah hidup Arthur terjadi saat ia diolok-olok oleh presenter yang diperankan Robert De Niro lewat siaran TV nasional. Begitu banyak kekecewaan yang membuatnya menjadi pribadi pahit dan akhirnya, berubah menjadi pembunuh.","Judul : Joker\n"+"\n"+"Sinopsis :"));
        main_list.add(new Model(R.drawable.danur,"Danur","Risa adalah seorang gadis indigo — dia memiliki kemampuan untuk melihat makhluk gaib. Sejak kecil, Risa menjalani hidup kesepian\n"+ "\n" +
                                         "Ketika Risa genap usia delapan tahun, dia berharap dikaruniai teman. Tak disangka, tiga bocah laki-laki sebayanya: Janshen, Peter, dan William hadir secara tiba-tiba. Anehnya, hanya Risa yang dapat melihat mereka. Mereka akhirnya mengungkapkan bahwa mereka adalah hantu orang Indo yang mati saat masa pendudukan Jepang di Hindia Belanda.","Judul : Danur\n"+"\n"+"Sinopsis :"));
        adapter = new CustomAdapterFilm(main_list, getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);
        return view;
    }
}