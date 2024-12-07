package com.example.workflowcanlendar.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.workflowcanlendar.Dao.TaskModelDao;
import com.example.workflowcanlendar.Database.AppDatabase;
import com.example.workflowcanlendar.Entity.TaskModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppRepository {
    private final TaskModelDao dao;
    private final ExecutorService executorService;

    public AppRepository(Context context) {

        AppDatabase db = AppDatabase.getInstance(context);
        this.dao = db.taskModelDao();
        this.executorService = Executors.newSingleThreadExecutor();
    }
    public void InsertTask(TaskModel task){
        executorService.execute(() -> dao.insertTask(task));
    }

    public LiveData<Integer> CountTasksByCatagory(int catagory){
        return dao.getTaskCountByCatagory(catagory);
    }

    public LiveData<Integer> CountAllTasks(){
        return dao.getAllTaskCount();
    }
}
