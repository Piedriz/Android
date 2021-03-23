package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.GetChars;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

 EditText usuario, clave;
 Button ingresar, registro;
 CheckBox tyc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.edtusuario);
        clave = findViewById(R.id.edtclave);
        ingresar = findViewById(R.id.btningresar);
        ingresar.setEnabled(false);
        registro = findViewById(R.id.btnregistrar);
        tyc = findViewById(R.id.terminos);
        ingresar.setOnClickListener(this);
        registro.setOnClickListener(this);
        tyc.setOnClickListener(this);
        preferencias();
        usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPreferencias();
            }
        });
        us[0] = new Users("hola","mundo");
        us[1] = new Users("user","user");
        us[2] = new Users("admin","admin");

    }
    int cont = 0;
    boolean encontrado = false;
    Users[] us = new Users[100];

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    public void preferencias(){
        SharedPreferences mispreferencias = getSharedPreferences("preferenciaUsuario", Context.MODE_PRIVATE);
        usuario.setText(mispreferencias.getString("edtusuario", " "));
    }

    public void guardarPreferencias(){
        String nombreUser = usuario.getText().toString();
        SharedPreferences mispreferencias = getSharedPreferences("preferenciaUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putString("edtusuario",nombreUser);
        editor.commit();
    }

    int i;
    int numusers=2;
    String nuevouser;
    String nuevapass;


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.terminos:
                if (tyc.isChecked()) {
                    ingresar.setEnabled(true);
                } else
                    ingresar.setEnabled(false);

                break;
            case R.id.btningresar:
                while (i <= numusers){
                    if ((usuario.getText().toString().equals(us[i].getName())) &&
                            (clave.getText().toString().equals(us[i].getPass()))) {
                        encontrado = true;
                        break;
                    }else{
                        encontrado =false;
                    }
                    i =i+1;
                }
                i = 0;
                if (encontrado == true) {
                    Intent x = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(x);
                } else {
                    Toast.makeText(getApplicationContext(), "Error credenciales", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnregistrar:
                Intent i = new Intent(getApplicationContext(),RegistroActivity.class);
                startActivity(i);
                    break;
        }
    }
}