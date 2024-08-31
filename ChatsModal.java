package com.example.digitaluniver;

public class ChatsModal {
    private String message;
    private String sender;

    String getMessage(){
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }

    public ChatsModal(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }
}
