package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DisplayProductActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button decreaseButton , increaseButton;
    private EditText quantityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);

        imageView = findViewById(R.id.image);
        decreaseButton = findViewById(R.id.decreaseButton);
        increaseButton = findViewById(R.id.increaseButton);
        quantityEditText = findViewById(R.id.quantityEditText);

        Intent intent = getIntent();

        imageView.setImageResource(intent.getIntExtra("image", 0));

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(quantityEditText.getText().toString());
                if (quantity > 0) {
                    quantity--;
                    quantityEditText.setText(String.valueOf(quantity));
                }
            }
        });

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(quantityEditText.getText().toString());
                quantity++;
                quantityEditText.setText(String.valueOf(quantity));
            }
        });
    }
}