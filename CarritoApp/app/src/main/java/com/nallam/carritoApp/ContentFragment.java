package com.nallam.carritoApp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nallam.carritoApp.Clases.Product;
import com.nallam.carritoApp.databinding.MenuContentBinding;

import java.util.ArrayList;

public class ContentFragment extends Fragment {

    private MenuContentBinding binding;
    RecyclerView vistaProducto;
    ArrayList<Product> myProducts;
    ProductAdapter adapter;
    Button addToCartBtn;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = MenuContentBinding.inflate(inflater, container, false);
        vistaProducto = binding.getRoot().findViewById(R.id.listaProductos);

        vistaProducto.setLayoutManager(new LinearLayoutManager(getContext()));

/*        Button addToCartBtn = view.findViewById(R.id.add_to_cart);*/
        Context ctx = getContext();
        ModeloUsuarios usuarios = new ModeloUsuarios();
        myProducts = new ArrayList<Product>();

        adapter = new ProductAdapter(usuarios.obtenerProductos(ctx));
        vistaProducto.setAdapter(adapter);
        return binding.getRoot();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}