package com.example.lesson3_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<String>List;
    private LayoutInflater inflater;

    public  TaskAdapter(Context context, List<String>List){
        this.inflater = LayoutInflater.from(context);
        this.List = List;

    }
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_task,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.txtTitle.setText(List.get(position));
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.title_txt);
        }
    }

}
