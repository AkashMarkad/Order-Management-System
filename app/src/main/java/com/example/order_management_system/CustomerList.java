package com.example.order_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class CustomerList extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView customerRecyclerView;
    ClickListiner clickListiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        List<CustomerData> list1 = new ArrayList<>();
        list1 = getData();

        customerRecyclerView =  findViewById(R.id.customerRecyclerView);
        clickListiner = new ClickListiner() {
            @Override
            public void click(int index) {
                Toast.makeText(CustomerList.this,"clicked item index is "+index,Toast.LENGTH_LONG).show();
            }

        };
        CustomerAdaptor customerAdaptor = new CustomerAdaptor(list1, getApplication(), clickListiner);
        customerRecyclerView.setAdapter(customerAdaptor);
        customerRecyclerView.setLayoutManager(new LinearLayoutManager(CustomerList.this));
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    private List<CustomerData> getData() {
        List<CustomerData> list = new ArrayList<>();
        list.add(new CustomerData("Shop 1", "4 OP"));
        list.add(new CustomerData("Shop 2", "2 OP"));
        list.add(new CustomerData("Shop 3", "1 OP"));
        list.add(new CustomerData("Shop 4", "3 OP"));
        return  list;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}