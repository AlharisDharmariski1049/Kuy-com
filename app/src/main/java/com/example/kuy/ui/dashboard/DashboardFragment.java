package com.example.kuy.ui.dashboard;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.kuy.R;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

   // private String[] presiden ={"soekarno","soeharto","habibie","gusdur","megawati","sby","jokowi"};
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private LokasiAdapter adapter;
    private ArrayList<lokasi> lokasi;
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        adapter = new LokasiAdapter(getActivity());
        ListView listView = (ListView)root.findViewById(R.id.list_lokasi);
        listView.setAdapter(adapter);

        prepares();
        addItems();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(getActivity(), lokasi.get(i).getNama(),Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
    private void addItems(){
        lokasi = new ArrayList<>();
        for (int i=0;i<dataName.length;i++){
            lokasi team = new lokasi();
            team.setGambar(dataPhoto.getResourceId(i,-1));
            team.setNama(dataName[i]);
            team.setDeskripsi(dataDescription[i]);
            lokasi.add(team);
        }
        adapter.setLokasi(lokasi);
    }
    private void prepares(){
        dataName = getResources().getStringArray(R.array.data_nama);
        dataDescription = getResources().getStringArray(R.array.alamat);
        dataPhoto = getResources().obtainTypedArray(R.array.gambar_lokasi);
    }
}