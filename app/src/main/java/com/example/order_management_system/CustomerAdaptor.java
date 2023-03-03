package com.example.order_management_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class CustomerAdaptor extends RecyclerView.Adapter<CustomerViewHolder> {

    List<CustomerData> list1 = Collections.emptyList();
    Context context1;
    ClickListiner clickListiner;

    public CustomerAdaptor(List<CustomerData> list1, Context context1, ClickListiner clickListiner){
        this.list1 = list1;
        this.context1 = context1;
        this.clickListiner = clickListiner;
    }
    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context1);
        View photoView = inflater.inflate(R.layout.customer_card, parent,false);
        CustomerViewHolder viewHolder = new CustomerViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerViewHolder holder, final int position) {
        final int index = holder.getAdapterPosition();
        holder.shopName1.setText(list1.get(position).shopName1);
        holder.OPValue1.setText(list1.get(position).OPValue1);
        holder.view1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clickListiner.click(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
