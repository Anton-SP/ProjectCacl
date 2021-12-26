package com.home.projectcacl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingActivity extends AppCompatActivity implements Constants {

    private MaterialRadioButton day;
    private MaterialRadioButton night;
    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        day=findViewById(R.id.day_check);
        night=findViewById(R.id.night_check);

        int mode = getIntent().getExtras().getInt(THEME_MODE);


        if (mode ==DAY_MODE || mode == MODE_UNSPECIFIED) {
            findViewById(R.id.day_check).performClick();
        } else {
            findViewById(R.id.night_check).performClick();
        }




    findViewById(R.id.exit_setting).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int mode=-1;
            if (day.isChecked()){mode = 1;}
            if (night.isChecked()){mode= 2;}

            Intent returnIntent = new Intent();
            returnIntent.putExtra(CalculatorActivity.THEME_MODE,mode);
            setResult(RESULT_OK,returnIntent);

            finish();
        }
    });



    }



}