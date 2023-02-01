package com.nallam.carritoApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nallam.carritoApp.Clases.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> listaProductos;
    ArrayList<Product> listaOriginal;

    public ProductAdapter(ArrayList<Product> list) {
        this.listaProductos = list;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(list);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, null, false);
        
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.viewNombre.setText(listaProductos.get(position).getTitle());
        holder.viewPrice.setText(listaProductos.get(position).getPrice());
       // holder.viewImage.setImageURI(listaProductos.get(position).getImage());
    }

    public void filtrado(final String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaProductos.clear();
            listaProductos.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Product> collecion = listaProductos.stream()
                        .filter(i -> i.getTitle().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaProductos.clear();
                listaProductos.addAll(collecion);
            } else {
                for (Product c : listaOriginal) {
                    if (c.getTitle().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaProductos.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    public void setProducts(ArrayList<Product> list){
        listaProductos = list;
    }
    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewPrice;
                //ImageView viewImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.product_name);
            viewPrice = itemView.findViewById(R.id.product_price);
/*            viewImage = itemView.findViewById(R.id.product_image);*/

        }
    }
}
