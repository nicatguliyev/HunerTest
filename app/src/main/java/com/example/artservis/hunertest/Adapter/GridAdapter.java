package com.example.artservis.hunertest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.artservis.hunertest.R;

/**
 * Created by Art Servis on 10/21/2018.
 */

public class GridAdapter  extends BaseAdapter{

    Context context;
    private final int[] images;
    View _View;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
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

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null)
        {
            _View = new View(context);
            _View = layoutInflater.inflate(R.layout.grid_item, null);

            ImageView imageView = _View.findViewById(R.id.imageView);
            imageView.setImageResource(images[i]);

        }

        return _View;
    }
}
