package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private VolleySingleton cartero;
    private RequestQueue carta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cartero = VolleySingleton.getInstance(this.getApplicationContext());
        carta = cartero.getRequestQueue();
    }

    public void registro(View view) {
        String urlRegistro = "http://192.168.0.7:8000/api/registro/user";
        EditText email = findViewById(R.id.email);
        EditText pass = findViewById(R.id.pass);
        String emailtxt = email.getText().toString();
        String passtxt = pass.getText().toString();
        JSONObject request = new JSONObject();
        try {
            request.put("email",emailtxt);

            request.put("password",passtxt);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest cartaJ = new JsonObjectRequest(Request.Method.POST, urlRegistro, request, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject responseJSON = response.getJSONObject("Usuario");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this,"Usuario Registrado", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        carta.add(cartaJ);
    }
    public void login(View view) {
        String urlRegistro = "http://192.168.0.7:8000/api/login/user";
        EditText email = findViewById(R.id.email);
        EditText pass = findViewById(R.id.pass);
        String emailtxt = email.getText().toString();
        String passtxt = pass.getText().toString();
        JSONObject request = new JSONObject();
        try {
            request.put("email",emailtxt);
            request.put("password",passtxt);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest cartaJ = new JsonObjectRequest(Request.Method.POST, urlRegistro, request, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject responseJSON = response.getJSONObject("token");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                Intent int2 = new Intent(MainActivity.this, MainScreen.class);
                startActivity(int2);
                finish();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString() , Toast.LENGTH_SHORT).show();
            }

    });
        carta.add(cartaJ);
    }
}