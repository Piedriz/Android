package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.function.Function;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,lastname,mail,password;
    Button complit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        name.findViewById(R.id.registronombre);
        lastname.findViewById(R.id.registroapellido);
        mail.findViewById(R.id.correo);
        password.findViewById(R.id.registrocontraseña);
        complit.findViewById(R.id.completar);
        complit.setOnClickListener(this);



    }

    public boolean validardatos(){
        if(name.getText().toString().isEmpty() && lastname.getText().toString().isEmpty() && mail.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
            return false;
            }else if(password.getText().toString().length() <6){
            return false;
        }else{
            return true;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.completar:
                if (validardatos()){
                    //registros(name.getText().toString(),password.getText().toString());
                    Toast.makeText(getApplicationContext(), "Registro completado", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(), "Error, verifique los campos", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

}