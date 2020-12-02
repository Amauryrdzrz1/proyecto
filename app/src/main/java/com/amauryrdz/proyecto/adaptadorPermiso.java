package com.amauryrdz.proyecto;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class adaptadorPermiso extends RecyclerView.Adapter<adaptadorPermiso.Miholder> {

    private List<Permisos> ListaPermiso;
    private Activity activity;

    public adaptadorPermiso(List<Permisos> listaPermiso, Activity activity) {
        this.ListaPermiso = listaPermiso;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Miholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vistaPermiso = LayoutInflater.from(parent.getContext()).inflate(R.layout.activitypermissions,parent,false);
        return new Miholder(vistaPermiso);
    }

    @Override
    public void onBindViewHolder(@NonNull Miholder holder, int position) {

        Permisos modelo = ListaPermiso.get(position);
        holder.setData(modelo,activity);
    }

    @Override
    public int getItemCount() {
        return ListaPermiso.size();
    }

    public class Miholder extends RecyclerView.ViewHolder{

        private Switch permisosss;
        public String completepermision; // para guardar el permiso solicitado.
        public Activity activity;

        public Miholder(@NonNull final View itemView) {
            super(itemView);

            permisosss = itemView.findViewById(R.id.switch1);

            permisosss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        int equisequis = ActivityCompat.checkSelfPermission(itemView.getContext(), completepermision);
                        if (equisequis != PackageManager.PERMISSION_GRANTED) {

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                ActivityCompat.requestPermissions(activity, new String[]{completepermision}, 26);
                                return;
                            }
                        }
                        Toast.makeText(itemView.getContext(), completepermision, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        public void setData(final Permisos modelo, Activity activity) {

            permisosss.setText(modelo.getNombre());
            completepermision = modelo.getNombrepermiso();
            this.activity = activity;
        }
    }
}


