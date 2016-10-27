package com.example.my_pc.utsprakmobpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by My-PC on 27/10/2016.
 */
public class Fragmentprofil extends AppCompatActivity {
    TextView nama, nim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_main);

        nama = (TextView) findViewById(R.id.Nama);
        nim = (TextView) findViewById(R.id.Nim);

    }
}
