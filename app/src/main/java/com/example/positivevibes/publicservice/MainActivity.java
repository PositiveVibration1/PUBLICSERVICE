package com.example.positivevibes.publicservice;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Fname;
    private EditText EditPassword;
    private Button Login;
    TextView Register;
    TextView NonAdmin;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Fname=(EditText) findViewById(R.id.Fname);
         EditPassword=(EditText) findViewById(R.id.EditPassword);
         Login=(Button)findViewById(R.id.login);
         Register=(TextView)findViewById(R.id.Register);
         NonAdmin=(TextView)findViewById(R.id.NonAdmin);

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);
        progressDialog=new ProgressDialog(this);




        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent= new Intent(MainActivity.this,RegisterActivity.class);
                MainActivity.this.startActivity(RegisterIntent);
            }
        });

        NonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NonUser= new Intent(MainActivity.this,Drawer.class);
                MainActivity.this.startActivity(NonUser);
            }
        });



    }

    private void userLogin(){
        final String username=Fname.getText().toString().trim();
        final String password=EditPassword.getText().toString().trim();


        progressDialog.setMessage("wait userLogin..");
        progressDialog.show();

        StringRequest loginRequest1=new StringRequest(Request.Method.POST,
                LoginRequest.URL_LOGIN_REQUEST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();


                        AlertDialog.Builder builder1=new AlertDialog.Builder(MainActivity.this);
                        builder1.setMessage("Login is successful")
                                .setNegativeButton("okay", null)
                                .create()
                                .show();

                        Intent profile=new Intent(MainActivity.this,Drawer.class);
                        MainActivity.this.startActivity(profile);


                        /*try {
                            JSONObject jsonObject=new JSONObject(response);
                            jsonObject.getString(response);
                            boolean success=jsonObject.getBoolean("success");
                            if(jsonObject.getBoolean("success")){
                                Intent  intent=new Intent(MainActivity.this,Practise.class);
                                MainActivity.this.startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Login failed1")
                                        .setNegativeButton("retry later",null)
                                        .create()
                                        .show();

                            }

                        }*/ /*catch (JSONException e) {
                            e.printStackTrace();
                        }*/

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Login failed")
                                .setNegativeButton("retry", null)
                                .create()
                                .show();


                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                return params;
            }
        };

       /* Response.Listener<String>responseListener=new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    boolean success=jsonObject.getBoolean("success");
                    if(success){
                        String name=jsonObject.getString("name");
                        String password=jsonObject.getString("password");
                        Intent intent=new Intent(MainActivity.this,Practise.class);
                        intent.putExtra("name",name);
                        intent.putExtra("password",password);
                        MainActivity.this.startActivity(intent);
                    }
                    else{
                        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Login failed")
                               .setNegativeButton("retry later",null)
                              .create()
                                .show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Login failed")
                                .setNegativeButton("retry", null)
                                .create()
                               .show();


                    }
                };*/
        /*LoginRequest logiNRequest=new LoginRequest(username,password,responseListener);*/
        RequestQueue request= Volley.newRequestQueue(this);
        request.add(loginRequest1);
    }




        @Override
    public void onClick(View v) {

            userLogin();


    }
}
