package com.example.devvault.data;

public class Reflection {
    private int id;
    private int capsuleId;
    private String content;

    public Reflection(int id, int capsuleId, String content) {
        this.id = id;
        this.capsuleId = capsuleId;
        this.content = content;
    }

    public Reflection(int capsuleId, String content) {
        this.capsuleId = capsuleId;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCapsuleId() {
        return capsuleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
