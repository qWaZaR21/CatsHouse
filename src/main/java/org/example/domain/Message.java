package org.example.domain;

import org.example.config.db.DbWorker;

import java.sql.SQLException;

public class Message {
    private Integer id;
    private String tag;
    private String text;

    public Message() {
    }

    public Message(String tag, String text) throws SQLException {
        this.id = DbWorker.getInstance().getDbId();
        this.tag = tag;
        this.text = text;
    }

    public Message(Integer id, String tag, String text) {
        this.id = id;
        this.tag = tag;
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
