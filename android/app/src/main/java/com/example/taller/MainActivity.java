package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String email = "", pass = "";
        EditText c = findViewById(R.id.correo);
        EditText cl = findViewById(R.id.clave);
        email = c.getText().toString();
        pass = cl.getText().toString();

        if(email.isEmpty() && pass.isEmpty()){

        }
    }


}
