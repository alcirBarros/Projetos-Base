package br.com.season.laboratorio2;

import java.io.IOException;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

public class MainActivity extends Activity {
	
	public static final String SENDER_ID = "número do projeto";
	
	private GoogleCloudMessaging gcm;
	private String regId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != ConnectionResult.SUCCESS) {
			Toast.makeText(this, "É cara... não vai rolar...", Toast.LENGTH_SHORT).show();
			finish();
			return;
		}

		findViewById(R.id.botaoRegistrar).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						registrarDispositivo();
					}
				});
	}

	protected void registrarDispositivo() {
		new AsyncTask<Void, Void, String>() {

			@Override
			protected String doInBackground(Void... params) {
				try {
					SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
					if (prefs.contains("push_key")) {
						return prefs.getString("push_key", "");
					}
					
					if (gcm == null) {
						gcm = GoogleCloudMessaging.getInstance(MainActivity.this);
					}
					regId = gcm.register(SENDER_ID);
					
					Log.i("DEVICE_ID", regId);
					
					return regId;
				} catch (IOException e) {
					Log.e("MainActivity", e.getMessage(), e);
					return "ERROR: " + e.getMessage();
				}
			}
			
			@Override
			protected void onPostExecute(String result) {
				Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
				((EditText) findViewById(R.id.regId)).setText(result);
				
				if (!result.startsWith("ERROR")) {
					SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
					prefs.edit().putString("push_key", result).commit();
				}
			}
		}.execute();		
	}
}
