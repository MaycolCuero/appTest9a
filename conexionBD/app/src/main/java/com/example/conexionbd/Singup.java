package com.example.conexionbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conexionbd.clases.connectionBD;

public class Singup extends AppCompatActivity {

    EditText fname, lname, email, pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        fname = findViewById(R.id.IdFname);
        lname = findViewById(R.id.IdLname);
        email = findViewById(R.id.IdEmail);
        pwd= findViewById(R.id.IdPass);
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
        String Passwd = pwd.getText().toString();

        if (!Fname.isEmpty() && !Lname.isEmpty() && !Email.isEmpty() && !Passwd.isEmpty()){
            //Validacion para que el correo no se repita

            Cursor row = market.rawQuery("SELECT email FROM users WHERE email = '" + Email + "'",null);

            //if (row.moveToFirst())
            if (row.getCount() > 0){
                email.setError("el usuario ya existe");
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
            } else {
                ContentValues DATA = new ContentValues();

                DATA.put("firstname", Fname);
                DATA.put("lastname", Lname);
                DATA.put("email", Email);
                DATA.put("password", Passwd);

                //Guardar valores en BD
                market.insert("users", null, DATA);
                market.close();

                fname.setText("");
                lname.setText("");
                email.setText("");
                pwd.setText("");

                Toast.makeText(this, "El usuario fue creado", Toast.LENGTH_SHORT).show();
            }
        }else{
            if (!Fname.isEmpty()){
                lname.setError("El campo no puede ser vacio");
                email.setError("El campo no puede ser vacio");
                pwd.setError("El campo no puede ser vacio");
            } else if (Lname.isEmpty()){
                fname.setError("El campo no puede ser vacio");
                email.setError("El campo no puede ser vacio");
                pwd.setError("El campo no puede ser vacio");
            } else if(Email.isEmpty()){
                fname.setError("El campo no puede ser vacio");
                lname.setError("El campo no puede ser vacio");
                pwd.setError("El campo no puede ser vacio");
            } else if (Passwd.isEmpty()){
                fname.setError("El campo no puede ser vacio");
                lname.setError("El campo no puede ser vacio");
                email.setError("El campo no puede ser vacio");
            } else {
                Toast.makeText(this, "Los campos estan vacios", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
