package com.example.my_pc.utsprakmobpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by My-PC on 27/10/2016.
 */
public class History extends AppCompatActivity {
    private TextView booking;
    private String detail_booking;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailbooking);
        booking = (TextView)
                findViewById(R.id.booking);
        btnBack = (Button) findViewById(R.id.btnBack);
        final Bundle bookArrayList = getIntent().getExtras();
//final ArrayList<String> stringArray = new ArrayList<>(); //no need for this line
        ArrayList<String> bookArray = bookArrayList.getStringArrayList("book"); //just declare and assign
        detail_booking="";
        for (int i=0; i<bookArray.size(); i++){
            detail_booking += bookArray.get(i) + "\n";
        }
        booking.setText(detail_booking);
        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
