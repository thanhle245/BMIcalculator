package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText heightText,weightText;
Button calculateButton;
TextView resultText,healthText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightText = findViewById(R.id.idHeight);
        weightText = findViewById(R.id.idWeight);
        calculateButton = findViewById(R.id.calculate_btn);
        resultText = findViewById(R.id.result);
        healthText = findViewById(R.id.healthResult);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float height = Float.parseFloat(String.valueOf(heightText.getText())) /100;
                float weight = Float.parseFloat(String.valueOf(weightText.getText()));
                float bmi = weight / (height * height);
                resultText.setText(String.valueOf(bmi));
                if(height == 0){
                    heightText.setError("can't be empty");
                    resultText.setText("something wrong!");
                    healthText.setText("something wrong!");
                }
                if(weight == 0){
                    weightText.setError("can't be empty");
                    resultText.setText("something wrong!");
                    healthText.setText("something wrong!");
                }
                else if (bmi<16){
                    healthText.setText("Severe Thinness");
                }
                else if (bmi>=16 && bmi<=17){
                    healthText.setText("Moderate Thinness");
                }
                else if (bmi>17 && bmi<18.5){
                    healthText.setText("Mild Thinness");
                }
                else if (bmi>18.5 && bmi<25){
                    healthText.setText("Normal");
                }
                else if (bmi>25 && bmi<30){
                    healthText.setText("Overweight");
                }
                else if (bmi>30 && bmi<35){
                    healthText.setText("Obese Class I");
                }
                else if (bmi>35 && bmi<40){
                    healthText.setText("Obese Class II");
                }
                else if (bmi>40){
                    healthText.setText("Obese Class III");
                }
            }
        });
    }
}