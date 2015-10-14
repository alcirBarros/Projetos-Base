package br.com.season.laboratorio15;

import com.google.analytics.tracking.android.EasyTracker;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText intervalo;
	private Button botaoDisparar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		intervalo = (EditText) findViewById(R.id.intervalo);
		botaoDisparar = (Button) findViewById(R.id.botao_disparar);
		botaoDisparar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
				Intent i = new Intent(MainActivity.this, AlarmReceiver.class);
				PendingIntent pending = PendingIntent.getBroadcast(MainActivity.this, 
						0, i, 0);
				manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 
						Integer.valueOf(intervalo.getText().toString()) * 1000, pending);
			}
		});
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		EasyTracker.getInstance().activityStart(this);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		EasyTracker.getInstance().activityStop(this);
	}
}
