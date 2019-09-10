package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
        EditText c, cl;
        String email = "", pass = "";
        String mycorreo = "maicolcr97@hotmail.com";
        String myclave = "12345";
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        c = findViewById(R.id.correo);
        cl = findViewById(R.id.clave);
       
    }

    public void validar(View view){
        email = c.getText().toString();
        pass = cl.getText().toString();

        if(email.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Los campos estan vacios", Toast.LENGTH_SHORT).show();
        }else if(!email.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "La contraseña está vacia", Toast.LENGTH_SHORT).show();
        }else if(email.isEmpty() && !pass.isEmpty()){
            Toast.makeText(this, "El correo está vacio", Toast.LENGTH_SHORT).show();
        }else{
            if(mycorreo.equals(email) && myclave.equals(pass)){
                Toast.makeText(this, "Login Ok", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
