package com.example.uts_p3b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetailDataUser extends AppCompatActivity {

    EditText nama, tanggalLahir;
    TextView hasilUmur;
    Spinner kategori;
    Button btn_lanjut;
    int umur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_user);

        nama = findViewById(R.id.nama_lengkap);
        hasilUmur = findViewById(R.id.hasil_umur);
        tanggalLahir = findViewById(R.id.tgl_lahir);
        kategori = findViewById(R.id.category);
        btn_lanjut = findViewById(R.id.btn_next);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        kategori.setAdapter(adapter);

        if (kategori != null) {
            kategori.setAdapter(adapter);
        }

        tanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerTtl();
            }
        });

        btn_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nama.getText().toString())) {
                    Toast.makeText(DetailDataUser.this, "Kolom Nama tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(tanggalLahir.getText().toString())) {
                    Toast.makeText(DetailDataUser.this, "Kolom Tanggal Lahir tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(DetailDataUser.this, PreferensiBerita.class);

                    String tglLahir = tanggalLahir.getText().toString();
                    String category = kategori.getSelectedItem().toString();
                    intent.putExtra("tgl",tglLahir);
                    intent.putExtra("cate",category);
                    int message1 = umur;
                    intent.putExtra("kodeUmur",message1);
                    startActivityForResult(intent, 1);
                }

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

        umur = (2022 - year);
        String totalUmur = Integer.toString(umur);
        hasilUmur.setText(totalUmur);

        String dateMessage = dayString + "/" + monthString + "/" + yearString;
        tanggalLahir.setText(dateMessage);
    }

}