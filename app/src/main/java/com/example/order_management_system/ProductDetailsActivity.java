package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductDetailsActivity extends AppCompatActivity {

    Button Edit1, Edit2;
    TextView PrintQR;
    GridView gridView1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        gridView1 = findViewById(R.id.gridView1);

        Edit1 = findViewById(R.id.buttonEdit);
        Edit2 = findViewById(R.id.edit);
        PrintQR = findViewById(R.id.printQR);

        Edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this,MainActivity.class));
            }
        });

        Edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this, ProductNameAndQRCode.class));
            }
        });
        PrintQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this, PartyDetailsActivity.class));
            }
        });





        ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> hashMap1 = new HashMap<String, String>();
        hashMap1.put("detail", "QR-Code");
        hashMap1.put("value", "value");
        arrayList.add(hashMap1);

        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        hashMap2.put("detail", "G. Wt");
        hashMap2.put("value", "value");
        arrayList.add(hashMap2);

        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        hashMap3.put("detail", "Less Wt");
        hashMap3.put("value", "value");
        arrayList.add(hashMap3);

        HashMap<String, String> hashMap4 = new HashMap<String, String>();
        hashMap4.put("detail", "Net Wt");
        hashMap4.put("value", "value");
        arrayList.add(hashMap4);

        HashMap<String, String> hashMap5 = new HashMap<String, String>();
        hashMap5.put("detail", "Size");
        hashMap5.put("value", "value");
        arrayList.add(hashMap5);

        HashMap<String, String> hashMap6 = new HashMap<String, String>();
        hashMap6.put("detail", "HUID");
        hashMap6.put("value", "value");
        arrayList.add(hashMap6);

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.product_detail_grid_item, new String[]
                {"detail", "value"}, new int[]{R.id.product_detail_title, R.id.product_detail_value});

        GridView gridView = findViewById(R.id.gridView1);
        gridView.setAdapter(adapter);

    }
}