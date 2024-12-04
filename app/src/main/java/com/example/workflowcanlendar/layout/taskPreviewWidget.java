package com.example.workflowcanlendar.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

import androidx.annotation.Nullable;

import com.example.workflowcanlendar.R;

public class taskPreviewWidget extends LinearLayout {
    private TextView widgetText;
    private ProgressBar widgetProgress;
    public taskPreviewWidget(Context context) {
        super(context);
        init(context);

    }

    public taskPreviewWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }



    private void init(Context context) {
        // 将布局 XML 绑定到这个自定义视图
        LayoutInflater.from(context).inflate(R.layout.task_preview_widget, this, true);

        widgetText = findViewById(R.id.widget_text);
        widgetProgress = findViewById(R.id.widget_progress);

        // 为 Widget 设置点击事件
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击时弹出一个简单的弹出窗口（Dialog）
                showDialog(context);
            }
        });
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
