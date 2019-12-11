package com.example.kuy.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.kuy.MainActivity;
import com.example.kuy.R;
import com.example.kuy.ui.notifications.DaftarFilm;
import com.example.kuy.ui.notifications.LoginActivity;
import com.example.kuy.ui.notifications.NotificationsFragment;
import com.google.firebase.auth.FirebaseAuth;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView name, desc,title;
    String namee, descc ,titlee;
    Button sign;

    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_film);
        imageView = findViewById(R.id.image);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);
        title = findViewById(R.id.title);
        namee = getIntent().getStringExtra("name");
        descc = getIntent().getStringExtra("desc");
        titlee = getIntent().getStringExtra("title");
        image = getIntent().getIntExtra("image", 0);
        name.setText(namee);
        desc.setText(descc);
        title.setText(titlee);
        imageView.setImageResource(image);
        sign= findViewById(R.id.lokasi);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intToMain = new Intent(DetailActivity.this, LoginActivity.class);
                startActivity(intToMain);
            }
        });
    }


}
