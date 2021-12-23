package com.home.projectcacl;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements Constants {

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

    private ActivityResultLauncher<Intent> themeLauncher;

    private Button darkMode;

    CalcData data = new CalcData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);

        call_calc();

        Log.d(TAG, "create");

        if (savedInstanceState != null && savedInstanceState.containsKey(DATA_KEY)) {
            data = savedInstanceState.getParcelable(DATA_KEY);
            Log.d(TAG, "onLoad");
        }

        initCalculator();
        changeTheme();


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
                    data.setSecondDisplay(secondDisplay.getText());
                }
            } else
                Toast.makeText(CalculatorActivity.this, R.string.message_plus, Toast.LENGTH_SHORT).show();
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
                    data.setSecondDisplay(secondDisplay.getText());
                }
            } else
                Toast.makeText(CalculatorActivity.this, R.string.message_minus, Toast.LENGTH_SHORT).show();
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
                    data.setSecondDisplay(secondDisplay.getText());
                }
            } else
                Toast.makeText(CalculatorActivity.this, R.string.message_multiply, Toast.LENGTH_SHORT).show();
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
                    data.setSecondDisplay(secondDisplay.getText());
                }
            } else
                Toast.makeText(CalculatorActivity.this, R.string.message_division, Toast.LENGTH_SHORT).show();
        });


        operationSqrt.setOnClickListener(v -> {
            if (data.getMainDisplay() != null && data.getMainDisplay().length() > 0) {
                if (data.isNegativeFlag()) {
                    Toast.makeText(CalculatorActivity.this, R.string.message_sqrt, Toast.LENGTH_SHORT).show();
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
            if (data.getFirstNumber() != 0 && data.getMainDisplay().length() > 0) {

                if (data.isNegativeFlag()) {
                    data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()) * (-1));
                    changeToNegative.performClick();
                    mainDisplay.setText(Double.toString(data.result()));
                    data.setMainDisplay(mainDisplay.getText());
                } else {
                    data.setSecondNumber(Double.parseDouble(mainDisplay.getText().toString()));
                    mainDisplay.setText(Double.toString(data.result()));
                    data.setMainDisplay(mainDisplay.getText());
                }
                data.setFirstNumber(0);
                data.setSecondNumber(0);
                secondDisplay.setText(R.string.empty_field);

            } else
                Toast.makeText(CalculatorActivity.this, R.string.message_result, Toast.LENGTH_SHORT).show();

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
                Toast.makeText(CalculatorActivity.this, R.string.message_delete, Toast.LENGTH_SHORT).show();
        });


        darkMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(CalculatorActivity.this, SettingActivity.class);
                settings.putExtra(THEME_MODE, AppCompatDelegate.getDefaultNightMode());
                themeLauncher.launch(settings);
            }
        });


    }

    private void call_calc() {
        Intent call_intent = getIntent();
        Bundle bundle = call_intent.getExtras();
        if (bundle == null) {
            return;
        }

    }


    private void changeTheme() {
        themeLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent settingResult = result.getData();
                    if (settingResult != null) {
                        int mode = settingResult.getIntExtra(THEME_MODE, -1);
                        if (mode == 1)
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        if (mode == 2)
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }
                }
        );
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
        if (data.isNegativeFlag()) {
            negativeStatus.setText(R.string.symbol_minus);
        } else {
            negativeStatus.setText(R.string.empty_field);
        }


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
        Log.d(TAG, "onSave");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}