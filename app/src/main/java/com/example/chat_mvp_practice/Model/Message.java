package com.example.chat_mvp_practice.Model;

public class Message {

    private String text;
    private String time;

    //TODO why we should use default constructor?

    public Message(String text, String time) {
        this.text = text;
        this.time = time;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
