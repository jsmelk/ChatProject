package com.example.rc.chatproj;

public class MessageBody{

    private String content;

    public MessageBody(){

    }
    public MessageBody(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

}
