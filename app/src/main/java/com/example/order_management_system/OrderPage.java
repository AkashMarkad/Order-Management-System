package com.example.order_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class OrderPage extends AppCompatActivity {

    private TextView textViewSelectedDate;
    private ImageView buttonSelectDate;
    private DatePickerDialog datePickerDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        textViewSelectedDate = findViewById(R.id.order_date_value);
        buttonSelectDate = findViewById(R.id.select_Order_Date);


        // Set an onClickListener to open the DatePickerDialog when the button is clicked
        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
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

    private void showDatePickerDialog() {
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog and set the selected date listener
        datePickerDialog = new DatePickerDialog(OrderPage.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Update the selected date TextView with the chosen date
                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                textViewSelectedDate.setText(selectedDate);
            }
        }, year, month, dayOfMonth);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }
}