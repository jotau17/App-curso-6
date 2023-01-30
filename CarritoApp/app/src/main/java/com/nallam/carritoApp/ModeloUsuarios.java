package com.nallam.carritoApp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nallam.carritoApp.Clases.SqLiteHelper;
import com.nallam.carritoApp.Clases.UsuariosDTO;

import java.sql.ResultSet;
import java.sql.Statement;

public class ModeloUsuarios {
    public SQLiteDatabase getConnection(Context context){
        SqLiteHelper conn = new SqLiteHelper(context, "mydatabase", null, 1);
        //Para darle permisos de escritura sobre el archivo de BBDD
        SQLiteDatabase db = conn.getWritableDatabase();
        return db;
    }
    int insertaUsuario(Context context, UsuariosDTO usuario){
        int res = 0;
        String sentenciaSql = "INSERT INTO usuarios (id, nombre, email, password) VALUES ('"+usuario.getId()+"','"+usuario.getNombre()+"', '"+usuario.getEmail()+"','"+usuario.getPassword()+"')";
        SQLiteDatabase db = this.getConnection(context);
        try {
            db.execSQL(sentenciaSql);
            res = 1;
        }catch (Exception e){

        }
        return res;
    }

    int consultaUsuario(Context context, UsuariosDTO usuario){
        int res = 0;
        String sentenciaSql = "SELECT * FROM usuarios WHERE email = '"+ usuario.getEmail()+"' AND password ='"+usuario.getPassword()+"'";

        SQLiteDatabase db = this.getConnection(context);
        try {
            Cursor response = db.rawQuery(sentenciaSql, null);
            if (response.moveToNext()){
                res = 1;
            }
        }catch (Exception e){

        }
        return res;
    }

}
