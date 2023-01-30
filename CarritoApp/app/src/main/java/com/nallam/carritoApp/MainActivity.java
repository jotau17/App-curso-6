package com.nallam.carritoApp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.nallam.carritoApp.Clases.DatabaseHelper;
import com.nallam.carritoApp.Clases.UsuariosDTO;
import com.nallam.carritoApp.vistas.ComprasFragment;
import com.nallam.carritoApp.vistas.FavsFragment;
import com.nallam.carritoApp.vistas.HomeFragment;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity /*implements NavigationView.OnNavigationItemSelectedListener */{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

}
