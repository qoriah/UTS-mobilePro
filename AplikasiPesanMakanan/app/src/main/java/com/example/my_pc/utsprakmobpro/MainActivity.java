package com.example.my_pc.utsprakmobpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Username, pw;
    // isi Shared Preferences 1
    private final String NAMA = "Qoriah";
    private final String EMAIL = "qoriahasri73@gmail.com";
    // Username dan password
    private final String USERNAME = "1137050176";
    private final String PASSWORD = "admin";
    // login button
    Button btnLogin;
    // Session Manager Class
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Session Manager
        session = new SessionManager(getApplicationContext());
        // Email, Password input text
        Username = (EditText) findViewById(R.id.Username);
        pw = (EditText) findViewById(R.id.pw);
        // Menampilkan Status Login dengan Toast
        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();
        // Login button
        btnLogin = (Button) findViewById(R.id.btnLogin);
        // Login button onClick event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Get username, password from EditText
                String username = Username.getText().toString();
                String password = pw.getText().toString();
                // cek jika username dan password terisi
                if(username.trim().length() > 0 && password.trim().length() >
                        0){
                    // jika username dan password sesuai dengan data
                    if(username.equals(USERNAME) && password.equals(PASSWORD)){
                        // membuat user login session
                        // menyimpan data nama dan email
                        session.createLoginSession(NAMA, EMAIL);
                        // Mengarahkan ke MainActivity
                        Intent i = new Intent(getApplicationContext(),
                                MainActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        // username / password tidak sesuai
                        Toast.makeText(getApplicationContext(), "Login Gagal..\n"
                                + "Username/Password anda salah", Toast.LENGTH_LONG).show();
                    }
                }else{
                    // user tidak memasukan username atau password
                    Toast.makeText(getApplicationContext(), "Login Gagal..\n" +
                            "Silahlkan masukan username dan password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}


