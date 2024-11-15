package com.example.hw41;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.login_layout);
        EditText editTextLogin = findViewById(R.id.editTextLogin);
        EditText editTextPassword = findViewById(R.id.editPassword);
        Button loginButton = findViewById(R.id.loginButton);
        TextView welcomeText = findViewById(R.id.tv_welcome);
        TextView tvRegister = findViewById(R.id.tv_register);
        TextView tvLogin = findViewById(R.id.tv_log_in);


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();
                if (!login.isEmpty() && !password.isEmpty()) {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.grey));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        };
        editTextLogin.addTextChangedListener(textWatcher);
        editTextPassword.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(v -> {
            String login = editTextLogin.getText().toString();
            String password = editTextPassword.getText().toString();
            if (login.equals("admin") && password.equals("admin")) {
                Snackbar.make(v, "Вы успешно зарегистрировались!", Snackbar.LENGTH_LONG).show();
                welcomeText.setVisibility(View.VISIBLE);
                editTextLogin.setVisibility(View.GONE);
                editTextPassword.setVisibility(View.GONE);
                loginButton.setVisibility(View.GONE);
                tvRegister.setVisibility(View.GONE);
                linearLayout.setVisibility(View.GONE);
                tvLogin.setVisibility(View.GONE);


            } else {
                Snackbar.make(v, "Неправильный логин и пароль", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}