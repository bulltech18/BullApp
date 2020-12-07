package com.example.examen;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PermisosMain extends AppCompatActivity {
    RecyclerView rvPermisos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void mandar(){
        List<Permisos> permisosList= new ArrayList<>();
        permisosList.add(new Permisos(Manifest.permission.CALL_PHONE));
        permisosList.add(new Permisos(Manifest.permission.ACCESS_FINE_LOCATION));
        PermisosAdaptador adapter = new PermisosAdaptador(permisosList, this);
        rvPermisos.setAdapter(adapter);

    }



}
