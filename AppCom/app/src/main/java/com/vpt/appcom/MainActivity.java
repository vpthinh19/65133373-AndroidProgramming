package com.vpt.appcom;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ListView rvContainer = (ListView) findViewById(R.id.rvContainer);
        List<Data> datas = new ArrayList<>();
        datas.add(new Data(R.drawable.cropped_com_ga, "Cơm gà giá rẻ, ngon", "Cơm gà", "25.000"));
        datas.add(new Data(R.drawable.cropped_com_suon_bi_cha, "Cơm sườn bì chả giá rẻ, ngon", "Cơm sườn bì chả", "30.000"));
        datas.add(new Data(R.drawable.cropped_com_suon_trung, "Cơm sườn trứng giá rẻ, ngon", "Cơm sườn trứng", "25.000"));
        datas.add(new Data(R.drawable.cropped_com_thit_kho, "Cơm thịt kho giá rẻ, ngon", "Cơm thịt kho", "20.000"));
        datas.add(new Data(R.drawable.cropped_com_vit, "Cơm vịt giá rẻ, ngon", "Cơm vịt", "25.000"));
        datas.add(new Data(R.drawable.cropped_com_muoi_e, "Cơm muối é giá rẻ, ngon", "Cơm muối é", "20.000"));
        CustomAdapter adapter = new CustomAdapter(datas, this);
        rvContainer.setAdapter(adapter);
        rvContainer.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data data = (Data) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Đã chọn \"" + data.getName() + "\"", Toast.LENGTH_SHORT).show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}