package com.example.positivevibes.publicservice;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String ROOT_URL="http://192.168.101.1/android/";
    public static final String URL_LOGIN_REQUEST=ROOT_URL+"newVibes.php";

    private Map<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<String>listener){
        super(Request.Method.POST,URL_LOGIN_REQUEST, listener,null);
        params=new HashMap<>();
        params.put("name",username);
        params.put("password",password);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
