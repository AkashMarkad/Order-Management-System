package com.example.order_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    private EditText regCompanyIdEditText, regUsernameEditText, regPhoneNoEditText, regEmailEditText, regPasswordEditText, regReEnterPasswordEditText;
    private Button regSignupButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        regCompanyIdEditText = findViewById(R.id.regCompanyIdEditText);
        regUsernameEditText =  findViewById(R.id.regUsernameEditText);
        regPhoneNoEditText =  findViewById(R.id.regPhoneNoEditText);
        regEmailEditText =  findViewById(R.id.regEmailEditText);
        regPasswordEditText = findViewById(R.id.regPasswordEditText);
        regReEnterPasswordEditText =  findViewById(R.id.regReEnterPasswordEditText);
        regSignupButton = findViewById(R.id.regSignupButton);

        regSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }

    private void registerUser() {
        //get input values from registration form
        String companyId = regCompanyIdEditText.getText().toString().trim();
        String username = regUsernameEditText.getText().toString().trim();
        String phoneNo = regPhoneNoEditText.getText().toString().trim();
        String email = regEmailEditText.getText().toString().trim();
        String password = regPasswordEditText.getText().toString().trim();
        String reEnterPassword = regReEnterPasswordEditText.getText().toString().trim();

        //validation of fields
        if (TextUtils.isEmpty(companyId)) {
            regCompanyIdEditText.setError("Please enter company ID");
            return;
        }

        if (TextUtils.isEmpty(username)) {
            regUsernameEditText.setError("Please enter username");
            return;
        }

        if (TextUtils.isEmpty(phoneNo)) {
            regPhoneNoEditText.setError("Please enter phone no");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            regEmailEditText.setError("Please enter email address");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            regPasswordEditText.setError("Please enter password");
            return;
        }

        if (TextUtils.isEmpty(reEnterPassword)) {
            regReEnterPasswordEditText.setError("Please re-enter password");
            return;
        }

        //to check whether phone no is valid or not.
        if (isValidPhoneNumber(phoneNo)) {
            registrationSuccessful();
        } else {
            Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show();
        }

        // Verify if the passwords match
        if (isPasswordMatch(regPasswordEditText, regReEnterPasswordEditText)) {
            // Verify if the password is valid
            if (isValidPassword(password)) {
                registrationSuccessful();
            }
        }
        else {
            Toast.makeText(this, "Invalid Password or Passwords do not match", Toast.LENGTH_SHORT).show();
        }
    }

    private void registrationSuccessful() {
        Intent i =  new Intent(getApplicationContext(), LoginPage.class);
        Toast.makeText(RegistrationPage.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }

    private boolean isValidPhoneNumber(@NonNull String phoneNo) {
        return phoneNo.length() == 10;
    }

    private boolean isPasswordMatch(@NonNull EditText regPasswordEditText, EditText regReEnterPasswordEditText) {
        return regPasswordEditText.equals(regReEnterPasswordEditText);
    }

    private boolean isValidPassword(String password) {
        // Password length should be at least 6 characters
        if (password.length() < 6) {
            return false;
        }

        // Password should contain at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Password should contain at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Password should contain at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Password should contain at least one special character
        if (!password.matches(".*[!@#$%^&*()-_=+\\|\\[{\\]};:'\",<.>/?].*")) {
            return false;
        }

        // All criteria passed, the password is valid
        return true;
    }
}