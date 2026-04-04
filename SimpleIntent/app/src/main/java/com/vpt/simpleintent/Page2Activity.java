package com.vpt.simpleintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page2Activity extends AppCompatActivity {
    TextView btnNavPage2;
    Intent intentPage2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        btnNavPage2 = findViewById(R.id.btnNavPage2);
        btnNavPage2.setOnClickListener(v->{
            if (intentPage2 == null){
                intentPage2 = new Intent(Page2Activity.this, MainActivity.class);
            }
            startActivity(intentPage2);
        });
    }
}
