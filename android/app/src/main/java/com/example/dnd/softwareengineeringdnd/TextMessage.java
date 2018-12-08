package com.example.dnd.softwareengineeringdnd;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity(tableName = "messages")
public class TextMessage{

    @PrimaryKey(autoGenerate = true)
    private int key;


    @NonNull
    @ColumnInfo(name = "message")
    private final String data;

    @NonNull
    @ColumnInfo(name = "otherUser")
    private final String otherUser;

    @NonNull
    @ColumnInfo(name = "isMe")
    private final boolean isMe;


    public TextMessage(@NonNull String data,@NonNull String otherUser,@NonNull Boolean isMe){

        this.data = data;
        this.otherUser = otherUser;

        this.isMe = isMe;
    }

    public String getData() {
        return data;
    }

    public String getOtherUser(){ return otherUser; }

    public boolean getIsMe(){ return isMe; }

    public int getType() {
        //as defined in messagetypes.xml a TextMessage is 0
        return 0;
    }

    public int getKey(){
        return key;
    }

    public void setKey(int key){
        this.key = key;
    }
}
