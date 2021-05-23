package com.example.rg_la_pp_cluedo.BBDD;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rg_la_pp_cluedo.ActivityMain;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class DataBaseConnection extends AppCompatActivity {

    private FirebaseDatabase firebaseObj = null;
    private DatabaseReference databaseRefObj = null;
    private static DataBaseConnection connection = null;

    private DataBaseConnection(){

    }

    public static DataBaseConnection getInstance(){
        if(connection == null){
             return connection = new DataBaseConnection();
        }
        return connection;
    }


    public DatabaseReference getFirebase(Context context){
        FirebaseApp.initializeApp(context);
        firebaseObj = FirebaseDatabase.getInstance();
        firebaseObj.setPersistenceEnabled(true);
        databaseRefObj = firebaseObj.getReference();

        return databaseRefObj;
    }

}