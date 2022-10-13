package com.example.uts_p3b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class PreferensiBerita extends AppCompatActivity {

    TextView hasilUmur, hasilCategory;
    RecyclerView recyclerView;
    ArrayList<BeritaListItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferensi_berita);

        hasilUmur = findViewById(R.id.hasil_umur);
        hasilCategory = findViewById(R.id.hasilKategori);

        recyclerView = findViewById(R.id.reycle_view);
        recyclerView.setHasFixedSize(true);

        list.addAll(DataBerita.getListData());
        showRecyclerList();

        Intent intent = getIntent();
        String checkIn = intent.getStringExtra("age");
        hasilUmur.setText(checkIn);

        String checkOut = intent.getStringExtra("cate");
        hasilCategory.setText(checkOut);

    }

    private void showRecyclerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BeritaAdapter listAdapter = new BeritaAdapter(list);
        recyclerView.setAdapter(listAdapter);
    }

}