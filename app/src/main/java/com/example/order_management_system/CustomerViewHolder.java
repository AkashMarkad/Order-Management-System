package com.example.order_management_system;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerViewHolder extends RecyclerView.ViewHolder {
    TextView shopName1, OPValue1;
    View view1;

    public CustomerViewHolder(@NonNull View itemView) {
        super(itemView);

        shopName1 = (TextView) itemView.findViewById(R.id.shopName1);
        OPValue1 = (TextView) itemView.findViewById(R.id.OPValue1);
        view1 = itemView;

    }
}
