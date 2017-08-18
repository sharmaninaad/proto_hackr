package com.example.android.hacker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import static android.R.id.list;
import static com.example.android.hacker.R.drawable.r;

/**
 * Created by Ninaad on 8/18/2017.
 */

public class adapter extends BaseExpandableListAdapter {
    List<String> parent;
    HashMap<String,List<String>> childs;
    Context context;
    public adapter(Context context, List<String> category,
                   HashMap<String, List<String>> tutorials)
    {
        childs=tutorials;
        parent=category;
        this.context=context;
    }


    @Override
    public int getGroupCount() {
        return parent.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childs.get(parent.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return parent.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childs.get(parent.get(i))
                .get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view==null){
        LayoutInflater Inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view= Inflater.inflate(R.layout.list_heads,null);
        }
        TextView group= (TextView) view.findViewById(R.id.head);
        group.setText(getGroup(i)+"");
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.list_item,null);

        }
        TextView tutor=(TextView)view.findViewById(R.id.tut);
        tutor.setText(""+getChild(i, i1));
        return view;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
