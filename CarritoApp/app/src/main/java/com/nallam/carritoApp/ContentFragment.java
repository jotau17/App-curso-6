package com.nallam.carritoApp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = MenuContentBinding.inflate(inflater, container, false);
        vistaProducto = binding.getRoot().findViewById(R.id.listaProductos);

        vistaProducto.setLayoutManager(new LinearLayoutManager(getContext()));
        View view = inflater.inflate(R.layout.item_product, container, false);

/*        Button addToCartBtn = view.findViewById(R.id.add_to_cart);*/
        Context ctx = getContext();
        ModeloUsuarios usuarios = new ModeloUsuarios();
        myProducts = new ArrayList<Product>();

        adapter = new ProductAdapter(usuarios.obtenerProductos(ctx));
        vistaProducto.setAdapter(adapter);
        /*addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se ha añadido al carrito", Toast.LENGTH_LONG).show();
                Context ctx = getContext();
            }
        });*/

        return binding.getRoot();

    }

    @SuppressLint("ResourceType")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}