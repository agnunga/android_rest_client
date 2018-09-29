package com.ag.timesheet.models;

import java.util.ArrayList;



public class MessagesDto {

    private ArrayList<Message> messages;

    public MessagesDto() {

    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
