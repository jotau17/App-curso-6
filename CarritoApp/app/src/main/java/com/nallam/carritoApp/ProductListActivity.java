/*
package com.nallam.carritoApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nallam.carritoApp.Clases.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView productListView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        ModeloUsuarios usr = new ModeloUsuarios();
        productListView = findViewById(R.id.listaProductos);
        productListView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(loadProducts());
        productListView.setAdapter(productAdapter);
    }

    private ArrayList<Product> loadProducts() {
        // Aquí puedes cargar los datos de los productos desde una base de datos o una API REST.
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Product 1", 10.00, 1));
        products.add(new Product("Product 2", 20.00, 2));
        products.add(new Product("Product 3", 30.00, 3));
        productAdapter.setProducts(products);
        return products;
    }
}
*/
