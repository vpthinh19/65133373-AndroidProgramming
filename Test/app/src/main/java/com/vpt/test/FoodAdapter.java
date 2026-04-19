package com.vpt.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<FoodData> datas = new ArrayList<>();
    private Context context;

    public FoodAdapter(Context context, List<FoodData> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.foodTvName.setText(datas.get(position).getName());
        holder.foodTvPrice.setText(datas.get(position).getPrice());
        holder.foodTvDescription.setText(datas.get(position).getDescription());
        holder.foodAvatar.setImageResource(datas.get(position).getAvatar());
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        private TextView foodTvName, foodTvPrice, foodTvDescription;
        private ImageView foodAvatar;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            this.foodTvName = itemView.findViewById(R.id.food_tv_name);
            this.foodTvPrice = itemView.findViewById(R.id.food_tv_price);
            this.foodTvDescription = itemView.findViewById(R.id.food_tv_description);
            this.foodAvatar = itemView.findViewById(R.id.food_img_avatar);
        }
    }
}
