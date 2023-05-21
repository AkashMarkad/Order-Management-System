package com.example.order_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class OrderPage extends AppCompatActivity {

    private Button btnProceedToGallery;
    private TextView order_number, order_date;
    private EditText order_number_value, order_date_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        order_number = findViewById(R.id.order_number);
        order_date = findViewById(R.id.order_date);
        order_number_value =  findViewById(R.id.order_number_value);
        order_date_value = findViewById(R.id.order_date_value);
        btnProceedToGallery = findViewById(R.id.btnProceedToGallery);


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String currentDate = day + "/" + month + "/" + year;
        order_date_value.setText(currentDate);

        btnProceedToGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(), GallaryActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order_page_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.addProduct){
            Toast.makeText(getApplicationContext(),"clicked on add product", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.order) {
            Toast.makeText(getApplicationContext(),"clicked on order", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.gallery) {
            Toast.makeText(getApplicationContext(),"clicked on gallery", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), GallaryActivity.class));
        }

        return true;
    }
}