package com.example.my_pc.utsprakmobpro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by My-PC on 27/10/2016.
 */
public class SessionManager {
    SharedPreferences pref;
    // Editor untuk Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Sharedpref file name
    private static final String PREF_NAME = "LatihanPref";
    // Semua Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    // Nama User (buat dengan variable public agar dapat di akses dari luar)
    public static final String KEY_NAME = "name";
    // Alamat Email address (buat dengan variable public agar dapat di akses dari luar)
    public static final String KEY_EMAIL = "email";
    // Constructor
    public static final String KEY_NAMA_ANDA = "Nama";
    public static final String KEY_NIM = "NIM";
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    /**
     * Membuat login session
     * */
    public void createLoginSession(String Nama,String Nim){
        // menyimpan login dengan nilai TRUE
        editor.putBoolean(IS_LOGIN, true);
        // menyimpan nama di pref
        editor.putString(KEY_NAME, Nama);
        // menyimpan email di pref

        editor.putString(KEY_NIM, Nim);
        // Simpan Perubahan
        editor.commit();
    }

    /**
     * Mendapatkan session data yang tersimpan
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // nama user
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        // user email id
        user.put(KEY_NIM, pref.getString(KEY_NIM, null));
        // return user
        return user;
    }

    /**
     * Mendapatkan session data yang tersimpan
     * */
    public HashMap<String, String> getTampilan(){
        HashMap<String, String> viewtampil = new HashMap<String, String>();
        // nama user
        viewtampil.put(KEY_NAMA_ANDA, pref.getString(KEY_NAMA_ANDA, null));
        // user email id
        viewtampil.put(KEY_NIM, pref.getString(KEY_NIM, null));
        // return user
        return viewtampil;
    }
    /**
     * metode Check login akan mengecek login status
     * jika false maka akan mengarahkan ke page Login
     * jika tidak maka tidak ada perubahan
     * */
    public void checkLogin(){
        // Cek login status
        if(!this.isLoggedIn()){
            // jika user tidak login maka akan d arahakan ke Login Activity
            Intent i = new Intent(_context, MainActivity.class);
            // tutup semua Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // tambahkan Flag baru untuk memulai Activity baru
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // membuka Activity Login
            _context.startActivity(i);
        }
    }
    /**
     * cek user login
     * **/
    // mendapatkan Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
    /**
     * Menghapus detail session
     * */
    public void logoutUser(){
        // menghapus semua data dari Shared Preferences
        editor.clear();
        editor.commit();
        // setelah logout user diarahkan ke LoginActivity
        Intent i = new Intent(_context, MainActivity.class);
        // tutup semua Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // tambahkan Flag baru untuk memulai Activity baru
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // membuka Activity Login
        _context.startActivity(i);
    }

    public void viewTampilan(String s, String s1) {
    }
}
