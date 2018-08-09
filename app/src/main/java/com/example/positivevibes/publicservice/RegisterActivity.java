package com.example.positivevibes.publicservice;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Username,EditPassword,EditEmail;
    private ProgressDialog progressDialog;
    private TextView TextUserLogin;

    private Button Register2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username=(EditText)findViewById(R.id.Username);
        EditPassword=(EditText)findViewById(R.id.EditPassword);
        EditEmail=(EditText) findViewById(R.id.EditEmail);
        TextUserLogin=(TextView)findViewById(R.id.TextuserLogin);
        Register2=(Button)findViewById(R.id.Register2);

        Register2.setOnClickListener(this);
        TextUserLogin.setOnClickListener(this);
        progressDialog=new ProgressDialog(this);

        TextUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TextUserLoginIntent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(TextUserLoginIntent);


            }
        });

        //Register2.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View v) {
             //   Intent LoginIntent= new Intent(RegisterActivity.this, Practise.class);
              //  RegisterActivity.this.startActivity(LoginIntent);
           // }
       // });
    }

    private void RegisterUser(){
        final String username=Username.getText().toString().trim();
        final String password=EditPassword.getText().toString().trim();
        final String email=EditEmail.getText().toString().trim();

        progressDialog.setMessage("Registering user..");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        AlertDialog.Builder builder= new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("Registered Successfully")
                                .setNegativeButton("successful",null)
                                .create()
                                .show();

                        Intent profile1=new Intent(RegisterActivity.this,MainActivity.class);
                        RegisterActivity.this.startActivity(profile1);




                       try {
                           JSONArray jsonArray=new JSONArray(response);
                           JSONObject jsonObject=jsonArray.getJSONObject(0);
                           String code=jsonObject.getString("code");
                           String message=jsonObject.getString("message");
                           AlertDialog.Builder builder2= new AlertDialog.Builder(RegisterActivity.this);
                           builder2.setTitle("Server Response...");
                           builder2.setMessage(message)
                                   .setNegativeButton(code,null)
                                   .create()
                                   .show();



                           /*JSONObject jsonObject=new JSONObject(response);
                            boolean success=jsonObject.getBoolean("success");
                            if(jsonObject.getBoolean("success")){

                                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                               RegisterActivity.this.startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder1= new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register failed1")
                                        .setNegativeButton("retry later",null)
                                        .create()
                                        .show();

                            }*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("To Register failed")
                                .setNegativeButton("retry", null)
                                .create()
                                .show();
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();


                    }
                }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("username",username);
                params.put("email",email);
                params.put("password",password);
                return params;
            }
        };






        //Constants registerRequest=new Constants(username,password,email,responseListener);

        RequestQueue request= Volley.newRequestQueue(RegisterActivity.this);
        request.add(stringRequest);
    }

    @Override
    public void onClick(View v){
            RegisterUser();
            if(Username.equals("")||EditPassword.equals("")||EditEmail.equals("")){
                AlertDialog.Builder builder3=new AlertDialog.Builder(RegisterActivity.this);
                builder3.setTitle("please fill all the fields");
                builder3.setMessage("Something is wrong.....")
                        .setNegativeButton("retry", null)
                        .create()
                        .show();


            }


    }
}
