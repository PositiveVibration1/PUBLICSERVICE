package com.example.positivevibes.publicservice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import java.net.URL;

public class Interface extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);


    }
    public void ecitizen(View view){
        Intent ecitizenIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://account.ecitizen.go.ke"));
        startActivity(ecitizenIntent);
    }

    public void mygov(View view){
        Intent mygovIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mygov.go.ke"));
        startActivity(mygovIntent);
    }

    public void KRA(View view){
        Intent KRAIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://itax.kra.go.ke"));
        startActivity(KRAIntent);
    }

    public void Uwezo(View view){
        Intent UwezoIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.go.ke"));
        startActivity(UwezoIntent);
    }
}
