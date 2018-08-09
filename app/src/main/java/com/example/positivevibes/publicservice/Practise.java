package com.example.positivevibes.publicservice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Practise extends AppCompatActivity {
    TextView UwezoFund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise);
        UwezoFund=(TextView)findViewById(R.id.UwezoFund);
    }
    public  void facebook(View view){
        Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/TheUwezoFund/"));
        startActivity(browser);
    }

    public  void twitter(View view){
        Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com/uwezofund"));
        startActivity(browser);
    }

    public  void youtube(View view){
        Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yuotube.com"));
        startActivity(browser);
    }

    public  void LinkedIn(View view){
        Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedIn.com"));
        startActivity(browser);
    }

    public void UwezoFund(View View){
        Intent UwezoIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uwezo.go.ke/"));
        startActivity(UwezoIntent);
    }

    public void youthfund(View View){
        Intent youthIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youthfund.go.ke"));
        startActivity(youthIntent);

    }

    public void wef(View View){
        Intent wefIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wef.co.ke/"));
        startActivity(wefIntent);
    }

    public void AccessG(View View){
        Intent AGPOIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.agpo.go.ke/register"));
        startActivity(AGPOIntent);
    }

    public void PSC(View View){
        Intent PSCIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.psckjobs.go.ke/Register.aspx"));
        startActivity(PSCIntent);
    }


}
