package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PartyDetailsActivity extends AppCompatActivity {

    Button Save , Proceed , Exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_details);

        Save = findViewById(R.id.btnSave);
        Proceed = findViewById(R.id.btnProceed);
        Exit = findViewById(R.id.btnExit);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PartyDetailsActivity.this,"Save Button Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PartyDetailsActivity.this , PartyOrderDetailsActivity.class));
            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PartyDetailsActivity.this,"Exit Button Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

    }


}