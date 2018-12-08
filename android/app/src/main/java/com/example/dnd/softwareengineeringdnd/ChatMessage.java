package com.example.dnd.softwareengineeringdnd;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatMessage extends android.support.v7.widget.AppCompatTextView {

    private String message;
    private Boolean isMe;

    public ChatMessage(Context context, String messsage, Boolean isMe) {
        super(context);

        this.message = message;
        this.isMe = isMe;
        GradientDrawable background = new GradientDrawable();

        this.setText(messsage);
        this.setTextSize(18);
        this.setPadding(15,15,15,15);

        //TODO add layout params for message to be highlighed and gravity to start or end for me vs not me messages
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50,10,50,10);
        if(isMe){
            //if you are teh sender adjust messages to the end of the screen (right in english)
            params.gravity = Gravity.END;

            //if you are the sender make the background light blue
            background.setColor(0xAA42bcf4);
            background.setCornerRadius(5);
            background.setStroke(1, 0xFF000000);//border color black

        }else{

            //if you are not the sender adjust messages to the start of the screen (left)
            params.gravity = Gravity.START;

            //if you are not the sender make the background light yellow
            background.setColor(0xAAf1f442);
            background.setCornerRadius(5);
            background.setStroke(1, 0xFF000000);//border color black
        }

        this.setLayoutParams(params);
        this.setBackground(background);

    }




}
