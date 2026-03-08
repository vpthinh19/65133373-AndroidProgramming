package com.example.tinhtong;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextInputEditText textInputA = findViewById(R.id.txta);
        TextInputEditText textInputB = findViewById(R.id.txtb);
        Button btn = findViewById(R.id.btn);
        TextView textOutput = findViewById(R.id.kq);
        btn.setOnClickListener((v) -> {
            String a, b, kq;
            try {
                a = textInputA.getText().toString();
                b = textInputB.getText().toString();
                kq = String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
            } catch (Exception e) {
                kq = "Loi";
            }
            textOutput.setText(kq);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}