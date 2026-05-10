package com.vpt.vieccanlam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Task> tasks = new ArrayList<>();
    private Context context;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.tvName.setText(tasks.get(position).getName());
        holder.tvMessage.setText(tasks.get(position).getMessage());
        holder.tvDate.setText(tasks.get(position).getDate());
        holder.tvPriority.setText(tasks.get(position).getPriority());
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{
        private TextView tvDate, tvMessage, tvName, tvPriority;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvDate = itemView.findViewById(R.id.date);
            this.tvMessage = itemView.findViewById(R.id.message);
            this.tvName = itemView.findViewById(R.id.name);
            this.tvPriority = itemView.findViewById(R.id.priority);
        }
    }
}
