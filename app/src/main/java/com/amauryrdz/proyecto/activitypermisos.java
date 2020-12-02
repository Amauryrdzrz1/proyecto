package com.amauryrdz.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Intent.ACTION_CALL;

public class activitypermisos extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerViewpermiso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitypermisos);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        recyclerViewpermiso = findViewById(R.id.rvview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewpermiso.setLayoutManager(layoutManager);


        final List<Permisos> ListaPermisos = new ArrayList<>();

        ListaPermisos.add(new Permisos("LLAMADAS", Manifest.permission.CALL_PHONE));
        ListaPermisos.add(new Permisos("CAMARA", Manifest.permission.CAMERA));



        final adaptadorPermiso Permisos = new adaptadorPermiso(ListaPermisos, this);
        recyclerViewpermiso.setAdapter(Permisos);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}