package com.vpt.vieccanlam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddTaskActivity extends AppCompatActivity {
    private TextInputEditText addName, addMessage, addDate, addPriority;
    private Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        addName = findViewById(R.id.add_name);
        addDate = findViewById(R.id.add_date);
        addMessage = findViewById(R.id.add_message);
        addPriority = findViewById(R.id.add_priority);
        btnAdd = findViewById(R.id.btn_add);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference tasksReference = database.getReference("tasks");
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = addName.getEditableText().toString();
                String message = addMessage.getEditableText().toString();
                String date = addDate.getEditableText().toString();
                String priority = addPriority.getEditableText().toString();

                Task task = new Task(date, message, name, priority);
                String key = tasksReference.push().getKey();
                HashMap<String, Object> item = new HashMap<>();
                item.put(key, task.toFireBaseTask());
                tasksReference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error == null) finish();
                    }
                });
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}