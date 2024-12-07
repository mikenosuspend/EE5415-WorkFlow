package com.example.workflowcanlendar.Layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.workflowcanlendar.CatagoryEnum.CatagoryEnum;
import com.example.workflowcanlendar.R;
import com.example.workflowcanlendar.ViewModel.TaskViewModel;

public class TaskPreviewWidget extends LinearLayout {
    private TextView widgetText;
    private ProgressBar widgetProgress;
    private TaskViewModel taskViewModel;
    private int taskCountByCatagory;
    private int wigetId;
    private CatagoryEnum catagory;
    public TaskPreviewWidget(Context context) {
        super(context);
        init(context);

    }

    public TaskPreviewWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }



    private void init(Context context) {
        // 将布局 XML 绑定到这个自定义视图
        LayoutInflater.from(context).inflate(R.layout.task_preview_widget, this, true);

        wigetId = getId();
        int viewId = getId();

        if(viewId == R.id.taskPreviewWidget_1){
            catagory = CatagoryEnum.HOME;
        }
        else if(viewId == R.id.taskPreviewWidget_2){
            catagory = CatagoryEnum.WORK;
        }
        else if(viewId == R.id.taskPreviewWidget_3){
            catagory = CatagoryEnum.SCHOOL;
        }
        else{
            catagory = CatagoryEnum.FRIENDS;
        }
        taskViewModel = new TaskViewModel(context , catagory.getCatagoryCode());
        taskViewModel.getTaskCountByCatagory().observe((LifecycleOwner) context, count -> {
            taskCountByCatagory = count;
        });
        widgetText = findViewById(R.id.widget_text);
        widgetProgress = findViewById(R.id.widget_progress);

//         为 Widget 设置点击事件
//        this.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 点击时弹出一个简单的弹出窗口（Dialog）
//
//
//                taskCountByCatagory = new TaskViewModel(context, catagory.getCatagoryCode()).getTaskCountByCatagory().getValue();
//                // 弹出窗口显示 ID
//                String countByCatagoryString = getResources().getResourceEntryName(taskCountByCatagory); // 将 ID 转为字符串
//                Toast.makeText(context, "Task Total: " + countByCatagoryString, Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

    // 设置文本
    public void setText(String text) {
        widgetText.setText(text);
    }

    // 设置进度
    public void setProgress(int progress) {
        widgetProgress.setProgress(progress);
    }

    // 弹出窗口的功能
    private void showDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("弹出窗口")
                .setMessage("这是一个弹出的窗口，您可以在此显示更多内容。")
                .setPositiveButton("确定", null)
                .show();
    }
}
