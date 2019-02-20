package com.example.celciusfahtenheitconventer.celciusfahrenheitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button switchButton;
    private Button convertButton;
    private Button resetButton;
    private EditText fahrenheitEditText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        convertButton = findViewById(R.id.convertButton);
        switchButton = findViewById(R.id.switchButton);
        resetButton = findViewById(R.id.resetButton);
        fahrenheitEditText = findViewById(R.id.fahrenheitEditText);
        resultText = findViewById(R.id.resultText);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fahrenheitEditText.getText().toString().equals(""))
                {
                    resultText.setText(R.string.error_message);
                }
                else
                {
                    double fahrenheitValue = Double.parseDouble(fahrenheitEditText.getText().toString());
                    double celsiusValue = (fahrenheitValue - 32) / 1.8f;
                    resultText.setText(String.format("%.2f", celsiusValue)+ " Celsius");
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fahrenheitEditText.setText("");
                resultText.setText("");
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });
    }
}
