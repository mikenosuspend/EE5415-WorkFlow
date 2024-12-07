package com.example.workflowcanlendar.ViewModel;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.workflowcanlendar.Database.AppDatabase;
import com.example.workflowcanlendar.Repository.AppRepository;

public class TaskViewModel extends ViewModel {
    private final LiveData<Integer> taskCountByCatagory;
    private final LiveData<Integer> allTaskCount;

    public TaskViewModel(Context context) {
        this(context, 0); // 默认分类值为 -1
    }

    public TaskViewModel(Context context , int catagory) {
        AppRepository dbhelper  = new AppRepository(context);
        taskCountByCatagory = dbhelper.CountTasksByCatagory(catagory);
        allTaskCount = dbhelper.CountAllTasks();
    }

    public LiveData<Integer> getTaskCountByCatagory() {
        return taskCountByCatagory;
    }

    public LiveData<Integer> getAllTaskCount(Context context) {
        return allTaskCount;
    }
}
