package com.example.workflowcanlendar.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.workflowcanlendar.Entity.TaskModel;

import java.util.List;

@Dao
public interface TaskModelDao {
    @Insert
    void insertTask(TaskModel task);

    @Query("SELECT * FROM task_records")
    LiveData<List<TaskModel>> getAllTasks();

    @Query("DELETE FROM task_records")
    void clearAllTasks();
}
