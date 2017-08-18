package com.example.android.hacker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import static com.example.android.hacker.favourites.favs;


public class app extends AppCompatActivity {
    /*WebView webView;
    final Activity activity = this;*/

    /*WebView mWebview ;
    ListView listView1;
    ArrayList<String>tutorials;
    ArrayList<String> payment;
    ArrayList<String> voting;
    ArrayList<String> vidd;*/

    ArrayList<String> links;

    /*ArrayList<String>linb;
    ArrayList<String> tutb;
    ArrayList<String> payb;
    ArrayList<String> votb;
    ArrayList<String> vidb;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        List<String> category=new ArrayList<>();

        HashMap<String,List<String>> tutors= new HashMap<>() ;

        List<String> free=new ArrayList<>();
        List<String> paid=new ArrayList<>();

        free.add("Android App development by stanford");
        free.add("Android Material Design Tutorial");
        free.add("Tutorials about development for android");
        free.add("Training for Android developers");

        paid.add("udemy-the complete android n developer course");
        paid.add("android naughat app masterclass");
        paid.add("learn android development");

        links=new ArrayList<>();

        links.add("http://web.stanford.edu/class/cs193a/videos.shtml");
        links.add ("https://www.youtube.com/playlist?list=PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD");
        links.add("http://www.vogella.com/tutorials/android.html");
        links.add( "https://developer.android.com/training/index.html");
        links.add("https://www.udemy.com/complete-android-n-developer-course/learn/v4/?siteID=jU79Zysihs4-wKAeEmL_pzRJcuUc.XhRxw&LSNPUBID=jU79Zysihs4");
        links.add("https://www.udemy.com/master-android-7-nougat-java-app-development-step-by-step/?siteID=jU79Zysihs4-NOCYgdjOFu6MiiCB1iLB7g&LSNPUBID=jU79Zysihs4");
        links.add("https://www.pluralsight.com/paths/android");

        category.add("Free tutorials");
        category.add("paid tutorial");

        adapter adapt=new adapter(this,category,tutors);

        tutors.put(category.get(0), free); // Header, Child data
        tutors.put(category.get(1), paid);

        ExpandableListView listView=(ExpandableListView)findViewById(R.id.items);
        listView.setAdapter(adapt);
        //tutors.put(listDataHeader.get(2), comingSoon);

        /*tutorials=new ArrayList<>();
        payment=new ArrayList<>();
        voting=new ArrayList<>();
        vidd=new ArrayList<>();


        tutb=new ArrayList<>();
        payb=new ArrayList<>();
        votb=new ArrayList<>();
        linb=new ArrayList<>();
        vidb=new ArrayList<>();




        tutorials.add("Android App development by stanford");
        tutorials.add("Android Material Design Tutorial");
        tutorials.add("Tutorials about development for android");
        tutorials.add("Training for Android developers");
        tutorials.add("Udemy-the complete developer course");


        payment.add("Free");
        payment.add("Free");
        payment.add("Free");
        payment.add("Free");
        payment.add("Paid");


        voting.add("88");
        voting.add("23");
        voting.add("13");
        voting.add("13");
        voting.add("7");

        vidd.add("Video");
        vidd.add("Video");
        vidd.add("Text");
        vidd.add("Text");
        vidd.add("Video");

*/
/*
        mWebview  = new WebView(this);

        webView=new WebView(this);

        // listView1=(ListView)findViewById(R.id.a_list);

        listAdapter la=new listAdapter(activity,tutorials,payment,voting,vidd,"android");

        listView1.setAdapter(la);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript


                mWebview.setWebViewClient(new WebViewClient() {
                    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                        Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
                    }
                });

                mWebview.loadUrl(links.get(position));
                setContentView(mWebview);


            }
    });*/
    }

}
