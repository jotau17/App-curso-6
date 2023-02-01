package com.nallam.carritoApp.Clases;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nallam.carritoApp.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private TextView priceTextView;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.product_name);
        priceTextView = itemView.findViewById(R.id.product_price);
    }

    public void bind(Product product) {
        nameTextView.setText(product.getTitle());
        priceTextView.setText(product.getPrice());
    }
}
