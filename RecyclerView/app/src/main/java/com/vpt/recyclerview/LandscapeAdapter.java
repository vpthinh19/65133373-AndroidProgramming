package com.vpt.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<Landscape> lstData;

    public LandscapeAdapter(Context context, ArrayList<Landscape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_land, parent, false);
        return new ItemLandHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        Landscape landscapeHienThi = lstData.get(position);
        String caption = landscapeHienThi.getCaption();
        String tenAnh = landscapeHienThi.getImageName();
        holder.tvCaption.setText(caption);
        String packageName = holder.itemView.getContext().getPackageName();
        @SuppressLint("DiscouragedApi") int imageID = holder.itemView.getResources().getIdentifier(tenAnh, "mipmap", packageName);
        holder.imgViewLand.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvCaption;
        public ImageView imgViewLand;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            this.tvCaption = itemView.findViewById(R.id.textViewCaption);
            this.imgViewLand = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int viTriClicked = getBindingAdapterPosition();
            Landscape phanTuClicked = lstData.get(viTriClicked);
            String tenAnh = phanTuClicked.getImageName();
            String caption = phanTuClicked.getCaption();
            String chuoiTB = " Bạn vừa click vào " + caption;
            Toast.makeText(context, chuoiTB, Toast.LENGTH_SHORT).show();
        }
    }


}
