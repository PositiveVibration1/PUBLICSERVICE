package com.example.positivevibes.publicservice;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by POSITIVE VIBES on 3/20/2018.
 */

public class Constants extends StringRequest {
    private static final String ROOT_URL="http://192.168.101.1/android/";
    public static final String URL_REGISTER=ROOT_URL+"newRegistration.php";
    private Map<String, String> params;

    public Constants(String username, String password, String email, Response.Listener<String>listener){
        super(Request.Method.POST,URL_REGISTER, listener,null);
        params=new HashMap<>();
        params.put("name",username);
        params.put("password",password);
        params.put("email",email);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
