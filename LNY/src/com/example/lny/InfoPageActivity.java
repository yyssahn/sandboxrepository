package com.example.lny;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.lny.LoginActivity.LoginUser;
import com.example.lny.helper.DatabaseHandler;
import com.example.lny.helper.JSONParser;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class InfoPageActivity extends Activity {
	String id;
	EditText nameinput;
	EditText aboutinput;
	EditText degreeinput;
	Button submit;
	DatabaseHandler db;

	private static final String TAG_SUCCESS = "success";
    private static String updateURL = "http://104.131.141.54/lny_project/update_user.php";
	JSONParser jsonparser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.infopage);
        jsonparser = new JSONParser();
        db = new DatabaseHandler(getApplicationContext());
        id = db.getUserid();
        nameinput = (EditText) findViewById(R.id.nameInput);
        aboutinput = (EditText) findViewById(R.id.aboutInput);
        degreeinput = (EditText) findViewById(R.id.degreeInput);
        submit = (Button) findViewById(R.id.submitchange);
        
        
        submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new UpdateUser().execute();
			}
        });
        }
        
	class UpdateUser extends AsyncTask<String, String, String> {
		 
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
         }
 
        /**
         * Creating product
         * */
        @Override
		protected String doInBackground(String... args) {
        	
        	String name = nameinput.getText().toString();
            String degree = degreeinput.getText().toString();
            String about = aboutinput.getText().toString();
            
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            
            params.add(new BasicNameValuePair("email", id));
            params.add(new BasicNameValuePair("name", name));
            
            params.add(new BasicNameValuePair("degree", degree));
            params.add(new BasicNameValuePair("about", about));
            
            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonparser.makeHttpRequest(updateURL,
                    "POST", params);
            Log.d("some error", "place 3");
            
            // check log cat fro response
            Log.d("Create Response", json.toString());
 
            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);
 
                if (success == 1) {
                //    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                //    startActivity(i);
 
                //    finish();
                	
                } else {
                    // failed to create product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
 
            return null;
        }
 
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        @Override
		protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
        //    pDialog.dismiss();
        }
 
    }	
}

