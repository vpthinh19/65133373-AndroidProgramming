package com.vpt.bottomnavbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {
    private List<ColorData> colors;
    private Context context;

    public ColorAdapter(Context context, List<ColorData> colors) {
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.color_item, parent, false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.tvName.setText(colors.get(position).getName());
        holder.ivImage.setImageResource(colors.get(position).getImage());
    }

    public class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvName;
        private ImageView ivImage;

        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivImage = itemView.findViewById(R.id.iv_image);
            this.tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getBindingAdapterPosition();
            Toast.makeText(context, "clicked: " + colors.get(clickedPosition).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
