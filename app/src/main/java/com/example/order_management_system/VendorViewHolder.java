package com.example.order_management_system;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VendorViewHolder extends RecyclerView.ViewHolder {
    TextView ShopName , OPValue;
    View view;
    public VendorViewHolder(@NonNull View itemView) {
        super(itemView);

        ShopName = itemView.findViewById(R.id.shopName);
        OPValue = itemView.findViewById(R.id.OPValue);
        view = itemView;
    }
}
