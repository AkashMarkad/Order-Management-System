package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProductNameAndQRCode extends AppCompatActivity {

    Button New , Savebtn , PrintQR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_name_and_qrcode);
        New = findViewById(R.id.btnNewProduct);
        Savebtn = findViewById(R.id.btnSaveProduct);
        PrintQR = findViewById(R.id.btnPrintQR);

        New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductNameAndQRCode.this,"New Button Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        Savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductNameAndQRCode.this,ProductDetailsActivity.class));
            }
        });

        PrintQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductNameAndQRCode.this,"PrintQR Button Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

    }
}