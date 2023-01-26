package com.nallam.carritoApp;

import android.content.ContentValues;
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
import com.nallam.carritoApp.vistas.ComprasFragment;
import com.nallam.carritoApp.vistas.FavsFragment;
import com.nallam.carritoApp.vistas.HomeFragment;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity /*implements NavigationView.OnNavigationItemSelectedListener */{
    /*private DrawerLayout drawer_layout;
    private Toolbar toolbar;
    private NavigationView nav_view;
    private ActionBarDrawerToggle drawerToggle;*/
    EditText EditTextEmail;
    Button btn1;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        /*DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "John Smith");
        values.put("age", 30);
        db.insert("mytable", null, values);
        String[] selectionArgs = {"John Smith"};
        Cursor cursor = db.query("mytable", null, "name" + " = ?", selectionArgs, null, null, null);
        db.close();*/

        //Validacion de direccion de email corecta
        btn1 = (Button) findViewById(R.id.login_btn);


        EditTextEmail = (EditText) findViewById(R.id.userEmail);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String compruebaemail = EditTextEmail.getEditableText().toString();

                final String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";

                if (!compruebaemail.matches(regex))
                {
                    Toast.makeText(MainActivity.this, "El email introducido no es válido", Toast.LENGTH_LONG).show();
                }
            }
        });

        /*toolbar = findViewById(R.id.toolbar);
        drawer_layout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(this);
        ((TextView) findViewById(R.id.toolbarIndicator)).setText("20");*/
    }

    /*@Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }*/

    /*@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_first_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, new ComprasFragment()).commit();
                setTitle("Import");
                break;
            case R.id.nav_second_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, new FavsFragment()).commit();
                setTitle("Gallery");
                break;
            case R.id.nav_third_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, new HomeFragment()).commit();
                setTitle("Carrito");
                break;
        }

        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
