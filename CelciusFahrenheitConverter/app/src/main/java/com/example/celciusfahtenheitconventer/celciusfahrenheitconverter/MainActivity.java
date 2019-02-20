package com.example.celciusfahtenheitconventer.celciusfahrenheitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button switchButton;
    private Button convertButton;
    private Button resetButton;
    private EditText celsiusEditText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertButton = findViewById(R.id.convertButton);
        switchButton = findViewById(R.id.switchButton);
        resetButton = findViewById(R.id.resetButton);
        celsiusEditText = findViewById(R.id.celsiusEditText);
        resultText = findViewById(R.id.resultText);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (celsiusEditText.getText().toString().equals(""))
                {
                    resultText.setText(R.string.error_message);
                }
                else
                {
                    double celciusValue = Double.parseDouble(celsiusEditText.getText().toString());
                    double fahrenheitValue = celciusValue * 1.8f + 32;
                    resultText.setText(String.format("%.2f", fahrenheitValue)+ " Fahrenheits");
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                celsiusEditText.setText("");
                resultText.setText("");
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }
}
