package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PartyOrderDetailsActivity extends AppCompatActivity {

    Button save , exit;
    EditText cr_amount_value, dr_amount_value, cr_gold_value, dr_gold_value, cr_silver_value, dr_silver_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_order_details);

        cr_amount_value = findViewById(R.id.cr_amount_value);
        dr_amount_value = findViewById(R.id.dr_amount_value);
        cr_gold_value = findViewById(R.id.cr_gold_value);
        dr_gold_value = findViewById(R.id.dr_gold_value);
        cr_silver_value = findViewById(R.id.cr_silver_value);
        dr_silver_value = findViewById(R.id.dr_silver_value);

        save = findViewById(R.id.save);
        exit = findViewById(R.id.exit);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String crAmt = cr_amount_value.getText().toString().trim();
                String drAmt = dr_amount_value.getText().toString().trim();
                String crGold = cr_gold_value.getText().toString().trim();
                String drGold = dr_gold_value.getText().toString().trim();
                String crSilver = cr_silver_value.getText().toString().trim();
                String drSilver = dr_silver_value.getText().toString().trim();

                if (TextUtils.isEmpty(crAmt)) {
                    cr_amount_value.setError("Please enter cr amount value");
                    return;
                }
                else if(TextUtils.isEmpty(drAmt)){
                    dr_amount_value.setError("Please enter dr amount value");
                    return;
                }
                else if(TextUtils.isEmpty(crGold)){
                    cr_gold_value.setError("Please enter cr gold value");
                    return;
                }
                else if(TextUtils.isEmpty(drGold)){
                    dr_gold_value.setError("Please enter dr gold value");
                    return;
                }
                else if(TextUtils.isEmpty(crSilver)){
                    cr_silver_value.setError("Please enter cr silver value");
                    return;
                }
                else if(TextUtils.isEmpty(drSilver)){
                    dr_silver_value.setError("Please enter dr silver value");
                    return;
                }
                else{
                    startActivity(new Intent(PartyOrderDetailsActivity.this,Vendor_List.class));
                }



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