package com.example.lny;

import com.example.lny.helper.DatabaseHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity {
	Button loginButton;
	Button signUpButton;
	DatabaseHandler db;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHandler(getApplicationContext());
        if (db.getRowCount()==1){
        	Intent i = new Intent(StartActivity.this, MainPageActivity.class);
        	startActivity(i);
        	
        	finish();
        	
        }
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.startscreen);
        
        loginButton = (Button) findViewById(R.id.LoginButton);
        signUpButton=(Button)findViewById(R.id.SignUpButton);
        
        loginButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(StartActivity.this,LoginActivity.class);
				startActivity(i);
			}
        	
        });
        signUpButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(StartActivity.this,SignUpActivity.class);
				startActivity(i);
			}
        	
        });    
	}
	
	
}
