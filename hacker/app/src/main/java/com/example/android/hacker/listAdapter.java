package com.example.android.hacker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.content.Context.MODE_PRIVATE;
import static com.example.android.hacker.R.id.imageView;
import static com.example.android.hacker.R.id.vid;
//import static com.example.android.hacker.favourites.favs;


/**
 * Created by Ninaad on 7/26/2017.
 */

public class listAdapter extends BaseAdapter {
    Context context;
   private ArrayList<String>title;
    private ArrayList<String> pay;
    private ArrayList<String> upvote;
    private ArrayList<String> video;
    String cat;


    public listAdapter(Context context,ArrayList<String> title,ArrayList<String> pay,ArrayList<String> upvote,ArrayList<String> video,String cat)
    {
     this.context=context;
        this.title=title;
        this.pay=pay;
        this.upvote=upvote;
        this.video=video;
        this.cat=cat;
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return title.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View list;
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {

            list = new View(context);
            list = inflater.inflate(R.layout.list_black, null);
            TextView titles = (TextView) list.findViewById(R.id.list_content);
            TextView pays = (TextView)list.findViewById(R.id.pay);
            TextView upvotes=(TextView)list.findViewById(R.id.votes);
            TextView videos=(TextView)list.findViewById(R.id.vid);
            TextView categol=(TextView)list.findViewById(R.id.category);
            final Button button=(Button)list.findViewById(R.id.fav);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                //favs.add()
                button.setBackgroundResource(R.drawable.starred);

                }
            });
           // TextView upvote=(TextView)list.findViewById(R.id.votes);
            titles.setText(title.get(position));
            pays.setText(pay.get(position));
           upvotes.setText(upvote.get(position)+" upvotes");
            videos.setText(video.get(position));
            categol.setText(cat);


        } else {
            list = (View) convertView;
            
        }

        return list;
    }
}
