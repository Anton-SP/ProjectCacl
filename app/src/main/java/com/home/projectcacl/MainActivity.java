package com.home.projectcacl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

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

    private Button darkMode;

    CalcData data = new CalcData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);


        if (savedInstanceState != null && savedInstanceState.containsKey(DATA_KEY)) {
            data = savedInstanceState.getParcelable(DATA_KEY);

        }

        initCalculator();

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

        operationPlus.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (secondDisplay.getText().length() > 0) {

                    if (data.isNegativeFlag()) {
                        data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                        data.setFirstNumber(data.result());
                        secondDisplay.setText((data.getFirstNumber()) + operationPlus.getText().toString());
                        changeToNegative.performClick();
                    } else {
                        data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()));
                        data.setFirstNumber(data.result());
                        secondDisplay.setText((data.getFirstNumber()) + operationPlus.getText().toString());
                    }
                    negativeStatus.performClick();
                    data.setOperation(data.getOperation().plus);
                    data.setSecondDisplay(secondDisplay.getText());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());

                } else {
                    if (data.isNegativeFlag()) {
                        data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                        secondDisplay.setText("-" + mainDisplay.getText() + operationPlus.getText().toString());
                        changeToNegative.performClick();
                    } else {
                        data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()));
                        secondDisplay.setText(mainDisplay.getText() + operationPlus.getText().toString());
                    }
                    data.setOperation(data.getOperation().plus);
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }
            } else Toast.makeText(MainActivity.this, "Nothing to plus", Toast.LENGTH_SHORT).show();
        });

        operationMinus.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (secondDisplay.getText().length() > 0) {

                    if (data.isNegativeFlag()) {
                        data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                        data.setFirstNumber(data.result());
                        secondDisplay.setText((data.getFirstNumber()) + operationMinus.getText().toString());
                        changeToNegative.performClick();
                    } else {
                        data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()));
                        data.setFirstNumber(data.result());
                        secondDisplay.setText((data.getFirstNumber()) + operationMinus.getText().toString());
                    }
                    negativeStatus.performClick();
                    data.setOperation(data.getOperation().minus);
                    data.setSecondDisplay(secondDisplay.getText());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());

                } else {
                    if (data.isNegativeFlag()) {
                        data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                        secondDisplay.setText("-" + mainDisplay.getText() + operationMinus.getText().toString());
                        changeToNegative.performClick();
                    } else {
                        data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()));
                        secondDisplay.setText(mainDisplay.getText() + operationMinus.getText().toString());
                    }
                    data.setOperation(data.getOperation().minus);
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }
            } else Toast.makeText(MainActivity.this, "Nothing to minus", Toast.LENGTH_SHORT).show();
        });

        operationX.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (secondDisplay.getText().length() > 0) {

                    if (data.isNegativeFlag()) {
                        data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                        data.setFirstNumber(data.result());
                        secondDisplay.setText((data.getFirstNumber()) + operationX.getText().toString());
                        changeToNegative.performClick();
                    } else {
                        data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()));
                        data.setFirstNumber(data.result());
                        secondDisplay.setText((data.getFirstNumber()) + operationX.getText().toString());
                    }
                    negativeStatus.performClick();
                    data.setOperation(data.getOperation().multiply);
                    data.setSecondDisplay(secondDisplay.getText());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());

                } else {
                    if (data.isNegativeFlag()) {
                        data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                        secondDisplay.setText("-" + mainDisplay.getText() + operationX.getText().toString());
                        changeToNegative.performClick();
                    } else {
                        data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()));
                        secondDisplay.setText(mainDisplay.getText() + operationX.getText().toString());
                    }
                    data.setOperation(data.getOperation().multiply);
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }
            } else
                Toast.makeText(MainActivity.this, "Nothing to multiply", Toast.LENGTH_SHORT).show();
        });


        operationDivision.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (secondDisplay.getText().length() > 0) {

                    if (data.isNegativeFlag()) {
                        data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                        data.setFirstNumber(data.result());
                        secondDisplay.setText((data.getFirstNumber()) + operationDivision.getText().toString());
                        changeToNegative.performClick();
                    } else {
                        data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()));
                        data.setFirstNumber(data.result());
                        secondDisplay.setText((data.getFirstNumber()) + operationDivision.getText().toString());
                    }
                    negativeStatus.performClick();
                    data.setOperation(data.getOperation().division);
                    data.setSecondDisplay(secondDisplay.getText());
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());

                } else {
                    if (data.isNegativeFlag()) {
                        data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                        secondDisplay.setText("-" + mainDisplay.getText() + operationDivision.getText().toString());
                        changeToNegative.performClick();
                    } else {
                        data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()));
                        secondDisplay.setText(mainDisplay.getText() + operationDivision.getText().toString());
                    }
                    data.setOperation(data.getOperation().division);
                    data.setMainDisplay("");
                    mainDisplay.setText(data.getMainDisplay());
                }
            } else
                Toast.makeText(MainActivity.this, "Nothing to Division", Toast.LENGTH_SHORT).show();
        });


        operationSqrt.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (data.isNegativeFlag()) {
                    Toast.makeText(MainActivity.this, "You can't get a square root of a negative number", Toast.LENGTH_SHORT).show();
                } else {
                    data.setFirstNumber(Double.parseDouble(mainDisplay.getText().toString()));
                    data.setOperation(data.getOperation().Sqrt);
                    data.setFirstNumber(data.result());
                    mainDisplay.setText(Double.toString(data.getFirstNumber()));
                }

            }
        });

        symbolDot.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && !data.isDotCount()) {
                if (data.getMainDisplay().length() == 0) {
                    enterNumber(number0.getText());
                    data.setMainDisplay(data.getMainDisplay() + symbolDot.getText().toString());
                    data.setDotCount(true);
                } else {
                    data.setMainDisplay(data.getMainDisplay() + symbolDot.getText().toString());
                    data.setDotCount(true);
                }
            }
        });


        changeToNegative.setOnClickListener(v -> {
            if (data.isNegativeFlag()) {
                data.setNegativeFlag(false);
                negativeStatus.setText(R.string.empty_field);

            } else {
                if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                    negativeStatus.setText(R.string.symbol_minus);
                    data.setNegativeFlag(true);
                }

            }


        });


        operationResult.setOnClickListener(v -> {
            if (data.getFirstNumber() != 0) {
                if (data.isNegativeFlag()) {
                    data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                    changeToNegative.performClick();
                    mainDisplay.setText(Double.toString(data.result()));

                } else {
                    data.setSecondNumber(Float.parseFloat(mainDisplay.getText().toString()));
                    mainDisplay.setText(Double.toString(data.result()));
                }

            }

        });


        operationClean.setOnClickListener(v -> {
            clean();


        });

        operationDelete.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (data.getMainDisplay().charAt(data.getMainDisplay().length() - 1) != '.') {
                    data.setMainDisplay(data.getMainDisplay().subSequence(0, data.getMainDisplay().length() - 1));
                    mainDisplay.setText(data.getMainDisplay());
                } else {
                    data.setMainDisplay(data.getMainDisplay().subSequence(0, data.getMainDisplay().length() - 1));
                    mainDisplay.setText(data.getMainDisplay());
                    data.setDotCount(false);
                }


            } else
                Toast.makeText(MainActivity.this, "Nothing to delete", Toast.LENGTH_SHORT).show();
        });


        darkMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });


    }

    private void clean() {
        data.setMainDisplay("");
        data.setSecondDisplay("");
        mainDisplay.setText(data.getMainDisplay());
        secondDisplay.setText(data.getSecondDisplay());
        negativeStatus.setText("");
        data.setFirstNumber(0);
        data.setSecondNumber(0);
        data.setOperation(data.getOperation().empty);
        data.setNegativeFlag(false);
        data.setDotCount(false);
    }


    private void initCalculator() {
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

        operationPlus = findViewById(R.id.button_plus);
        operationMinus = findViewById(R.id.button_minus);
        operationX = findViewById(R.id.button_x);
        operationDivision = findViewById(R.id.button_division);
        operationResult = findViewById(R.id.button_result);
        operationClean = findViewById(R.id.button_clean);
        operationDelete = findViewById(R.id.button_del);
        changeToNegative = findViewById(R.id.button_negative);
        operationSqrt = findViewById(R.id.button_sqrt);
        darkMode = findViewById(R.id.dark_mode_switch);

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