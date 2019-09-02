package com.example.walkalarm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.walkalarm.Classes.Alarm;
import com.example.walkalarm.R;

import java.util.List;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.MyViewHolder>{

    private List<Alarm> alarmList;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView statusTextView,daysTextView,timeTextView,soundTextView,stepsTextView;

        public MyViewHolder(View view)
        {
            super(view);
            statusTextView=view.findViewById(R.id.statusTextView);
            daysTextView=view.findViewById(R.id.daysTextView);
            timeTextView=view.findViewById(R.id.timeTextView);
            soundTextView=view.findViewById(R.id.soundTextView);
            stepsTextView=view.findViewById(R.id.stepsTextView);
        }
    }

    public AlarmAdapter(List<Alarm> alarmList)
    {
        this.alarmList=alarmList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_alarm_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Alarm alarm=alarmList.get(position);
        holder.statusTextView.setText(alarm.getStatusTextView());
        holder.daysTextView.setText(alarm.getDaysTextView());
        holder.timeTextView.setText(alarm.getTimeTextView());
        holder.soundTextView.setText(alarm.getSoundTextView());
        holder.stepsTextView.setText(alarm.getStepsTextView());
    }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }
}
