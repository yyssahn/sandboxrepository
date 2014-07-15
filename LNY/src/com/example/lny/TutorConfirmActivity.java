package com.example.lny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TutorConfirmActivity extends Activity {
	Button createTutorButton;
	Button doneButton;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tutorconfirmscreen);
        
        createTutorButton = (Button)findViewById(R.id.createtutorbutton2);
        doneButton = (Button) findViewById(R.id.tutordonebutton);
        
        createTutorButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(TutorConfirmActivity.this, TutorCreateActivity.class);
				startActivity(i);
			}
        	
        });
        doneButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(TutorConfirmActivity.this, MainPageActivity.class);
				startActivity(i);
				
			}
        	
        });
        
        
	}
	
	
}
