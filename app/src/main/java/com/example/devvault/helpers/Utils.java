package com.example.devvault.helpers;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class Utils {
    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        }
        return true;
    }

    public static String getString(EditText text) {
        return String.valueOf(text.getText());
    }
}
