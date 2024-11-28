package com.example.devvault.helpers;

import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static String getDateToday() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(new Date());
    }

    public static String getString(EditText text) {
        return String.valueOf(text.getText());
    }
}
