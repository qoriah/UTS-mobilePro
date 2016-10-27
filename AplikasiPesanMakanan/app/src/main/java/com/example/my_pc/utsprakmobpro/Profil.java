package com.example.my_pc.utsprakmobpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by My-PC on 27/10/2016.
 */
public class Profil extends AppCompatActivity {
    TextView nama, nim;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_main);

        nama = (TextView) findViewById(R.id.Nama);
        nim = (TextView) findViewById(R.id.Nim);
        back = (Button) findViewById(R.id.btnBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bck = new Intent(Profil.this, MainActivity.class);
                startActivity(bck);
            }
        });

    }
}
