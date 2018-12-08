package com.example.dnd.softwareengineeringdnd;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {TextMessage.class}, version = 1)
public abstract class TextMessageDatabase extends RoomDatabase {

    public abstract TextMessageDao Dao();


    private static volatile TextMessageDatabase INSTANCE;

    static TextMessageDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (TextMessageDatabase.class){
                if(INSTANCE == null){
                    //create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TextMessageDatabase.class, "textmessage_database").build();
                }
            }
        }
        return INSTANCE;
    }


}


