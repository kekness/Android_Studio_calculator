package com.example.calculator_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BmiCalculatorActivity extends AppCompatActivity {

    EditText heightInput, weightInput;
    Button calculateButton, backButton;
    TextView bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);

        // Inicjalizacja widoków
        heightInput = findViewById(R.id.height_input);
        weightInput = findViewById(R.id.weight_input);
        calculateButton = findViewById(R.id.calculate_bmi_button);
        backButton = findViewById(R.id.back_to_main_button);
        bmiResult = findViewById(R.id.bmi_result);

        // Dodanie nasłuchiwacza do przycisku obliczania BMI
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        // Dodanie nasłuchiwacza do przycisku powrotu do kalkulatora
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });
    }

    private void calculateBMI() {
        // Pobieramy wzrost i wagę wprowadzoną przez użytkownika
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            bmiResult.setText("Proszę wprowadzić wzrost i wagę.");
            return;
        }

        // Konwertujemy wprowadzone wartości na liczby
        float height = Float.parseFloat(heightStr) / 100; // Wzrost w metrach
        float weight = Float.parseFloat(weightStr);

        // Obliczamy BMI
        float bmi = weight / (height * height);

        // Wyświetlamy wynik
        bmiResult.setText("Twoje BMI wynosi: " + String.format("%.2f", bmi));
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}
