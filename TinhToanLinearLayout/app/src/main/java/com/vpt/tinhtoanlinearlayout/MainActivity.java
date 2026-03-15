package com.vpt.tinhtoanlinearlayout;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    LinearLayout llMain;
    TextInputEditText etInput1, etInput2, etResult;
    Button btnPlusOp, btnSubOp, btnMulOp, btnDivOp;
    private double input1, input2;

    public boolean getData(){
        try {
            input1 = Double.parseDouble(etInput1.getEditableText().toString());
            input2 = Double.parseDouble(etInput2.getEditableText().toString());
            return true;
        } catch (Exception e){
            Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        llMain = findViewById(R.id.main);
        etInput1 = findViewById(R.id.etInput1);
        etInput2 = findViewById(R.id.etInput2);
        btnPlusOp = findViewById(R.id.btnPlusOp);
        btnSubOp = findViewById(R.id.btnSubOp);
        btnMulOp = findViewById(R.id.btnMulOp);
        btnDivOp = findViewById(R.id.btnDivOp);
        etResult = findViewById(R.id.etResult);

        llMain.setOnClickListener(v -> {
            etInput1.clearFocus();
            etInput2.clearFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(etInput1.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(etInput2.getWindowToken(), 0);
        });

        btnPlusOp.setOnClickListener(v -> {
            if (getData()){
                etResult.setText(String.valueOf(input1 + input2));
            }
        });

        btnSubOp.setOnClickListener(v -> {
            if (getData()){
                etResult.setText(String.valueOf(input1 - input2));
            }
        });

        btnMulOp.setOnClickListener(v -> {
            if (getData()){
                etResult.setText(String.valueOf(input1 * input2));
            }
        });

        btnDivOp.setOnClickListener(v -> {
            if (getData()){
                etResult.setText(String.valueOf((input2 != 0) ? (input1 / input2) : ("Số thứ hai phải khác 0")));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}