package com.vpt.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity2 extends AppCompatActivity {
    private TextView secondLogoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        secondLogoText = findViewById(R.id.second_logo_text);
        Intent intent = getIntent();
        String signal = intent.getStringExtra("signal");
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (signal.equals("bmi")){
            fragmentManager.beginTransaction()
                    .replace(R.id.second_content_container, new BMIFragment())
                    .commit();
            secondLogoText.setText("Tính chỉ số cơ thể");
        } else if (signal.equals("food")) {
            fragmentManager.beginTransaction()
                    .replace(R.id.second_content_container, new FoodFragment())
                    .commit();
            secondLogoText.setText("Danh mục món ăn");
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}