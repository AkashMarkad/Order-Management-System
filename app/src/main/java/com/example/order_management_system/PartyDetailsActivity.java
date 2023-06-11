package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class PartyDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button Save , Proceed , Exit;
    Spinner partyTypeSpinner;
    EditText ip_party_name, ip_addres, ip_contact_no, ip_email, ip_reference, ip_credit_days, ip_GST, ip_PAN, ip_branch_name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_details);

        ip_party_name = findViewById(R.id.ip_party_name);
        ip_addres = findViewById(R.id.ip_address);
        ip_contact_no = findViewById(R.id.ip_contact_no);
        ip_email = findViewById(R.id.ip_email);
        ip_reference = findViewById(R.id.ip_reference);
        ip_credit_days = findViewById(R.id.ip_credit_days);
        ip_GST = findViewById(R.id.ip_GST);
        ip_PAN = findViewById(R.id.ip_PAN);
        ip_branch_name = findViewById(R.id.ip_branch_name);

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

                String partyName = ip_party_name.getText().toString().trim();
                String address = ip_addres.getText().toString().trim();
                String contactNo = ip_contact_no.getText().toString().trim();
                String email = ip_email.getText().toString().trim();
                String reference = ip_reference.getText().toString().trim();
                String creditDays = ip_credit_days.getText().toString().trim();
                String GST = ip_GST.getText().toString().trim();
                String PAN = ip_PAN.getText().toString().trim();
                String branchName = ip_branch_name.getText().toString().trim();

                if (TextUtils.isEmpty(partyName)) {
                    ip_party_name.setError("Please enter party name");
                    return;
                }
                else if (TextUtils.isEmpty(address)) {
                    ip_addres.setError("Please enter address");
                    return;
                }
                else if (TextUtils.isEmpty(contactNo)) {
                    ip_contact_no.setError("Please enter contact no.");
                    return;
                }
                else if (TextUtils.isEmpty(email)) {
                    ip_email.setError("Please enter email");
                    return;
                }
                else if (!validateEmail(email)) {
                    ip_email.setError("Please enter correct email");
                    return;
                }
                else if (TextUtils.isEmpty(reference)) {
                    ip_reference.setError("Please enter reference");
                    return;
                }
                else if (TextUtils.isEmpty(creditDays)) {
                    ip_credit_days.setError("Please enter credit days");
                    return;
                }
                else if (TextUtils.isEmpty(GST)) {
                    ip_GST.setError("Please enter GST value");
                    return;
                }
                else if (TextUtils.isEmpty(PAN)) {
                    ip_PAN.setError("Please enter PAN no.");
                    return;
                }
                else if (TextUtils.isEmpty(branchName)) {
                    ip_branch_name.setError("Please enter branch name");
                    return;
                }
                else {
                    startActivity(new Intent(PartyDetailsActivity.this, PartyOrderDetailsActivity.class));
                }
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

    public static boolean validateEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        return pattern.matcher(email).matches();
    }
}