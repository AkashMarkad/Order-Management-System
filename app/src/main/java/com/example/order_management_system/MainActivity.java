package com.example.order_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
    RadioButton radioBtnGold , radioBtnSilver;
    EditText purityValue , purchaseWastageValue , minStockValue , wastageRValue , wastageWValue , MakingRateRValue , MakingRateWValue;
    Spinner CategorySpinner , DesignSpinner , HSNSpinner , MinStockSpinner , MakingRateRSpinner , MakingRateWSpinner;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        New = findViewById(R.id.btnNew);
        saveAndProceed = findViewById(R.id.btnSaveAndProceed);
        GroupProduct = findViewById(R.id.checkBoxGroupProduct);
        RGroup = findViewById(R.id.RGroup);
        radioBtnGold = findViewById(R.id.radioBtnGold);
        radioBtnSilver = findViewById(R.id.radioBtnSilver);
        CategorySpinner = findViewById(R.id.categorySpinner);
        DesignSpinner = findViewById(R.id.designSpinner);
        HSNSpinner = findViewById(R.id.hsnSpinner);
        MinStockSpinner = findViewById(R.id.minStockUnits);
        MakingRateRSpinner = findViewById(R.id.makingRateRUnits);
        MakingRateWSpinner = findViewById(R.id.makingRateWUnits);
        purityValue = findViewById(R.id.purityValue);
        purchaseWastageValue = findViewById(R.id.purchaseWastageValue);
        minStockValue = findViewById(R.id.minStockValue);
        wastageRValue = findViewById(R.id.wastageRValue);
        wastageWValue = findViewById(R.id.wastageWValue);
        MakingRateRValue = findViewById(R.id.makingRateRValue);
        MakingRateWValue = findViewById(R.id.makingRateWValue);


        New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(),"New Button Clicked" , Toast.LENGTH_SHORT).show();
            }
        });



        saveAndProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String purityVal = purityValue.getText().toString().trim();
                String purchaseWastageVal = purchaseWastageValue.getText().toString().trim();
                String minStockVal = minStockValue.getText().toString().trim();
                String wastageRVal = wastageRValue.getText().toString().trim();
                String wastageWVal = wastageWValue.getText().toString().trim();
                String makingRateRVal = MakingRateRValue.getText().toString().trim();
                String makingRateWVal = MakingRateWValue.getText().toString().trim();

//                purity Value
                if(TextUtils.isEmpty(purityVal)){
                    purityValue.setError("Please enter purity value");
                }
                else if(!isValidNumber(purityVal)){
                    purityValue.setError("Please enter valid number");
                }
                else if(!isValidPer(purityVal)){
                    purityValue.setError("Please enter valid percentage");
                }

//                Purchase Wastage Value
                else if(TextUtils.isEmpty(purchaseWastageVal)){
                    purchaseWastageValue.setError("Please enter purchase wastage value");
                }
                else if(!isValidNumber(purchaseWastageVal)){
                    purchaseWastageValue.setError("Please enter valid number");
                }
                else if(!isValidPer(purchaseWastageVal)){
                    purityValue.setError("Please enter valid percentage");
                }

//                Min Stock Value
                else if(TextUtils.isEmpty(minStockVal)){
                    minStockValue.setError("Please enter Min Stock value");
                }
                else if(!isValidNumber(minStockVal)){
                    minStockValue.setError("Please enter valid number");
                }

//                Wastage R Value
                else if(TextUtils.isEmpty(wastageRVal)){
                    wastageRValue.setError("Please enter Wastage R value");
                }
                else if(!isValidNumber(wastageRVal)){
                    wastageRValue.setError("Please enter valid number");
                }
                else if(!isValidPer(wastageRVal)){
                    wastageRValue.setError("Please enter valid percentage");
                }

//                Wastage W Value
                else if(TextUtils.isEmpty(wastageWVal)){
                    wastageWValue.setError("Please enter Wastage W value");
                }
                else if(!isValidNumber(wastageWVal)){
                    wastageWValue.setError("Please enter valid number");
                }
                else if(!isValidPer(wastageWVal)){
                    wastageWValue.setError("Please enter valid percentage");
                }

//                Making Rate R Value
                else if(TextUtils.isEmpty(makingRateRVal)){
                    MakingRateRValue.setError("Please enter Making Rate R value");
                }
                else if(!isValidNumber(makingRateRVal)){
                    MakingRateRValue.setError("Please enter valid number");
                }

//                Making Rate W Value
                else if(TextUtils.isEmpty(makingRateWVal)){
                    MakingRateWValue.setError("Please enter Making W value");
                }
                else if(!isValidNumber(makingRateWVal)){
                    MakingRateWValue.setError("Please enter valid number");
                }
                else{
                    //Go to the next page
                    startActivity(new Intent(MainActivity.this,ProductNameAndQRCode.class));
                }

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
        ((TextView) adapterView.getChildAt(0)).setTextSize(18);
        String text = adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Menu declaration
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.item1){
            Toast.makeText(getApplicationContext(),"clicked on item 1", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.item2) {
            Toast.makeText(getApplicationContext(),"clicked on item 2", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.item3) {
            Toast.makeText(getApplicationContext(),"clicked on item 3", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    public boolean isValidNumber(String str){
        try {
            Float.parseFloat(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isValidPer(String str){
        float num = Float.parseFloat(str);
        return num >= 0.0 && num <= 100;
    }

}