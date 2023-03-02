package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PartyOrderDetailsActivity extends AppCompatActivity {

    Button save , exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_order_details);

        save = findViewById(R.id.save);
        exit = findViewById(R.id.exit);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PartyOrderDetailsActivity.this , "Save button clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PartyOrderDetailsActivity.this , "Exit button clicked" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}