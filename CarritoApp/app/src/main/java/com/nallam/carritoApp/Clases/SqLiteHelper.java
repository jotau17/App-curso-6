package com.nallam.carritoApp.Clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqLiteHelper extends SQLiteOpenHelper {

    final String USERS_TABLE = "CREATE TABLE usuarios (id INTEGER, nombre TEXT, email TEXT, password TEXT)";
    final String PRODUCTOS_TABLE = "CREATE TABLE productos (id INTEGER, nombre TEXT, precio INTEGER)";
    final String CARRITO_TABLE = "CREATE TABLE carrito (id INTEGER, productoId INTEGER, usuarioId INTEGER, cantidad INTEGER)";
    public SqLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase dB) {
        dB.execSQL(USERS_TABLE);
        dB.execSQL(PRODUCTOS_TABLE);
        dB.execSQL(CARRITO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
