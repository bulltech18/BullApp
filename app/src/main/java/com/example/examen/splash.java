package com.example.examen;

import android.Manifest;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class splash extends AppCompatActivity {
    RecyclerView rvPermisos;
    private static final int REQUEST_CODE_ASK_PERMISSION = 112 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_inicio);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                int p1 = ActivityCompat.checkSelfPermission(splash.this, Manifest.permission.CALL_PHONE);
                int p2 = ActivityCompat.checkSelfPermission(splash.this, Manifest.permission.ACCESS_FINE_LOCATION);

                if (p1 == PackageManager.PERMISSION_DENIED || p2 == PackageManager.PERMISSION_DENIED){
                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                        //ActivityCompat.requestPermissions(splash.this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_ASK_PERMISSION );
                        Intent permisos = new Intent(splash.this, PermisosActivity.class);
                        startActivity(permisos);
                        finish();

                    }
                }else {
                    Intent home = new Intent(splash.this, MainActivity.class);
                    startActivity(home);
                    finish();
                }


            }
        },2000);
    }
}
