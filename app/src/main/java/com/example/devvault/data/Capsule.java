package com.example.devvault.data;

public class Capsule {
    private int id;
    private String title;
    private String type;
    private String description;
    private String codeSnippet;
    private String tags;
    private String openingDate;
    private String creationDate;

    public Capsule(int id, String title, String type, String description, String codeSnippet, String tags, String openingDate, String creationDate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.codeSnippet = codeSnippet;
        this.tags = tags;
        this.openingDate = openingDate;
        this.creationDate = creationDate;
    }

    public Capsule(String title, String type, String description, String codeSnippet, String tags, String openingDate, String creationDate) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.codeSnippet = codeSnippet;
        this.tags = tags;
        this.openingDate = openingDate;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Capsule{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", codeSnippet='" + codeSnippet + '\'' +
                ", tags='" + tags + '\'' +
                ", openingDate='" + openingDate + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public String getTags() {
        return tags;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public String getCreationDate() {
        return creationDate;
    }
}
