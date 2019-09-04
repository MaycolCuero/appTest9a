package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
        EditText c, cl;
        String email = "", pass = "";
        
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
        }else if(email != pass){
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Login Ok", Toast.LENGTH_SHORT).show();
        }
    }


}
