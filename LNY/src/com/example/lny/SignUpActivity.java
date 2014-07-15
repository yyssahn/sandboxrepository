package com.example.lny;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.lny.helper.JSONParser;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {
	  // JSON Response node names
	JSONParser jsonParser = new JSONParser();
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";
	
	private static String TAG = "SignUpActivity";
    private EditText idInput;
	private EditText passwordInput;
	private static String KEY_SUCCESS = "success";
    private static String KEY_ERROR = "error";
    private static String KEY_ERROR_MSG = "error_msg";
    private static String KEY_UID = "uid";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    private static String register_tag = "register";
    
    private static String registerURL = "http://104.131.141.54/lny_project/create_user.php";
	Button registerButton;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.signupscreen);
        idInput = (EditText) findViewById(R.id.SignupId);
        passwordInput=(EditText) findViewById(R.id.SignupPW);
        registerButton = (Button) findViewById(R.id.RegisterButton);
        registerButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

		        if (idInput.getText().toString().length()==0 || passwordInput.getText().toString().length()==0){
		        	Toast.makeText(getApplicationContext(), "id or password is not inputted", Toast.LENGTH_SHORT).show();
		            
		        }else{

				String email = idInput.getText().toString();
				
				String password = passwordInput.getText().toString();
				new CreateNewUser().execute();   
		        }
			}
        	
        	
        });
        
    }
	class CreateNewUser extends AsyncTask<String, String, String> {
		 
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
        	Log.d("some error", "place 1");
            String email = idInput.getText().toString();
            String password = passwordInput.getText().toString();
            Log.d("some error", email);
            Log.d("some error", password);
            
            
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            
            params.add(new BasicNameValuePair("email", email));
            params.add(new BasicNameValuePair("password", password));
            Log.d("some error", params.toString());
            
            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(registerURL,
                    "POST", params);
            Log.d("some error", "place 3");
            
            // check log cat fro response
            Log.d("Create Response", json.toString());
 
            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);
 
                if (success == 1) {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
 
                    finish();
                	
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
