package com.example.dnd.softwareengineeringdnd;

public class TextMessage extends MessageType {

    private final String data;
    private final User sender;

    public TextMessage(String message, User sender){

        data = message;
        this.sender = sender;
        
    }

    @Override
    public String getData() {
        return data;
    }

    public User getSender(){ return sender; }

    @Override
    public int getType() {
        //as defined in messagetypes.xml a TextMessage is 0
        return 0;
    }
}
