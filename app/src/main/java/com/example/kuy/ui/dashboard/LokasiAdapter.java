package com.example.kuy.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
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

import java.util.ArrayList;
import java.util.List;

public class LokasiAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<lokasi> lokasi;

    public void setLokasi(ArrayList<lokasi> lokasi) {
        this.lokasi = lokasi;
    }

    public LokasiAdapter(Context context) {
        this.context = context;
        lokasi = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return lokasi.size();
    }

    @Override
    public Object getItem(int i) {
        return lokasi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_lokasi,viewGroup,false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        lokasi lokasi = (lokasi)getItem(i);
        viewHolder.bind(lokasi);
        return view;
    }
    private class ViewHolder{
        private TextView txtNama;
        private TextView txtNpm;
        private ImageView imageTeam;

        ViewHolder(View view){
            txtNama = view.findViewById(R.id.txt_nama);
            txtNpm = view.findViewById(R.id.txt_deskripsi);
            imageTeam = view.findViewById(R.id.img_gambar);
        }
        void bind(lokasi team){
            txtNama.setText(team.getNama());
            txtNpm.setText(team.getDeskripsi());
            imageTeam.setImageResource(team.getGambar());
        }
    }

}
