package com.example.my_pc.utsprakmobpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by My-PC on 27/10/2016.
 */
public class Listmakanan extends AppCompatActivity {
    int[] gambar={
            R.drawable.bulgogi,
            R.drawable.chickenkatsu,
            R.drawable.chickenwings,
            R.drawable.sussi,
            R.drawable.sopbuah,
    };

    ListView list;

    String[] judul ={
            "Bulgogi",
            "Chickenkatsu",
            "ChickenWings",
            "Sussi",
            "Sopbuah",
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);


        // Inisialisasi CustomAdapter dengan Array yang telah dibuat
        CustomAdapter adapter = new CustomAdapter(this, gambar, judul);

        // Inisialisasi ListView
        list = (ListView) findViewById(R.id.ListGambar);

        // set Adapter ke dalam ListView
        list.setAdapter(adapter);

        // action ketika ListView di klik
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                Intent deskripsi = new Intent(Listmakanan.this, DeskripsiMakanan.class);
                startActivity(deskripsi);

                // String untuk mengambil judul pada Listview
                String Slecteditem = judul[position];

                // menampilkan judul dengan Toast
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
