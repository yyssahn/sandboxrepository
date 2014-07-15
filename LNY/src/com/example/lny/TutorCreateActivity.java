package com.example.lny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class TutorCreateActivity extends Activity {
	Button confirmButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.createtutorscreen);
        
       confirmButton = (Button) findViewById(R.id.createtutorbutton);
        confirmButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(TutorCreateActivity.this, TutorConfirmActivity.class);
				startActivity(i);
			}
        	
        });
        
	}

}
