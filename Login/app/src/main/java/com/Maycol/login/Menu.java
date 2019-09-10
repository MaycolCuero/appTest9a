package com.Maycol.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView txt_info = findViewById(R.id.Id_text);
        registerForContextMenu(txt_info);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.colors2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Cash", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Subitem5:
                Toast.makeText(this, "Brown", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Subitem6:
                Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    // muestra el menu cuando se preciona
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("My Colors");
        getMenuInflater().inflate(R.menu.colors, menu);
    }

    // hace la opcion del menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.color_1:
                Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.color_2:
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.color_3:
                Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}
