package com.example.examen;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PermisosAdaptador extends RecyclerView.Adapter<PermisosAdaptador.PermisosHolder> implements View.OnClickListener {
    List<Permisos> PermisosList;
    Activity PermisosActivity;
    private View.OnClickListener listener;
    private static final int REQUEST_CODE_ASK_PERMISSION = 112 ;
    public PermisosAdaptador(List<Permisos> PermisosList, Activity PermisosActivity) {
        this.PermisosList = PermisosList;
        this.PermisosActivity = PermisosActivity;
    }

    @NonNull
    @Override
    public PermisosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.permisos, parent, false);
        view.setOnClickListener(this);
        return new PermisosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PermisosHolder holder, final int position) {
    holder.addData(PermisosList.get(position));
    holder.swPer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //Toast.makeText(buttonView.getContext(),PermisosList.get(position).getPermiso(), Toast.LENGTH_SHORT).show();
           

        }
    });
    }

    @Override
    public int getItemCount() {
        return PermisosList.size();
    }
    public void setOnClickListener( View.OnClickListener listener ){
        this.listener= listener;
    }
    @Override
    public void onClick(View v) {
        if (listener!= null){
            listener.onClick(v);
        }
    }

    public class PermisosHolder extends RecyclerView.ViewHolder {
        SwitchCompat swPer;
        String permiso;
        public PermisosHolder(@NonNull View itemView) {
            super(itemView);
            swPer = itemView.findViewById(R.id.SwPermisos);
        }
        public void addData(Permisos permiso){
            swPer.setText(permiso.getPermiso());

        }

    }
}
