package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShippingProductActivity extends AppCompatActivity {

    EditText shippingAddress, landMark , pinCode;
    Button placeOrder , cancel, home;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_product);

        shippingAddress = findViewById(R.id.editTextAddress);
        landMark = findViewById(R.id.editTextLandmark);
        pinCode = findViewById(R.id.editTextPincode);

        placeOrder = findViewById(R.id.buttonPlaceOrder);
        cancel = findViewById(R.id.buttonCancel);
        home = findViewById(R.id.buttonHome);

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "PlaceOrder Button Clicked", Toast.LENGTH_SHORT).show();

                String Address = shippingAddress.getText().toString().trim();
                String landmark = landMark.getText().toString().trim();
                String pin = pinCode.getText().toString().trim();

                if (TextUtils.isEmpty(Address)) {
                    shippingAddress.setError("Please enter Address");
                    return;
                }

                if(TextUtils.isEmpty(landmark)){
                    landMark.setError("Please enter your landmark");
                    return;
                }

                if(TextUtils.isEmpty(pin)){
                    pinCode.setError("Please enter your pinCode");
                    return;
                }

                if(!isValidPinCode(pin)){
                    pinCode.setError("Please enter valid pinCode");
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Cancel Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }

    public boolean isValidPinCode(String pin){
        return pin.length()==6;
    }
}