package com.example.me_app_demo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class Login extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //Parse requirement
        // Enable Local Datastore.
        //Parse.enableLocalDatastore(this);
        Parse.initialize(this, "u788FGXOcLeT4OdEwO3yB2HaChNxoTjx9aFS9kUD", "fJzKzjxZrDfQ3PlxsrHVqFaQIkMSlwi9enodHS9q");
        
        //ParseObject testObject = new ParseObject("TestObject");
        //testObject.put("foo", "bar");
        //testObject.saveInBackground();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void tryLogin(View view) {
        // Do something in response to button
      	final Intent intent = new Intent(this, Main_Menue.class);
    	EditText usernameLogin = (EditText) findViewById(R.id.username);
    	EditText passwordLogin = (EditText) findViewById(R.id.password);
    	
    	ParseUser.logInInBackground(usernameLogin.getText().toString(), passwordLogin.getText().toString(), new LogInCallback() {
    		  public void done(ParseUser user, ParseException e) {
    		    if (user != null) {
    		      // Hooray! The user is logged in.
    		    	startActivity(intent);
    		    } else {
    		      // Signup failed. Look at the ParseException to see what happened.
    		    	Log.v("Login","Fehler beim Login");
    		    }
    		  }
    		});
    	
    	
   }
}
