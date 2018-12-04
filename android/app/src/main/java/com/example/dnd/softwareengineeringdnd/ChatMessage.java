package com.example.dnd.softwareengineeringdnd;

import android.app.ActionBar;
import android.content.Context;
import android.widget.TextView;

public class ChatMessage extends android.support.v7.widget.AppCompatTextView {

    private String message;
    private Boolean isMe;

    public ChatMessage(Context context, String messsage, Boolean isMe) {
        super(context);

        this.message = message;
        this.isMe = isMe;

        //TODO add layout params for message to be highlighed and gravity to start or end for me vs not me messages

    }




}
