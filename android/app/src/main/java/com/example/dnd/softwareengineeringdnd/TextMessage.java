package com.example.dnd.softwareengineeringdnd;

public class TextMessage extends MessageType {

    private final String data;

    public TextMessage(String message){

        data = message;
        
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public int getType() {
        //as defined in messagetypes.xml a TextMessage is 0
        return 0;
    }
}
