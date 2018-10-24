package com.example.artservis.hunertest.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artservis.hunertest.R;

import java.util.ArrayList;

/**
 * Created by Art Servis on 10/24/2018.
 */

public class ServiceListAdapter extends BaseAdapter {

    Context context;
    private final ArrayList<String> serviceNames;
    private final ArrayList<Integer> serviceImages;
    LayoutInflater layoutInflater;

    public  ServiceListAdapter(Context context, ArrayList<String> serviceNames, ArrayList<Integer> serviceImages) {
        this.context = context;
        this.serviceNames = serviceNames;
        this.serviceImages = serviceImages;
    }

    @Override
    public int getCount() {
        return serviceNames.size();
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
        TextView serviceNameTxt;
        ImageView serviceImage;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.service_list_item, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.serviceNameTxt = view.findViewById(R.id.serviceName);
            viewHolder.serviceImage = view.findViewById(R.id.serviceImg);


            view.setTag(viewHolder);

        }

        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.serviceNameTxt.setText(serviceNames.get(i));
        viewHolder.serviceImage.setImageResource(serviceImages.get(i));

        //Typeface tfc = Typeface.createFromAsset(context.getAssets(), "fonts/HELR45W.ttf");
       // viewHolder.serviceNameTxt.setTypeface(tfc);

        return view;
    }
}
