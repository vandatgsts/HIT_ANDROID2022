package com.example.buoi7;

import java.io.Serializable;

public class Note implements Serializable {
    private Integer id;
    private String content;

    public Note() {
    }

    public Note(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
