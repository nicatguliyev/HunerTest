package com.example.artservis.hunertest.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artservis.hunertest.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Art Servis on 10/21/2018.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    private final ArrayList<String> months;
    private final ArrayList<String> days;
    View _View;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, ArrayList<String> months, ArrayList<String> days) {
        this.context = context;
        this.months = months;
        this.days = days;
    }

    @Override
    public int getCount() {
        return months.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

     static class ViewHolder{
         TextView dayTxt;
         TextView monthTxt;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if(view == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.grid_item, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.dayTxt = view.findViewById(R.id.dayTxt);
            viewHolder.monthTxt = view.findViewById(R.id.monthTxt);

            view.setTag(viewHolder);

        }

        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.dayTxt.setText(days.get(i));
        viewHolder.monthTxt.setText(months.get(i));

        return view;
    }
}
