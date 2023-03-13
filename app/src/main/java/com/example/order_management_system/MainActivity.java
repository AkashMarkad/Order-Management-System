package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button New , saveAndProceed;
    ImageView moreOption;
    CheckBox GroupProduct;
    RadioGroup RGroup;
    RadioButton selectedRadioButton;
    Spinner CategorySpinner , DesignSpinner , HSNSpinner , MinStockSpinner , MakingRateRSpinner , MakingRateWSpinner;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        New = findViewById(R.id.btnNew);
        saveAndProceed = findViewById(R.id.btnSaveAndProceed);
        moreOption = findViewById(R.id.main_more);
        GroupProduct = findViewById(R.id.checkBoxGroupProduct);
        RGroup = findViewById(R.id.RGroup);
        CategorySpinner = findViewById(R.id.categorySpinner);
        DesignSpinner = findViewById(R.id.designSpinner);
        HSNSpinner = findViewById(R.id.hsnSpinner);
        MinStockSpinner = findViewById(R.id.minStockUnits);
        MakingRateRSpinner = findViewById(R.id.makingRateRUnits);
        MakingRateWSpinner = findViewById(R.id.makingRateWUnits);

        moreOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"More Option clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"New Button Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        saveAndProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickbuttonMethod(view);
                startActivity(new Intent(MainActivity.this,ProductNameAndQRCode.class));
            }
        });

        //Spinner declaration for category
        ArrayAdapter<CharSequence> CategoryAdapter =  ArrayAdapter.createFromResource(this, R.array.Category, android.R.layout.simple_spinner_item);
        CategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CategorySpinner.setAdapter(CategoryAdapter);
        CategorySpinner.setOnItemSelectedListener(this);

        //Spinner declaration for design
        ArrayAdapter<CharSequence> DesignAdapter =  ArrayAdapter.createFromResource(this, R.array.Design, android.R.layout.simple_spinner_item);
        CategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DesignSpinner.setAdapter(DesignAdapter);
        DesignSpinner.setOnItemSelectedListener(this);

        //Spinner declaration for HSN
        ArrayAdapter<CharSequence> HSNAdapter =  ArrayAdapter.createFromResource(this, R.array.HSN, android.R.layout.simple_spinner_item);
        CategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HSNSpinner.setAdapter(HSNAdapter);
        HSNSpinner.setOnItemSelectedListener(this);

        //Spinner declaration for MinStockUnits
        ArrayAdapter<CharSequence> MinStockUnitsAdapter =  ArrayAdapter.createFromResource(this, R.array.minStockUnits, android.R.layout.simple_spinner_item);
        CategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MinStockSpinner.setAdapter(MinStockUnitsAdapter);
        MinStockSpinner.setOnItemSelectedListener(this);

        //Spinner declaration for MakingRateRUnits
        ArrayAdapter<CharSequence> MakingRateRUnitsAdapter =  ArrayAdapter.createFromResource(this, R.array.MakingRateRUnits, android.R.layout.simple_spinner_item);
        CategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MakingRateRSpinner.setAdapter(MakingRateRUnitsAdapter);
        MakingRateRSpinner.setOnItemSelectedListener(this);


        //Spinner declaration for MakingRateRUnits
        ArrayAdapter<CharSequence> MakingRateWUnitsAdapter =  ArrayAdapter.createFromResource(this, R.array.MakingRateWUnits, android.R.layout.simple_spinner_item);
        CategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MakingRateWSpinner.setAdapter(MakingRateWUnitsAdapter);
        MakingRateWSpinner.setOnItemSelectedListener(this);

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

    public void onclickbuttonMethod(View v){
        int selectedId = RGroup.getCheckedRadioButtonId();

        if(selectedId==-1){
            Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }
        else{
            selectedRadioButton = findViewById(selectedId);
            Toast.makeText(MainActivity.this,selectedRadioButton.getText(), Toast.LENGTH_SHORT).show();
        }

    }
}