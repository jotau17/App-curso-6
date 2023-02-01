package com.nallam.carritoApp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nallam.carritoApp.Clases.Product;
import com.nallam.carritoApp.Clases.SqLiteHelper;
import com.nallam.carritoApp.Clases.UsuariosDTO;

import java.util.ArrayList;

public class ModeloUsuarios {
    public SQLiteDatabase getConnection(Context context) {
        SqLiteHelper conn = new SqLiteHelper(context, "mydatabase.db", null, 1);
        //Para darle permisos de escritura sobre el archivo de BBDD
        SQLiteDatabase db = conn.getWritableDatabase();
        return db;
    }

    int insertaUsuario(Context context, UsuariosDTO usuario) {
        int res = 0;
        String sentenciaSql = "INSERT INTO usuarios (id, nombre, email, password) VALUES ('" + usuario.getId() + "','" + usuario.getNombre() + "', '" + usuario.getEmail() + "','" + usuario.getPassword() + "')";
        SQLiteDatabase db = this.getConnection(context);
        try {
            db.execSQL(sentenciaSql);
            res = 1;
        } catch (Exception e) {

        }
        return res;
    }

    int consultaUsuario(Context context, UsuariosDTO usuario) {
        int res = 0;
        String sentenciaSql = "SELECT * FROM usuarios WHERE email = '" + usuario.getEmail() + "' AND password ='" + usuario.getPassword() + "'";

        SQLiteDatabase db = this.getConnection(context);
        try {
            Cursor response = db.rawQuery(sentenciaSql, null);
            if (response.moveToNext()) {
                res = 1;
            }
        } catch (Exception e) {

        }
        return res;
    }

    public ArrayList<Product> obtenerProductos(Context context) {
        int res = 0;
        String sentenciaSql = "SELECT * FROM productos";

        SQLiteDatabase db = this.getConnection(context);
        ArrayList<Product> myProducts = new ArrayList<Product>();
        try {
            Cursor response = db.rawQuery(sentenciaSql, null);

            Product product = null;
            if (response.moveToFirst()) {
                do {
                    product = new Product(response.getString(1), response.getString(2), response.getInt(1), response.getInt(0));

                    myProducts.add(product);
                } while (response.moveToNext());
            }

            response.close();

            return myProducts;
        } catch (Exception e) {

        }
        return myProducts;
    }

}
