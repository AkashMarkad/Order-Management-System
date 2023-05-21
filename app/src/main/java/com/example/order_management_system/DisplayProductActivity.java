package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayProductActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button decreaseButton , increaseButton, btnAddToCart;
    private TextView tvQuantity;
    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);

        imageView = findViewById(R.id.image);
        decreaseButton = findViewById(R.id.decreaseButton);
        increaseButton = findViewById(R.id.increaseButton);
        tvQuantity = findViewById(R.id.tvQuantity);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        Intent intent = getIntent();

        imageView.setImageResource(intent.getIntExtra("image", 0));

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseQuantity();
            }
        });

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseQuantity();
            }
        });
    }

    private void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
            updateQuantity();
        }
    }

    private void increaseQuantity() {
        quantity++;
        updateQuantity();
    }

    private void updateQuantity() {
        tvQuantity.setText(String.valueOf(quantity));
    }
}