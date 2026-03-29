package com.vpt.testlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    public List<CustomData> items;
    public Context context;
    public LayoutInflater inflater;

    public CustomAdapter(Context context, List<CustomData> items) {
        this.context = context;
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    public static class ViewHolder{
        public TextView tvText1;
        public TextView tvText2;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.tvText1 = convertView.findViewById(R.id.tvText1);
            holder.tvText2 = convertView.findViewById(R.id.tvText2);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvText1.setText(((CustomData) this.getItem(position)).getText1());
        holder.tvText2.setText(((CustomData) this.getItem(position)).getText2());
        return convertView;
    }
}
