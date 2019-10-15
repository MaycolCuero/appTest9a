package com.example.conexionbd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.conexionbd.clases.connectionBD;

import java.util.ArrayList;

public class list_users extends AppCompatActivity {

    // call DataBase class connection

    connectionBD market;
    // Create ListView variable
    ListView userList;
    // Create an ArrayList variable
    ArrayList<String> listItem;
    // Create Array adapter variable

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        //Instant DB Connection
        market = new connectionBD(this, "market", null, 1);

        // Create empty array

        listItem = new ArrayList<>();
        // Call ListView id
        userList = findViewById(R.id.idUserList);

        // Call viewDatra method

        viewData();
    }

    private void viewData() {
        Cursor cursor = market.SelectUserData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "there aren`t users", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1)); // obtenemos el nombre
                listItem.add(cursor.getString(2)); // obtenemos el apellido
            }

            adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listItem);

            userList.setAdapter(adapter);
        }
    }
}
