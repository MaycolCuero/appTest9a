package com.maycol.curso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class SingUp extends AppCompatActivity {

    private EditText a, b, c, d, e;
    private TextView f, g, h, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        a = findViewById(R.id.idFname);
        b = findViewById(R.id.idLname);
        c = findViewById(R.id.idEmail);
        d = findViewById(R.id.idPass);
        e = findViewById(R.id.idMphone);

    }

    public void validate(View view){
        f.setText(a.getText());
    }
}
