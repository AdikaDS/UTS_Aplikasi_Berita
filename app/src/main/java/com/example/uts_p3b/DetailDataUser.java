package com.example.uts_p3b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailDataUser extends AppCompatActivity {

    EditText nama, tanggalLahir;
    Spinner kategori;
    Button lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_user);

        nama = findViewById(R.id.nama_lengkap);
        tanggalLahir = findViewById(R.id.tgl_lahir);
        kategori = findViewById(R.id.category);
        lanjut = findViewById(R.id.btn_next);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        kategori.setAdapter(adapter);

        tanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerTtl();
            }
        });

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailDataUser.this, PreferensiBerita.class);
                // Tambahin Method buat cari umur | string umur masi salah
                String umur = tanggalLahir.getText().toString();
                String category = kategori.getSelectedItem().toString();
                intent.putExtra("age",umur);
                intent.putExtra("cate",category);
                startActivity(intent);
            }
        });
    }

    public void showDatePickerTtl() {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "date-picker");
    }

    public void processDatePickerResultTtl(int day, int month, int year) {

        String dayString = Integer.toString(day);
        String monthString = Integer.toString(month + 1);
        String yearString = Integer.toString(year);

        String dateMessage = dayString + "/" + monthString + "/" + yearString;

        tanggalLahir.setText(dateMessage);
    }

    public void ageCalculator(int day, int month, int year) {

        // if ((month<))
    }
}