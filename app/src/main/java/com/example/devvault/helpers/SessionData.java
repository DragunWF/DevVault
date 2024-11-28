package com.example.devvault.helpers;

import com.example.devvault.data.Capsule;

public class SessionData {
    private static String[] types = new String[] { "Milestone", "Idea", "Productivity", "Aspiration" };
    private static int viewedCapsuleId = 1;

    public static String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public static int getViewedCapsuleId() {
        return viewedCapsuleId;
    }

    public static void setViewedCapsuleId(int viewedCapsuleId) {
        SessionData.viewedCapsuleId = viewedCapsuleId;
    }

    public static int getReflectionCount() {
        return DatabaseHelper.getReflections().size();
    }

    public static int getCapsuleCount() {
        return DatabaseHelper.getCapsules().size();
    }

    public static int getCapsuleTypeCount(String type) {
        int count = 0;
        for (Capsule capsule : DatabaseHelper.getCapsules()) {
            if (capsule.getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        return count;
    }
}
