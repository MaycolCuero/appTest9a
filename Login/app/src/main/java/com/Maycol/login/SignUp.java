package com.Maycol.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Maycol.login.classes.connectionDB;

public class SignUp extends AppCompatActivity {
    EditText fname;
    EditText lname;
    EditText emaiñ;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fname = findViewById(R.id.txtIdFirstName);

        Button btn2 = (Button) findViewById(R.id.btnRegister);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent2, 0);
            }
        });



    }

    public void Signup(View view){
        //cerate the conneciton assistent
        connectionDB manager = new connectionDB(this, "data",null,1);
        //Let read/write on DB
        SQLiteDatabase market = manager.getWritableDatabase();
        //Get values
        String FName = fname.getText().toString();
        String LName = "";
        String Email = "";
        String Pass = "";

        ContentValues DATA = new ContentValues();

        DATA.put("firstname",FName);
        DATA.put("lastname",LName);
        DATA.put("email",Email);
        DATA.put("pass", Pass);

        //Save values into DB
        market.insert("users", null,DATA);
        Toast.makeText(this,"The user", Toast.LENGTH_LONG);
        market.close();
    }
}
