package com.springboot.backend.chat.springboot_backend_chat.models;

public class Message {
    private String text;

    private Long date;


    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public Long getDate(){
        return date;
    }

    public void setDate(Long date){
        this.date = date;
    }

    

}
