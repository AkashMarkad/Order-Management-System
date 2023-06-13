package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    private EditText companyIdEditText, usernameEditText, passwordEditText;
    private Button loginButton;
    private TextView forgotPasswordTextView, signupTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        companyIdEditText = findViewById(R.id.companyIdEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        signupTextView =  findViewById(R.id.signupTextView);

        loginButton.setOnClickListener(this);
        forgotPasswordTextView.setOnClickListener(this);
        signupTextView.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        if (v == loginButton) {
            validateLogin();
        } else if (v == forgotPasswordTextView) {
            forgotPassword();
        } else if (v == signupTextView) {
            signUp();
        }
    }

    private void signUp() {
        Intent intent = new Intent(getApplicationContext(),RegistrationPage.class);
        startActivity(intent);
    }

    private void validateLogin() {
        String companyId = companyIdEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(companyId)) {
            companyIdEditText.setError("Please enter company ID");
            return;
        }

        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError("Please enter username");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Please enter password");
            return;
        }

        if (isValidPassword(password)) {
            // login successful
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginPage.this , MainActivity.class));
        } else {
            // display error message
            Toast.makeText(this , "Login failed", Toast.LENGTH_SHORT).show();

            Toast.makeText(this , "Password should contains atleast 1 uppercase letter, 1 lowercase letter, 1 digit, 1 special character and length should be greater than or equal to 6.", Toast.LENGTH_SHORT).show();

        }
    }

    private void forgotPassword() {

        Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
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