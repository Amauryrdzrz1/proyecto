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

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText loginemail,logincontra;
    TextView linkRegistro;
    Button botonlogin;
    private RequestQueue requestQueue;
    private Volley mVolley;
    //crear variables estaticas de app y administrador de preferencias
    public static MainActivity mainActivity;
    public static AdministrarPreferencias administrarPreferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        loginemail      = (EditText) findViewById(R.id.loginemail);
        logincontra     = (EditText) findViewById(R.id.logincontra);
        linkRegistro    = (TextView) findViewById(R.id.linkRegistro);
        botonlogin      = (Button) findViewById(R.id.botonlogin);
        mVolley = com.amauryrdz.proyecto.Volley.getInstance(this.getApplicationContext());
        requestQueue = mVolley.getmResquestQueue();

        /*/crear instancia estatica de la app
        public static MainActivity getInstance() {
            return mainActivity;

        }
        //crear instancia estatica de administrarpreferencias
        public static AdministrarPreferencias getAdministrarPreferencias() {
            if(administrarPreferencias == null){
                administrarPreferencias = new AdministrarPreferencias(getInstance);
            }

            return administrarPreferencias;
        }
        linkRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegistroActividad.class);
                startActivity(i);
            }
        });
        */
        botonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1 = "http://192.168.1.163:8000/api/login";
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
                        Toast.makeText(MainActivity.this, JsonObject.toString(), Toast.LENGTH_SHORT).show();
                        Log.i("Request", JsonObject.toString());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                requestQueue.add(request);
                Intent i = new Intent(MainActivity.this, bienvenida.class);
                startActivity(i);
            }
        });
    }
}