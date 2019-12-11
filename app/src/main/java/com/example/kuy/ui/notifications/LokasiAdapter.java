package com.example.kuy.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kuy.R;

import java.util.ArrayList;

public class LokasiAdapter extends BaseAdapter {
    private Context contexts;
    private ArrayList<lokasi> tempat;

    public LokasiAdapter(Context contexts) {
        this.contexts = contexts;
        tempat = new ArrayList<>();
    }

    public void setLokasi(ArrayList<lokasi> tempat) {
        this.tempat = tempat;
    }

    @Override
    public int getCount() {
        return tempat.size();
    }

    @Override
    public Object getItem(int i) {
        return tempat.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(contexts).inflate(R.layout.item_lokasii, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        lokasi hero = (lokasi) getItem(i);
        viewHolder.bind(hero);
        return view;
    }
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_nama);
            txtDescription = view.findViewById(R.id.txt_deskripsi);
            imgPhoto = view.findViewById(R.id.img_gambar);
        }
        void bind(lokasi hero) {
            txtName.setText(hero.getNama());
            txtDescription.setText(hero.getDeskripsi());
            imgPhoto.setImageResource(hero.getGambar());
        }
    }
}
