package com.example.devvault.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.devvault.data.Capsule;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static SharedPreferences sharedPref;
    private static SharedPreferences.Editor editor;

    private static String FILE_KEY = "db";
    private static String CAPSULE_KEY = "capsules";
    private static String ITEM_DELIMITER = ";";
    private static String FIELD_DELIMITER = ",";

    public static void initialize(Context context) {
        sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public static void addCapsule(Capsule capsule) {
        List<Capsule> capsules = getCapsules();
        capsule.setId(capsules.size() + 1);
        capsules.add(capsule);
        saveCapsules(capsules);
    }

    public static List<Capsule> getCapsules() {
        final int FIELD_LENGTH_LIMIT = 6;
        List<Capsule> data = new ArrayList<>();
        String items = sharedPref.getString(CAPSULE_KEY, "None");
        System.out.println("Items: " + items);
        for (String item : items.split(ITEM_DELIMITER)) {
            String[] fields = item.split(FIELD_DELIMITER);
            if (fields.length == FIELD_LENGTH_LIMIT) {
                data.add(new Capsule(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5]));
            }
        }
        return data;
    }

    public static void resetDatabase() {
        editor.clear();
        editor.apply();
    }

    public static void saveCapsules(List<Capsule> capsules) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < capsules.size(); i++) {
            Capsule capsule = capsules.get(i);
            if (i != 0 || i != capsules.size() - 1) {
                data.append(ITEM_DELIMITER);
            }
            data.append(capsule.getId())
                    .append(FIELD_DELIMITER)
                    .append(capsule.getTitle())
                    .append(FIELD_DELIMITER)
                    .append(capsule.getType())
                    .append(FIELD_DELIMITER)
                    .append(capsule.getDescription())
                    .append(FIELD_DELIMITER)
                    .append(capsule.getTags())
                    .append(FIELD_DELIMITER)
                    .append(capsule.getOpeningDate());
        }
        editor.putString(CAPSULE_KEY, data.toString());
        editor.apply();
    }
}
