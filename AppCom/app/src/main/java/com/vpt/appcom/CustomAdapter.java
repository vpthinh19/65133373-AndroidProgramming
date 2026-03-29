package com.vpt.appcom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<Data> datas;
    private Context context;

    public CustomAdapter(List<Data> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.item_recycle_view, parent, false);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvPrice = convertView.findViewById(R.id.tvPrice);
            holder.imgAvatar = convertView.findViewById(R.id.imgAvatar);
            holder.tvDescription = convertView.findViewById(R.id.tvDescription);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvName.setText(((Data) this.getItem(position)).getName());
        holder.tvPrice.setText(((Data) this.getItem(position)).getPrice());
        holder.tvDescription.setText(((Data) this.getItem(position)).getDescription());
        holder.imgAvatar.setImageResource(((Data) this.getItem(position)).getAvatar());
        return convertView;
    }
    static final class ViewHolder{
        public TextView tvName;
        public TextView tvPrice;
        public ImageView imgAvatar;
        public TextView tvDescription;
    }
}
