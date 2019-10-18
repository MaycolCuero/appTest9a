package com.example.conexionbd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.conexionbd.clases.connectionBD;

import java.util.ArrayList;

public class ListUsers extends AppCompatActivity {

    //Llamar a la BD
    connectionBD market;
    // Crear la variable listview
    ListView UserList;
    //Crear un arreglo
    ArrayList<String> listItem;
    // Crear un adaptador
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        //Conexion bd
        market = new connectionBD(this, "market", null, 1);
        // Arreglo lista
        listItem = new ArrayList<>();
        // Traer el id del listview
        UserList = findViewById(R.id.IdListUsers);

        //Crear metodo para ver los datos
        viewData();


    }

    private void viewData() {
        Cursor cursor = market.SelectUserData();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No hay usuarios creados", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
                listItem.add(cursor.getString(2));
            }
            adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listItem);

            UserList.setAdapter(adapter);
        }

    }
}
