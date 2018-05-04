package com.example.androidstydy.drawer;

public class Item {
    private int icon;
    private String title;

    public Item(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }
}
