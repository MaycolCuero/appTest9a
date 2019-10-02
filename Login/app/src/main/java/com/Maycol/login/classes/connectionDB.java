package com.Maycol.login.classes;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class connectionDB extends  SQLiteOpenHelper{
    public connectionDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) {
        //Create Tables
        market.execSQL("create table users(id integer primary key autoincrement," +
                "firstname text not null," +
                "lastname text," +
                "email text," +
                "password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
