package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSelectedProducts;
    private SelectedProductAdapter selectedProductAdapter;
    Button btnRemoveOrAddItems, btnConfirmAndProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

//        btnRemoveOrAddItems = findViewById(R.id.btnRemoveOrAddItems);
        btnConfirmAndProceed = findViewById(R.id.btnConfirmAndProceed);

        recyclerViewSelectedProducts = findViewById(R.id.recyclerViewSelectedProducts);
        recyclerViewSelectedProducts.setLayoutManager(new GridLayoutManager(this, 2));

        List<Product> selectedProducts = getIntent().getParcelableArrayListExtra("selectedProducts");

        selectedProductAdapter = new SelectedProductAdapter(selectedProducts);
        recyclerViewSelectedProducts.setAdapter(selectedProductAdapter);

        // Add item decoration to show a divider between selected products
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        if (dividerDrawable != null) {
            ((DividerItemDecoration) dividerItemDecoration).setDrawable(dividerDrawable);
            recyclerViewSelectedProducts.addItemDecoration(dividerItemDecoration);
        }

//        btnRemoveOrAddItems.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext() , "Select or Disselect item by clicking on it" , Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(), ProductGalleryActivity.class));
//            }
//        });

        btnConfirmAndProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ShippingProductActivity.class));
            }
        });

    }
}