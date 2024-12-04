package com.example.workflowcanlendar;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.workflowcanlendar.layout.taskPreviewWidget;

public class MainActivity extends AppCompatActivity {
    private taskPreviewWidget  taskPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        taskPreview = findViewById(R.id.taskPreviewWidget_1);

        taskPreview.setText("50");
        taskPreview.setProgress(50);

    }
}