package com.example.order_management_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class VendorAdaptor extends RecyclerView.Adapter<VendorViewHolder> {

    List<VendorData> list = Collections.emptyList();
    Context context;
    ClickListiner listiner;

    public VendorAdaptor(List<VendorData> list,
                                Context context,ClickListiner listiner)
    {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }
    @NonNull
    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.vendor_card, parent, false);
        VendorViewHolder viewHolder = new VendorViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VendorViewHolder viewHolder,final int position) {
        final int index = viewHolder.getAdapterPosition();
        viewHolder.ShopName
                .setText(list.get(position).shopName);
        viewHolder.OPValue
                .setText(list.get(position).OPValue);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                listiner.click(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
