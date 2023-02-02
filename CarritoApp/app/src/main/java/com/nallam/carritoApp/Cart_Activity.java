package com.nallam.carritoApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nallam.carritoApp.ui.main.CartFragment;

public class Cart_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart__activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CartFragment.newInstance())
                    .commitNow();
        }
    }
}