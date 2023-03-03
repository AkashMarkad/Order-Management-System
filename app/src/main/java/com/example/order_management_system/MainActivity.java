package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button New , saveAndProceed;
    ImageView moreOption;
    CheckBox GroupProduct;
    RadioGroup RGroup;
    RadioButton selectedRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        New = findViewById(R.id.btnNew);
        saveAndProceed = findViewById(R.id.btnSaveAndProceed);
        moreOption = findViewById(R.id.main_more);
        GroupProduct = findViewById(R.id.checkBoxGroupProduct);
        RGroup = findViewById(R.id.RGroup);

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
                startActivity(new Intent(MainActivity.this,ProductNameAndQRCode.class));
            }
        });

    }
}