package com.amauryrdz.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bienvenida extends AppCompatActivity {
    Button Tempe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        Tempe  = (Button) findViewById(R.id.buttonTemp);

    Tempe.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(bienvenida.this, temperatura.class);
            startActivity(i);
        }
    });
    }
}