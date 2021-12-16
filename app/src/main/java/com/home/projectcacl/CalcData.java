package com.home.projectcacl;

import android.os.Parcel;
import android.os.Parcelable;

public class CalcData implements Parcelable {
    private String mainDisplay ="";
    private String secondDisplay="";

   /* задел на будущее
    private String firstNumber; перове число или экран
    private String secondNumber; второе чило или доп экран
    private boolean negativeFlag; флаг для утсановки отрци числа
    private boolean dotCount; флаг для утсановки только 1 точки!
   */

    public CalcData() {

    }

    public String getSecondDisplay() {
        return secondDisplay;
    }

    public void setSecondDisplay(CharSequence secondDisplay) {
        this.secondDisplay = (String) secondDisplay;
    }

    public CharSequence getMainDisplay() {
        return mainDisplay;
    }

    public void setMainDisplay(CharSequence mainDisplay) {
        this.mainDisplay = (String) mainDisplay;
    }

    protected CalcData(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CalcData> CREATOR = new Creator<CalcData>() {
        @Override
        public CalcData createFromParcel(Parcel in) {
            return new CalcData(in);
        }

        @Override
        public CalcData[] newArray(int size) {
            return new CalcData[size];
        }
    };
}
