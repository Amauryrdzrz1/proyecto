package com.amauryrdz.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActividad extends AppCompatActivity {
    Button botonregistrar;
    EditText nombreregistro, correoRegistro, AliasRegistro, passwordRegistro;
    private RequestQueue requestQueue;
    private Volley mVolley;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_actividad);
        nombreregistro      = (EditText) findViewById(R.id.nombreRegistro);
        correoRegistro      = (EditText) findViewById(R.id.correoRegistro);
        AliasRegistro       = (EditText) findViewById(R.id.AliasRegistro);
        passwordRegistro    = (EditText) findViewById(R.id.passwordRegistro);
        botonregistrar      = (Button) findViewById(R.id.botonregistrar);
        mVolley = Volley.getInstance(this.getApplicationContext());
        requestQueue = mVolley.getmResquestQueue();
        botonregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.1.163:8000/api/registro";
                JSONObject registro = new JSONObject();
                try {
                    registro.put("name", nombreregistro.getText());
                    registro.put("email", correoRegistro.getText());
                    registro.put("password", passwordRegistro.getText());
                    registro.put("alias", AliasRegistro.getText());

                }catch (JSONException e){
                    e.printStackTrace();
                }
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, registro, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject JsonObject) {
                        Toast.makeText(RegistroActividad.this, JsonObject.toString(), Toast.LENGTH_SHORT).show();
                        Log.i("Request", JsonObject.toString());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                requestQueue.add(request);
                Intent i = new Intent(RegistroActividad.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}