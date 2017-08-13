package com.example.android.hacker;

import android.content.Intent;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.hacker.R.drawable.c;

public class login extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
Boolean ispressed=true;
    Button signupButton;
    TextView textView;
    //true means login  state is active
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView textView=(TextView)findViewById(R.id.options);
        Button signupButton=(Button)findViewById(R.id.button);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            if(ispressed==true) {
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);

            }
            if(ispressed==false)
            {
                //means sign up state is active
            }
        }
        if(view.getId()==R.id.options)
        {

            textView.setTextColor(getResources().getColor(R.color.colorAccent));
            if(ispressed)
            {
                ispressed=false;
                signupButton.setText("Sign up");
                textView.setText("Or, Log in");
            }
            if(ispressed==false)
            {
                ispressed=true;
                signupButton.setText("Login");
                textView.setText("Or, Signup");
            }
        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }
}
