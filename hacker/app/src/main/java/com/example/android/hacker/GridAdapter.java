package com.example.android.hacker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ninaad on 7/25/2017.
 */

public class GridAdapter extends BaseAdapter {

    private Context context;
    private final int[] res_ids;
    private final String[] texts;
    public GridAdapter(Context context,int[] res_ids,String[] texts ){
        this.context=context;
        this.res_ids=res_ids;
        this.texts=texts;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(context);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(getItem(position).toString());
            imageView.setImageResource(res_ids[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }



    @Override
    public Object getItem(int position) {
        return texts[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return texts.length;
    }
}
