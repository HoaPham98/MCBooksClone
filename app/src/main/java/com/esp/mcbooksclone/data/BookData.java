package com.esp.mcbooksclone.data;

/**
 * Created by Hoa's PC on 5/28/2017.
 */

public class BookData {
    private String name;
    private String coverPath;

    public BookData(){

    }

    public BookData(String name, String coverPath) {
        this.name = name;
        this.coverPath = coverPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }
}
