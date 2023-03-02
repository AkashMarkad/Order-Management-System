package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {

    Button Edit;
    TextView txtEdit , printQR;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Edit = findViewById(R.id.buttonEdit);
        txtEdit = findViewById(R.id.txtViewEdit);
        printQR = findViewById(R.id.printQr);

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this,PartyDetailsActivity.class));
            }
        });
    }
}