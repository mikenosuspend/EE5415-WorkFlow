package com.example.workflowcanlendar.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_records")
public class TaskModel {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public int catagory;//任务类型

    public String name;//任务名称

    public TaskModel(int catagory, String name) {
        this.catagory = catagory;
        this.name = name;
    }
}
