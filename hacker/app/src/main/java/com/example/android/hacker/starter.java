package com.example.android.hacker;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
/**
 * Created by Ninaad on 8/13/2017.
 */

public class starter extends Application{

    @Override

    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("54c54cd0ca77ad57f0b1031ad2fd79bac4336fb9")
                .clientKey("a058d00a5aaf5d81c923b237903dfe8eccbaf9d9")
                .server("http://ec2-18-220-197-15.us-east-2.compute.amazonaws.com:80/parse")
                .build()
        );


        //ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);


    }

}
