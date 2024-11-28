package com.example.devvault.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.devvault.data.Capsule;
import com.example.devvault.data.Reflection;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static SharedPreferences sharedPref;
    private static SharedPreferences.Editor editor;

    private static String FILE_KEY = "db";
    private static String CAPSULE_KEY = "capsules";
    private static String REFLECTION_KEY = "reflections";

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

    public static void addReflection(Reflection reflection) {
        List<Reflection> reflections = getReflections();
        reflection.setId(reflections.size() - 1);
        reflections.add(reflection);
        saveReflections(reflections);
    }

    public static Capsule getCapsuleById(int id) {
        for (Capsule capsule : getCapsules()) {
            if (capsule.getId() == id) {
                return capsule;
            }
        }
        return null;
    }

    public static Reflection getReflectionByCapsuleId(int capsuleId) {
        for (Reflection reflection : getReflections()) {
            if (reflection.getCapsuleId() == capsuleId) {
                return reflection;
            }
        }
        return null;
    }

    public static List<Capsule> getCapsules() {
        final int FIELD_LENGTH_LIMIT = 8;
        List<Capsule> data = new ArrayList<>();
        String items = sharedPref.getString(CAPSULE_KEY, "None");
        for (String item : items.split(ITEM_DELIMITER)) {
            String[] fields = item.split(FIELD_DELIMITER);
            if (fields.length == FIELD_LENGTH_LIMIT) {
                data.add(new Capsule(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7]));
            }
        }
        return data;
    }

    public static List<Reflection> getReflections() {
        final int FIELD_LENGTH_LIMIT = 3;
        List<Reflection> data = new ArrayList<>();
        String items = sharedPref.getString(REFLECTION_KEY, "None");
        for (String item : items.split(ITEM_DELIMITER)) {
            String[] fields = item.split(FIELD_DELIMITER);
            if (fields.length == FIELD_LENGTH_LIMIT) {
                data.add(new Reflection(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2]));
            }
        }
        return data;
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
                    .append(capsule.getCodeSnippet())
                    .append(FIELD_DELIMITER)
                    .append(capsule.getTags())
                    .append(FIELD_DELIMITER)
                    .append(capsule.getOpeningDate())
                    .append(FIELD_DELIMITER)
                    .append(capsule.getCreationDate());
        }
        editor.putString(CAPSULE_KEY, data.toString());
        editor.apply();
    }

    public static void saveReflections(List<Reflection> reflections) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < reflections.size(); i++) {
            Reflection reflection = reflections.get(i);
            if (i != 0 || i != reflections.size() - 1) {
                data.append(ITEM_DELIMITER);
            }
            data.append(reflection.getId())
                    .append(FIELD_DELIMITER)
                    .append(reflection.getCapsuleId())
                    .append(FIELD_DELIMITER)
                    .append(reflection.getContent());
        }
        editor.putString(REFLECTION_KEY, data.toString());
        editor.apply();
    }

    public static void resetDatabase() {
        editor.clear();
        editor.apply();
    }

    public static void logCapsules() {
        // This method is primarily used for testing
        System.out.println("Capsules in the database");
        for (Capsule capsule : getCapsules()) {
            System.out.println(capsule.toString());
        }
    }

    public static void logReflections() {
        // This method is used for testing
        System.out.println("Reflections in the database");
        for (Reflection reflection : getReflections()) {
            System.out.println(reflection.toString());
        }
    }
}
