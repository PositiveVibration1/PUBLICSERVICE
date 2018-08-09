package com.example.positivevibes.publicservice;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class Drawer extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    TextView aGpo;
    TextView uWezo;
    TextView eCitizen;
    TextView WEF;
    TextView PSC;
    TextView YEF;
    Button FAQS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer);
        aGpo=(TextView)findViewById(R.id.aGpo);
        uWezo=(TextView)findViewById(R.id.uWezo);
        eCitizen=(TextView)findViewById(R.id.eCitizen);
        WEF=(TextView)findViewById(R.id.WEF);
        PSC=(TextView)findViewById(R.id.PSC);
        YEF=(TextView)findViewById(R.id.YEF);
        FAQS=(Button) findViewById(R.id.FAQS);



        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void aGpo(View View){
        Intent AGPOIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.agpo.go.ke/register"));
        startActivity(AGPOIntent);
    }

    public void imageView2(View View){
        Intent UwezoIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uwezo.go.ke/"));
        startActivity(UwezoIntent);
    }
    public void imageView7(View View){
        Intent youthIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youthfund.go.ke"));
        startActivity(youthIntent);

    }

    public void imageView5(View View){
        Intent wefIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wef.co.ke/"));
        startActivity(wefIntent);
    }

    public void imageView6(View View){
        Intent PSCIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.psckjobs.go.ke/Register.aspx"));
        startActivity(PSCIntent);
    }

    public void eCitizenImage(View view){
        Intent eCitizenIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://account.ecitizen.go.ke"));
        startActivity(eCitizenIntent);
    }

    public void FAQS(View view){
        Intent FAQSIntent=new Intent(Drawer.this,FrequentAskedQuestions.class);
        startActivity(FAQSIntent);
    }


    public void AccessToTender(View View){
        Intent AGPOIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.agpo.go.ke/register"));
        startActivity(AGPOIntent);
    }

    public void kraImage(View View){
        Intent AGPOIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.itax.go.ke"));
        startActivity(AGPOIntent);
    }

}


