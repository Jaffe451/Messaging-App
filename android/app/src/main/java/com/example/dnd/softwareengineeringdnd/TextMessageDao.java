package com.example.dnd.softwareengineeringdnd;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TextMessageDao {

    @Insert
    void insert(TextMessage message);

    @Query("DELETE FROM messages")
    void clear();

    @Query("SELECT * FROM messages WHERE otherUser IS :name")
    List<TextMessage> getMessages(String name);

    @Query("SELECT * FROM messages")
    LiveData<List<TextMessage>> getLiveMessages();
}
