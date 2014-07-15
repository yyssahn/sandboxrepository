package com.example.lny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class ChoiceActivity extends Activity {
	Button tutorButton;
	Button studentButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.firstchoicescreen);
       
        
        tutorButton = (Button) findViewById(R.id.TutorButton);
        studentButton = (Button) findViewById(R.id.StudentButton);
        
        tutorButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChoiceActivity.this, TutorCreateActivity.class);
				startActivity(i);
				finish();
			}
        	
        });
        
        studentButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChoiceActivity.this, MainPageActivity.class);
				startActivity(i);
				finish();
			}
        	
        });
	}

}
