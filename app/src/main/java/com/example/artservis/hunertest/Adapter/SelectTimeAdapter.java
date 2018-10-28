package com.example.artservis.hunertest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.artservis.hunertest.R;

import java.net.ConnectException;
import java.util.ArrayList;

/**
 * Created by Art Servis on 10/27/2018.
 */

public class SelectTimeAdapter extends BaseAdapter {
    Context context;
    final ArrayList<String> times;
    LayoutInflater inflater;

    public SelectTimeAdapter(Context context, ArrayList<String> times) {
        this.context = context;
        this.times = times;
    }


    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.time_grid_item, viewGroup, false);

        TextView timeText = view.findViewById(R.id.timeTxt);

        timeText.setText(times.get(i));

        return view;
    }
}
