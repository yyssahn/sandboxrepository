package com.example.lny;

//import com.example.lny.helper.DBHandler;

import com.example.lny.helper.DatabaseHandler;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SpinnerAdapter;

@SuppressLint("NewApi") public class MainPageActivity extends Activity  {
	DatabaseHandler db;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater mInflater = getMenuInflater();
		mInflater.inflate(R.menu.activity_main_actions, menu);
		SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
				R.array.action_list, android.R.layout.simple_spinner_dropdown_item);
		return super.onCreateOptionsMenu(menu);
	}
	Button logoutButton, searchPageButton, createTutorButton, infoButton;
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainpage);
		db = new DatabaseHandler(getApplicationContext());
		final ActionBar actionBar = getActionBar();
		//copy
		//copy end
		logoutButton = (Button)findViewById(R.id.logoutbutton);
		searchPageButton = (Button)findViewById(R.id.searchbutton);
		createTutorButton = (Button)findViewById(R.id.createtutorbutton3);
		infoButton = (Button)findViewById(R.id.infopagebutton);

		logoutButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db.resetTables();
				Intent i = new Intent(MainPageActivity.this, LoginActivity.class);
				startActivity(i);
			}

		});
		searchPageButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainPageActivity.this, SearchPageActivity.class);
				startActivity(i);
			}

		});	        
		createTutorButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainPageActivity.this, TutorCreateActivity.class);
				startActivity(i);
			}

		});
		infoButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainPageActivity.this, InfoPageActivity.class);
				startActivity(i);
			}

		});




	}
	
}
