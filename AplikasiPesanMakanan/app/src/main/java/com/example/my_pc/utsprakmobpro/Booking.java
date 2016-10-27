package com.example.my_pc.utsprakmobpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Booking extends AppCompatActivity {
    private CheckBox check_mobile_programing,check_ekonomi_teknik;
    private Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);

        check_mobile_programing = (CheckBox)
                findViewById(R.id.cb_mobile_programing);
        check_ekonomi_teknik = (CheckBox)
                findViewById(R.id.cb_ekonomi_teknik);
        btn_next = (Button)
                findViewById(R.id.btn_next);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> myStringArray = new
                        ArrayList<>();
                if(check_mobile_programing.isChecked())
                    myStringArray.add(check_mobile_programing.getText().toString());

                if(check_ekonomi_teknik.isChecked())
                    myStringArray.add(check_ekonomi_teknik.getText().toString());
                Log.i("myStringArray", myStringArray.toString());
                Intent i = new Intent(Booking.this, History.class);
                i.putStringArrayListExtra("Booking", myStringArray);
                startActivity(i);
            }
        });
    }
}
