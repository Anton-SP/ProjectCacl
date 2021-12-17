package com.home.projectcacl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String DATA_KEY = "data_key";
    private Button number0;
    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;
    private Button symbolDot;
    private Button operationPlus;
    private Button operationMinus;
    private Button operationX;
    private Button operationDivision;
    private Button operationResult;
    private Button operationClean;
    private Button operationDelete;
    private Button changeToNegative;
    private Button operationSqrt;
    private TextView secondDisplay;
    private TextView mainDisplay;
    private TextView negativeStatus;

    CalcData data = new CalcData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);

        if (savedInstanceState != null && savedInstanceState.containsKey(DATA_KEY)) {
            data = savedInstanceState.getParcelable(DATA_KEY);

        }

        mainDisplay = findViewById(R.id.main_display);
        secondDisplay = findViewById(R.id.second_display);
        negativeStatus = findViewById(R.id.negative_status);

        mainDisplay.setText(data.getMainDisplay());
        secondDisplay.setText(data.getSecondDisplay());

        number0 = findViewById(R.id.number_0);
        number1 = findViewById(R.id.number_1);
        number2 = findViewById(R.id.number_2);
        number3 = findViewById(R.id.number_3);
        number4 = findViewById(R.id.number_4);
        number5 = findViewById(R.id.number_5);
        number6 = findViewById(R.id.number_6);
        number7 = findViewById(R.id.number_7);
        number8 = findViewById(R.id.number_8);
        number9 = findViewById(R.id.number_9);
        symbolDot = findViewById(R.id.button_dot);

        number0.setOnClickListener(v -> enterNumber(number0.getText()));
        number1.setOnClickListener(v -> enterNumber(number1.getText()));
        number2.setOnClickListener(v -> enterNumber(number2.getText()));
        number3.setOnClickListener(v -> enterNumber(number3.getText()));
        number4.setOnClickListener(v -> enterNumber(number4.getText()));
        number5.setOnClickListener(v -> enterNumber(number5.getText()));
        number6.setOnClickListener(v -> enterNumber(number6.getText()));
        number7.setOnClickListener(v -> enterNumber(number7.getText()));
        number8.setOnClickListener(v -> enterNumber(number8.getText()));
        number9.setOnClickListener(v -> enterNumber(number9.getText()));

        symbolDot.setOnClickListener(v -> {
            if (data.getMainDisplay() != null) {
                if (data.getMainDisplay().length() == 0) {
                    enterNumber(number0.getText());
                    data.setMainDisplay(data.getMainDisplay() + symbolDot.getText().toString());
                } else data.setMainDisplay(data.getMainDisplay() + symbolDot.getText().toString());
            }
        });


        operationPlus = findViewById(R.id.button_plus);
        operationMinus = findViewById(R.id.button_minus);
        operationX = findViewById(R.id.button_x);
        operationDivision = findViewById(R.id.button_division);
        operationResult = findViewById(R.id.button_result);
        operationClean = findViewById(R.id.button_clean);
        operationDelete = findViewById(R.id.button_del);
        changeToNegative = findViewById(R.id.button_negative);
        operationSqrt = findViewById(R.id.button_sqrt);


        operationPlus.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (secondDisplay.getText().length()>0) {
                    secondDisplay.setText(secondDisplay.getText().toString() +mainDisplay.getText()+ operationPlus.getText().toString());
                    data.setSecondDisplay(secondDisplay.getText());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }   else {
                    secondDisplay.setText(mainDisplay.getText() + operationPlus.getText().toString());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                                }
            } else Toast.makeText(MainActivity.this, "Nothing to plus", Toast.LENGTH_SHORT).show();
        });

        operationMinus.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (secondDisplay.getText().length()>0) {
                    secondDisplay.setText(secondDisplay.getText().toString() + mainDisplay.getText() + operationMinus.getText().toString() );
                    data.setSecondDisplay(secondDisplay.getText());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }   else {
                    secondDisplay.setText(mainDisplay.getText() + operationMinus.getText().toString());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }
            } else Toast.makeText(MainActivity.this, "Nothing to minus", Toast.LENGTH_SHORT).show();
        });


        operationX.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (secondDisplay.getText().length()>0) {
                    secondDisplay.setText(secondDisplay.getText().toString() + mainDisplay.getText() + operationX.getText().toString() );
                    data.setSecondDisplay(secondDisplay.getText());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }   else {
                    secondDisplay.setText(mainDisplay.getText() + operationX.getText().toString());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }
            } else
                Toast.makeText(MainActivity.this, "Nothing to multiply", Toast.LENGTH_SHORT).show();
        });


        operationDivision.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (secondDisplay.getText().length()>0) {
                    secondDisplay.setText(secondDisplay.getText().toString()  + mainDisplay.getText() + operationDivision.getText().toString());
                    data.setSecondDisplay(secondDisplay.getText());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }   else {
                    secondDisplay.setText(mainDisplay.getText() + operationDivision.getText().toString());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }
            } else
                Toast.makeText(MainActivity.this, "Nothing to divide", Toast.LENGTH_SHORT).show();
        });

        operationResult.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "There are no result yet", Toast.LENGTH_SHORT).show();
        });


        operationClean.setOnClickListener(v -> {
            data.setMainDisplay("");
            data.setSecondDisplay("");
            mainDisplay.setText(data.getMainDisplay());
            secondDisplay.setText(data.getSecondDisplay());
            negativeStatus.setText("");
        });

        operationDelete.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                data.setMainDisplay(data.getMainDisplay().subSequence(0, data.getMainDisplay().length() - 1));
                mainDisplay.setText(data.getMainDisplay());
            } else
                Toast.makeText(MainActivity.this, "Nothing to delete", Toast.LENGTH_SHORT).show();
        });

        changeToNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                   negativeStatus.setText(R.string.symbol_minus);
                }
            }
        });

        operationSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "SQRT RESULT!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void enterNumber(CharSequence curBuffer) {
        data.setMainDisplay(data.getMainDisplay() + curBuffer.toString());
        mainDisplay.setText(data.getMainDisplay());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(DATA_KEY, data);
        super.onSaveInstanceState(outState);

    }

}