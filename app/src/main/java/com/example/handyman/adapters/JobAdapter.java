package com.example.handyman.adapters;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.handyman.R;
import com.example.handyman.job.Job;

import java.util.List;

public class JobAdapter extends BaseAdapter {

    List<Job> adapterJobList;

    public JobAdapter(List<Job> adapterJobList) {
        this.adapterJobList = adapterJobList;
    }

    @Override
    public int getCount() {
        return adapterJobList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterJobList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_jobs, parent, false);
        }

        TextView txtViewCategory = convertView.findViewById(R.id.textViewJob);
        Job job = adapterJobList.get(position);
        String title = job.getTitle();
        txtViewCategory.setText(title != null ? title : "No Title");
        txtViewCategory.setGravity(Gravity.CENTER_VERTICAL);
        return convertView;
    }

    public void updateData(List<Job> newJobs) {
        adapterJobList.clear();
        adapterJobList.addAll(newJobs);
        notifyDataSetChanged();
    }

}
