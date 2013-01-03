package com.example.pushnot;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView regNumber = (TextView)findViewById(R.id.textView1);
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		if (GCMRegistrar.isRegistered(this)) {
			Log.d("info", GCMRegistrar.getRegistrationId(this));
		}
		final String regId = GCMRegistrar.getRegistrationId(this);
		regNumber.setText(regId);
		if (regId.equals("")) {
			// replace this with the project ID
			GCMRegistrar.register(this, "927896247221");
			Log.d("info", GCMRegistrar.getRegistrationId(this));
			regNumber.setText(regId);
		} else {
			Log.d("info", "already registered as" + regId);
		}
 }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
