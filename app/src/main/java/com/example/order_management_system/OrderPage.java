package com.example.order_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OrderPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

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