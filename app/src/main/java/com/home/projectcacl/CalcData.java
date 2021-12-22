package com.home.projectcacl;

import android.os.Parcel;
import android.os.Parcelable;

public class CalcData implements Parcelable {
    private String mainDisplay = "";
    private String secondDisplay = "";
    private boolean negativeFlag;
    private boolean dotCount;
    private double firstNumber;
    private double secondNumber;
    private Operations operation;


    public CalcData() {
        dotCount = false;
        negativeFlag = false;
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

    public boolean isNegativeFlag() {
        return negativeFlag;
    }

    public void setNegativeFlag(boolean negativeFlag) {
        this.negativeFlag = negativeFlag;
    }

    public boolean isDotCount() {
        return dotCount;
    }

    public void setDotCount(boolean dotCount) {
        this.dotCount = dotCount;
    }

    public Operations getOperation() {
        return operation;
    }

    public void setOperation(Operations operation) {
        this.operation = operation;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double result() {
        switch (operation) {
            case plus: {
                return (firstNumber + secondNumber);
            }
            case minus: {
                return (firstNumber - secondNumber);
            }
            case multiply: {
                return (firstNumber * secondNumber);
            }
            case division: {
                return (firstNumber / secondNumber);
            }
            case Sqrt: {
                return (Math.sqrt(firstNumber));
            }

            default:
                return 0;

        }


    }


}
