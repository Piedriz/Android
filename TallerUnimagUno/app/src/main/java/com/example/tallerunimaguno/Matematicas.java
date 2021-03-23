package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Matematicas extends AppCompatActivity implements View.OnClickListener {

    EditText n1,n2;
    RadioGroup op;
    RadioButton suma,resta,multiplicacion,divicion;
    Button calcular, borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas);
        n1 = findViewById(R.id.numero_uno);
        n2 = findViewById(R.id.numero_dos);
        op = findViewById(R.id.operacion);
        calcular = findViewById(R.id.calcular);
        borrar = findViewById(R.id.borrar_dato);
        calcular.setOnClickListener(this);
        borrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calcular:
                if (validar()==true){
                   float num1 = Float.parseFloat(n1.getText().toString());
                   float num2 = Float.parseFloat(n2.getText().toString());


                    int id = op.getCheckedRadioButtonId();
                    switch (id){
                        case R.id.suma:
                            Toast.makeText(getApplicationContext(), "la suma es: " + (num1+num2),Toast.LENGTH_LONG).show();
                            break;
                        case R.id.resta:
                            Toast.makeText(getApplicationContext(),"la resta es: "+ (num1-num2),Toast.LENGTH_LONG).show();
                            break;
                        case R.id.multiplicacion:
                            Toast.makeText(getApplicationContext(),"la multiplicación es: "+(num1*num2),Toast.LENGTH_LONG).show();
                            break;
                        case R.id.divicion:
                            Toast.makeText(getApplicationContext(),"la divición es: "+(num1/num2),Toast.LENGTH_LONG).show();
                            break;
                    }
                }
                break;
            case R.id.borrar_dato:
                borrar();
                break;
        }

    }
    public void borrar(){
        n1.setText("");
        n2.setText("");
    }

    public boolean validar(){
        if (TextUtils.isEmpty(n1.getText()) || !TextUtils.isDigitsOnly(n1.getText())){
            return false;

        }else{
            if (TextUtils.isEmpty(n2.getText()) || !TextUtils.isDigitsOnly(n2.getText())){
                return false;
            }else{
                return true;
            }

        }
    }
}