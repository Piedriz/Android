package com.example.tallerunimaguno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener  {
    Button mats,sesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mats = findViewById(R.id.matematica);
        sesion = findViewById(R.id.cerrarsesion);
        mats.setOnClickListener(this);
        sesion.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mnugeometria:
                Toast.makeText(getApplicationContext(), "MENU GEOMETRIA", Toast.LENGTH_LONG).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.matematica:
                Intent i = new Intent(getApplicationContext(),Matematicas.class);
                startActivity(i);
                break;
            case R.id.cerrarsesion:
                onBackPressed();
        }

    }
}