package com.example.workflowcanlendar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workflowcanlendar.CatagoryEnum.CatagoryEnum;
import com.example.workflowcanlendar.Entity.TaskModel;
import com.example.workflowcanlendar.Layout.TaskPreviewWidget;
import com.example.workflowcanlendar.Repository.AppRepository;
import com.example.workflowcanlendar.ViewModel.TaskViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static final int THRESHOLD = 20;
    private TaskPreviewWidget taskPreview_home, taskPreview_work, taskPreview_school, taskPreview_friends;
    private BottomNavigationView bottomNavigationView;
    private ImageButton addTaskButton;
    private AppRepository dbRepository;
    private TaskViewModel homeTaskViewModel, workTaskViewModel, schoolTaskViewModel, friendsTaskViewModel;
    private TaskViewModel allTaskViewModel;
    private ImageView userStatusIcon;
    private TextView userStatusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dbRepository = new AppRepository(this);

        initialWelcomeLayout();
        initialTaskPreview();
        initialBottomNavigationView();
        initialAddTaskButton();

    }

    private void initialWelcomeLayout() {
        userStatusIcon = findViewById(R.id.userStatusIcon);
        userStatusText = findViewById(R.id.userStatusText);

        allTaskViewModel = new TaskViewModel(this);
        allTaskViewModel.getAllTaskCount(this).observe(this , count -> {
            if (count >= THRESHOLD) {
                userStatusIcon.setImageResource(R.drawable.icon_tired);
                userStatusText.setText("Maybe too much for u");
            } else {
                userStatusIcon.setImageResource(R.drawable.icon_cool);
                userStatusText.setText("You are doing great!");
            }
        });
    }

    private void initialTaskPreview(){
        taskPreview_home = findViewById(R.id.taskPreviewWidget_1);
        taskPreview_work = findViewById(R.id.taskPreviewWidget_2);
        taskPreview_school = findViewById(R.id.taskPreviewWidget_3);
        taskPreview_friends = findViewById(R.id.taskPreviewWidget_4);

        taskPreview_home.setText("Home");
        taskPreview_work.setText("Work");
        taskPreview_school.setText("School");
        taskPreview_friends.setText("Friends");

        homeTaskViewModel = new TaskViewModel(this , CatagoryEnum.HOME.getCatagoryCode());
        workTaskViewModel = new TaskViewModel(this , CatagoryEnum.WORK.getCatagoryCode());
        schoolTaskViewModel = new TaskViewModel(this , CatagoryEnum.SCHOOL.getCatagoryCode());
        friendsTaskViewModel = new TaskViewModel(this , CatagoryEnum.FRIENDS.getCatagoryCode());

        homeTaskViewModel.getTaskCountByCatagory().observe(this , count -> {
            taskPreview_home.setProgress(count);
        });
        workTaskViewModel.getTaskCountByCatagory().observe(this , count -> {
            taskPreview_work.setProgress(count);
        });
        schoolTaskViewModel.getTaskCountByCatagory().observe(this , count -> {
            taskPreview_school.setProgress(count);
        });
        friendsTaskViewModel.getTaskCountByCatagory().observe(this , count -> {
            taskPreview_friends.setProgress(count);
        });


    }
    private void initialBottomNavigationView(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }
    private void initialAddTaskButton(){
        addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(v -> addTask());
    }

    private void addTask() {
        String[] categories = {
                CatagoryEnum.HOME.getCatagoryName(),
                CatagoryEnum.WORK.getCatagoryName(),
                CatagoryEnum.SCHOOL.getCatagoryName(),
                CatagoryEnum.FRIENDS.getCatagoryName()
        };
        View dialogView = getLayoutInflater().inflate(R.layout.add_task_dialog, null);
        Spinner categorySpinner = dialogView.findViewById(R.id.categorySpinner);
        EditText nameEditText = dialogView.findViewById(R.id.nameEditText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择类别和输入名称")
                .setView(dialogView)
                .setPositiveButton("确认", (dialog, which) -> {
                    // 获取选择的类别和输入的名称
                    String selectedCategory = categorySpinner.getSelectedItem().toString();
                    String name = nameEditText.getText().toString();

                    dbRepository.InsertTask(new TaskModel(CatagoryEnum.valueOf(selectedCategory).getCatagoryCode(), name));

                })
                .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }
}