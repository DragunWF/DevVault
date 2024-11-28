package com.example.devvault.helpers;

public class SessionData {
    private static String[] types = new String[] { "Milestone", "Idea", "Skill" };
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
}
