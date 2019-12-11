package com.example.kuy.ui.notifications;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kuy.R;
import com.example.kuy.ui.home.CustomAdapterFilm;
import com.example.kuy.ui.home.DetailActivity;
import com.example.kuy.ui.home.Model;

import java.util.ArrayList;
import java.util.List;

public class AdapterFilm extends BaseAdapter {
    private Context context;
    private ArrayList<Film> heroes;
    public AdapterFilm(Context context) {
        this.context = context;
        heroes = new ArrayList<>();
    }

    public void setHeroes(ArrayList<Film> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film_lanjutan, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Film hero = (Film) getItem(i);
        viewHolder.bind(hero);
        return view;
    }
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Film hero) {
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}
