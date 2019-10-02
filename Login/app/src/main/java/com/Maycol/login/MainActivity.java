package com.Maycol.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        if (email.isEmpty() && pass.isEmpty()) {

        }


    }
}
