package com.example.workflowcanlendar.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.workflowcanlendar.Dao.TaskModelDao;
import com.example.workflowcanlendar.Entity.TaskModel;

@Database(entities = {TaskModel.class} , version =  1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskModelDao taskModelDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (AppDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class , "task.db").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
