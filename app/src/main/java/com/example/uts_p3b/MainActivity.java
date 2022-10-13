package com.example.uts_p3b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id, pass;
    Button masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        masuk = findViewById(R.id.btn_login);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = id.getText().toString();
                String password = pass.getText().toString();

                if ((username.equals("pakjoko")) && (password.equals("yangpentingcuan"))) {
                    Toast.makeText(MainActivity.this, "Login Berhasil!",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, DetailDataUser.class);
                    startActivity(intent);
                }

                else if (TextUtils.isEmpty(id.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Kolom Username tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(pass.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Kolom Password tidak boleh kosong !",
                            Toast.LENGTH_SHORT).show();
                }

                else {
                    showAlertDialog();
                }
            }
        });

    }

    public void showAlertDialog () {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Login Gagal");
        alertBuilder.setMessage("Username atau password salah, silahkan coba lagi!");

        alertBuilder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                id.getText().clear();
                pass.getText().clear();
            }
        });
        alertBuilder.show();
    }

}