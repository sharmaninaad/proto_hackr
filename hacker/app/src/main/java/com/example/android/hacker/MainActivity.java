package com.example.android.hacker;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.id;

import static android.os.Build.VERSION_CODES.M;
import static android.transition.Fade.IN;

public class MainActivity extends AppCompatActivity {
    final Activity activity1 = this;
    WebView webView ;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        webView.getSettings().setJavaScriptEnabled(true); // enable javascript


        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity1, description, Toast.LENGTH_SHORT).show();
            }
        });



        switch (item.getItemId()) {
            case R.id.chat:
                webView .loadUrl("https://hackr.io/tutorials/learn-android-development/chat");
                setContentView(webView );
                return true;


            case R.id.buddy:
                webView .loadUrl("https://hackr.io/tutorial/android-app-development-by-stanford/buddy");
                setContentView(webView );
                return true;



            default:

                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database=this.openOrCreateDatabase("favourites",MODE_PRIVATE,null);
        ListView listView=(ListView) findViewById(R.id.my_list);

       // ArrayList<String> topics=new ArrayList<>();

        final String topics[]= {
                "Android Development",
                "Web Development",
                "C",
                "Java",
                "Git",
                "Django",
                "Kotlin",
                "MySQL",
                "Ansible",
                "Arduino",
                "Data Science",
                "Go",
                "Grails",

                "PHP",
                "Python",

                "Javascript",

                "Photoshop",
                "R"

        };


        int images[]={
                R.drawable.android1,
                R.drawable.webd,
                R.drawable.c1,
                R.drawable.java1,
                R.drawable.git1,
                R.drawable.django1,
                R.drawable.android1,
                R.drawable.sql1,
                R.drawable.ansible,
                R.drawable.arduino,
                R.drawable.datasc,
                R.drawable.go,
                R.drawable.grails,
                R.drawable.php,
                R.drawable.python,
                R.drawable.js,
                R.drawable.photoshop,
                R.drawable.r
        };



        if(images.length==topics.length) {
            GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), images, topics);


            listView.setAdapter(gridAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            Toast.makeText(MainActivity.this, topics[0], Toast.LENGTH_SHORT).show();
                            Intent this_intent = new Intent(getApplicationContext(), app.class);
                            startActivity(this_intent);


                    }
                }
            });

        }
        else
            {
                Toast.makeText(this, "lllll", Toast.LENGTH_SHORT).show();
            }
    }

}
