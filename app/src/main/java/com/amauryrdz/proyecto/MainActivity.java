package com.amauryrdz.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText loginemail,logincontra;
    TextView linkRegistro;
    Button botonlogin;
    private RequestQueue requestQueue;
    private Volley mVolley;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginemail      = (EditText) findViewById(R.id.loginemail);
        logincontra     = (EditText) findViewById(R.id.logincontra);
        linkRegistro    = (TextView) findViewById(R.id.linkRegistro);
        botonlogin      = (Button) findViewById(R.id.botonlogin);
        mVolley = com.amauryrdz.proyecto.Volley.getInstance(this.getApplicationContext());
        requestQueue = mVolley.getmResquestQueue();
        SharedPreferences appSharedPrefs = getSharedPreferences("settings",MODE_PRIVATE);
        SharedPreferences.Editor appEditor = appSharedPrefs.edit();

//        Toast.makeText(MainActivity.this, appSharedPrefs.getString("TOKEN_KEY","NO_TOKEN").toString(), Toast.LENGTH_SHORT).show();

        linkRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegistroActividad.class);
                startActivity(i);
            }
        });
        botonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1 = "http://www.cisco16.ml/api/login";
                JSONObject login = new JSONObject();
                try {
                    login.put("email", loginemail.getText());
                    login.put("password", logincontra.getText());
                }catch (JSONException e){
                    e.printStackTrace();
                }
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url1, login, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject JsonObject) {
//                        Toast.makeText(MainActivity.this, JsonObject.toString(), Toast.LENGTH_SHORT).show();
//                        VolleyLog.v("v_respuesta", JsonObject.toString());
//                        Log.d("respuesta", JsonObject.toString());

                        String token = null;
                        try {
                            token = JsonObject.getString("token");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//                        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                        Log.d("respuesta", token);
                        appEditor.putString("TOKEN_KEY",token);
                        appEditor.commit();
                        Intent i = new Intent(MainActivity.this, bienvenida.class);
                        startActivity(i);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }){
                    @Override
                    public Map<String, String> getHeaders(){
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("content_type","application/json");
                        params.put("bearer","access_token");
                        return params;
                    }
                };
                requestQueue.add(request);

            }
        });
    }
}