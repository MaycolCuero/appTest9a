package com.example.conexionbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conexionbd.clases.connectionBD;

public class Singup extends AppCompatActivity {

    EditText fname, lname, email, passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        fname = findViewById(R.id.idFname);
        lname = findViewById(R.id.idLname);
        email = findViewById(R.id.idEmail);
        passwd = findViewById(R.id.idPassword);
    }

    public void Signup(View view){
        //crear el asistente de conexion
        connectionBD manager = new connectionBD( this, "market", null, 1);
        //leer y escribir en la BD
        SQLiteDatabase market = manager.getWritableDatabase();
        //Obtener valores
        String Fname = fname.getText().toString();
        String Lname = lname.getText().toString();
        String Email = email.getText().toString();
        String Passwd = passwd.getText().toString();

        if (!Fname.isEmpty() && !Lname.isEmpty() && !Email.isEmpty()
                && !Passwd.isEmpty()){

            // validation: Don`t repeat email if exists
            ContentValues DATA = new ContentValues();

            DATA.put("firstname", Fname);
            DATA.put("lastname", Lname);
            DATA.put("email", Email);
            DATA.put("password", Passwd);
            fname.setText("");
            passwd.setText("");
            email.setText("");
            lname.setText("");

            //Guardar valores en BD
            market.insert("users", null, DATA);
            Toast.makeText(this, "El usuario fue creado", Toast.LENGTH_SHORT).show();
            market.close();
        }else{
            Toast.makeText(this, "There are empty fields ", Toast.LENGTH_SHORT).show();
            fname.setError("field can`t be emty");
            passwd.setError("field can`t be emty");
            email.setError("field can`t be emty");
            lname.setError("field can`t be emty");
        }

    }
}
