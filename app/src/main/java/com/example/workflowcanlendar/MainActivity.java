package com.example.workflowcanlendar;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workflowcanlendar.Layout.TaskPreviewWidget;
import com.example.workflowcanlendar.Repository.AppRepository;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
//    private TaskPreviewWidget taskPreview_home, taskPreview_work, taskPreview_school, taskPreview_friends;
//    private BottomNavigationView bottomNavigationView;
//    private ImageButton addTaskButton = findViewById(R.id.addTaskButton);
//    private AppRepository dbRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        dbRepository = new AppRepository(this);
//
//        taskPreview_home = findViewById(R.id.taskPreviewWidget_1);
//        taskPreview_work = findViewById(R.id.taskPreviewWidget_2);
//        taskPreview_school = findViewById(R.id.taskPreviewWidget_3);
//        taskPreview_friends = findViewById(R.id.taskPreviewWidget_4);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.nav_home);
//
//        addTaskButton.findViewById(R.id.addTaskButton);

//        addTaskButton.setOnClickListener(v -> addTask());
    }

    private void addTask() {
    }
}