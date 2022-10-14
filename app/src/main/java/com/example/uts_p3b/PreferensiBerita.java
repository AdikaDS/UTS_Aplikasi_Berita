package com.example.uts_p3b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class PreferensiBerita extends AppCompatActivity {

    TextView hasilCategory;
    RecyclerView recyclerView;
    ArrayList<BeritaListItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferensi_berita);
        hasilCategory = findViewById(R.id.hasilKategori);

        recyclerView = findViewById(R.id.reycle_view);

        Intent intent = getIntent();
        int ageData = intent.getIntExtra("kodeUmur", 1);

        String category = intent.getStringExtra("cate");
        hasilCategory.setText(category);

        if(Objects.equals(category, "Sport") && ageData < 17){
            list.addAll(DataBerita.getListDataSportsLow());
        } else if(Objects.equals(category, "Sport") && ageData >= 17){
            list.addAll(DataBerita.getListDataSports());
            list.addAll(DataBerita.getListDataSportsLow());
        } else if (Objects.equals(category, "Games") && ageData >= 17 ){
            list.addAll(DataBerita.getListDataGames());
            list.addAll(DataBerita.getListDataGamesLow());
        }else if (Objects.equals(category, "Games") && ageData < 17){
            list.addAll(DataBerita.getListDataGamesLow());
        } else if (Objects.equals(category, "Teknologi") && ageData >= 17 ){
            list.addAll(DataBerita.getListDataTeknologi());
            list.addAll(DataBerita.getListDataTeknologiLow());
        }else if (Objects.equals(category, "Teknologi") && ageData < 17){
            list.addAll(DataBerita.getListDataTeknologiLow());
        }
        showRecyclerList();

    }

    private void showRecyclerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BeritaAdapter listAdapter = new BeritaAdapter(list);
        recyclerView.setAdapter(listAdapter);
    }

}