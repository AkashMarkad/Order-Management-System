package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PartyDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button Save , Proceed , Exit;
    Spinner partyTypeSpinner;

    @SuppressLint("MissingInflatedId")
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

        //Spinner declaration for party type
        partyTypeSpinner =  findViewById(R.id.partyTypeSpinner);
        ArrayAdapter<CharSequence> partyTypeAdapter =  ArrayAdapter.createFromResource(this, R.array.partyType, android.R.layout.simple_spinner_item);
        partyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        partyTypeSpinner.setAdapter(partyTypeAdapter);
        partyTypeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) adapterView.getChildAt(0)).setTextSize(20);
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}