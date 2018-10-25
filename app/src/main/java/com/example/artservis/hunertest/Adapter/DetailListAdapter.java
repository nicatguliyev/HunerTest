package com.example.artservis.hunertest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artservis.hunertest.Model.DetailModel;
import com.example.artservis.hunertest.R;

import java.util.ArrayList;

/**
 * Created by Art Servis on 10/25/2018.
 */

public class DetailListAdapter extends BaseAdapter {

    Context context;
    private  final ArrayList<DetailModel> details;
    LayoutInflater layoutInflater;


    public DetailListAdapter(Context context, ArrayList<DetailModel> details) {
        this.context = context;
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.size();
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
        TextView priceTxt;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        DetailListAdapter.ViewHolder viewHolder;

        if(view == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.detail_list_item, viewGroup, false);

            viewHolder = new DetailListAdapter.ViewHolder();
            viewHolder.serviceNameTxt = view.findViewById(R.id.serviceName);
            viewHolder.serviceImage = view.findViewById(R.id.serviceImg);
            viewHolder.priceTxt = view.findViewById(R.id.priceTxt);


            view.setTag(viewHolder);

        }

        else
        {
            viewHolder = (DetailListAdapter.ViewHolder) view.getTag();
        }

        viewHolder.serviceNameTxt.setText(details.get(i).getDetailName());
        viewHolder.serviceImage.setImageResource(details.get(i).getDetailImg());
        viewHolder.priceTxt.setText(details.get(i).getPrice());

        //Typeface tfc = Typeface.createFromAsset(context.getAssets(), "fonts/HELR45W.ttf");
        // viewHolder.serviceNameTxt.setTypeface(tfc);

        return view;

    }
}
