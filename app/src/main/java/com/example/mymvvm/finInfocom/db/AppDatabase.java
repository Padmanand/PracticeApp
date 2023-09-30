package com.example.mymvvm.finInfocom.db;

import android.content.Context;

import com.example.mymvvm.finInfocom.model.People;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {People.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PeopleDao peopleDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDBInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "FININFOCOM")
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }

}
