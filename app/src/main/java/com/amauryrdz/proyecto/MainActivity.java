package com.amauryrdz.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText loginemail,logincontra;
    TextView linkRegistro;
    Button botonlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginemail      = (EditText) findViewById(R.id.loginemail);
        logincontra     = (EditText) findViewById(R.id.logincontra);
        linkRegistro    = (TextView) findViewById(R.id.linkRegistro);
        botonlogin      = (Button) findViewById(R.id.botonlogin);

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

            }
        });
    }
}