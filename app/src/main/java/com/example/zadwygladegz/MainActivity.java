package com.example.zadwygladegz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText repeatPasswordEditText;
    private Button confirmButton;
    private TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailEditText = findViewById(R.id.emailtk);
        passwordEditText = findViewById(R.id.passwordinput);
        repeatPasswordEditText = findViewById(R.id.passwordrepinput);
        confirmButton = findViewById(R.id.btnzatwierdz);
        welcomeTextView = findViewById(R.id.powitanie);

        confirmButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString();
            String repeatPassword = repeatPasswordEditText.getText().toString();

            if (!email.contains("@")) {
                welcomeTextView.setText("Nieprawidłowy adres e-mail");
            } else if (!password.equals(repeatPassword)) {
                welcomeTextView.setText("Hasła się różnią");
            } else {
                welcomeTextView.setText("Witaj " + email);
            }
        });
    }
}