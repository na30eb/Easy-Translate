package com.example.easytranslate;

public class modelClass {
    public modelClass(String title, String text, String source) {
        this.title = title;
        this.text = text;
        this.source = source;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    private String text;
    private String source;
}
