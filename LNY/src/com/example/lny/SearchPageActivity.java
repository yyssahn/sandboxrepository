package com.example.lny;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class SearchPageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.searchtutorscreen);
	}

}
