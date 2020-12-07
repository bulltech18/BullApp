package com.example.examen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PermisosActivity extends AppCompatActivity {
    RecyclerView rvPermisos;
    private static final int REQUEST_CODE_ASK_PERMISSION = 112 ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.permisos_main);
        rvPermisos = findViewById(R.id.rvPerm);
        rvPermisos.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvPermisos.setLayoutManager(linearLayoutManager);
        mandar();
    }

    public void call_phone(View view){
        int p1 = ActivityCompat.checkSelfPermission(PermisosActivity.this, Manifest.permission.CALL_PHONE);
        if (p1 == PackageManager.PERMISSION_DENIED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ActivityCompat.requestPermissions(PermisosActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSION);
                return;
            }
        }
    }
    public void location(View view){
        int p2 = ActivityCompat.checkSelfPermission(PermisosActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (p2 == PackageManager.PERMISSION_DENIED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ActivityCompat.requestPermissions(PermisosActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_ASK_PERMISSION);
                return;
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        int p1 = ActivityCompat.checkSelfPermission(PermisosActivity.this, Manifest.permission.CALL_PHONE);
        int p2 = ActivityCompat.checkSelfPermission(PermisosActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (requestCode == REQUEST_CODE_ASK_PERMISSION){
            if (permissions.length >= 1){
                int con = PackageManager.PERMISSION_DENIED;
                for (int i = 0; i < grantResults.length; i++){
                    con = grantResults[i];
                    if(con == PackageManager.PERMISSION_DENIED){
                        Toast.makeText(this, "Tienes que verificar los dos permisos", Toast.LENGTH_SHORT).show();

                        break;
                    }

                }
                if ( p1 == PackageManager.PERMISSION_GRANTED && p2 == PackageManager.PERMISSION_GRANTED) //con == PackageManager.PERMISSION_GRANTED){
                {
                    Intent permisos = new Intent(this, MainActivity.class);
                    startActivity(permisos);
                    finish();
                }

                }




            }
        }


    public void mandar(){
        final List<Permisos> permisosList= new ArrayList<>();
        permisosList.add(new Permisos(Manifest.permission.CALL_PHONE));
        permisosList.add(new Permisos(Manifest.permission.ACCESS_FINE_LOCATION));
        PermisosAdaptador adapter = new PermisosAdaptador(permisosList, this);


        /*adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String pe1 = permisosList.get(rvPermisos.getChildAdapterPosition(v)).getPermiso();
                int p1 = ActivityCompat.checkSelfPermission(PermisosActivity.this, Manifest.permission.CALL_PHONE);
                int p2 = ActivityCompat.checkSelfPermission(PermisosActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
               if (pe1 == "android.permission.CALL_PHONE"){
                   if (p1 == PackageManager.PERMISSION_DENIED) {
                       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                           ActivityCompat.requestPermissions(PermisosActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSION);
                           return;
                       }
                   }
               }

            }
        });*/
        rvPermisos.setAdapter(adapter);

    }
}

    /*public void lis(View view){
        int p1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        int p2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        SwitchCompat swCompat = findViewById(R.id.SwPermisos);
        if (swCompat.isChecked()){
            CharSequence text = swCompat.getText();

        if ("android.permission.CALL_PHONE".equals(text)) {
            if (p1 == PackageManager.PERMISSION_DENIED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSION);
                    return;
                }
            }


        }

            /*if ("android.permission.ACCESS_FINE_LOCATION".equals(text)) {
                if (p2 == PackageManager.PERMISSION_DENIED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_ASK_PERMISSION);
                    }
                }
            }*/










