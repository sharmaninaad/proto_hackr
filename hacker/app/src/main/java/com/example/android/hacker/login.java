package com.example.android.hacker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import static android.R.attr.password;
import static android.R.attr.x;
import static com.example.android.hacker.R.drawable.c;

public class login extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    Boolean ispressed=true;
    Button signupButton;
    TextView textView;
    EditText position;
    Context context;
    EditText mails;
    EditText username1;
    EditText password1;
    //true means login  state is active
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        textView=(TextView)findViewById(R.id.options);
        signupButton=(Button)findViewById(R.id.button);
        position=(EditText) findViewById(R.id.location);
        mails=(EditText) findViewById(R.id.mail);
        username1=(EditText) findViewById(R.id.username);
        password1=(EditText) findViewById(R.id.password);
        context=getApplicationContext();
        signupButton.setOnClickListener(this);
        textView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            
            if(ispressed) {

                Intent startIntent = new Intent(login.this, MainActivity.class);
                startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                login.this.startActivity(startIntent);



            }
            if(ispressed==false)
            {
                //means sign up state is active

               ParseUser user = new ParseUser();

                user.setUsername(username1.getText().toString());
                user.setPassword(password1.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {

                            Log.i("Signup", "Successful");

                        } else {

                            Toast.makeText(login.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                Intent startIntent = new Intent(login.this, MainActivity.class);
                startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               login.this.startActivity(startIntent);

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
                position.setVisibility(view.VISIBLE);
                mails.setVisibility(view.VISIBLE);

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
