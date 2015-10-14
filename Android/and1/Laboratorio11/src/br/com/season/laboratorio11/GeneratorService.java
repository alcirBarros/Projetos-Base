package br.com.season.laboratorio11;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class GeneratorService extends Service {

	private int min = 1;
	private int max = 10;
	
	public void setMinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		timer = new Timer();
		timer.schedule(new GeneratorTask(), 0, 10000);
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		if (timer != null) {
			timer.cancel();
		}
		super.onDestroy();
	}
	 
	@Override
	public IBinder onBind(Intent arg0) {
		return binder;
	}
	
	public int generateNumber() {
		Random r = new Random(System.currentTimeMillis());
		return min + (r.nextInt(max - min));
	}
	
	private IBinder binder = new ServiceBinder();
	private Timer timer;
	
	public class ServiceBinder extends Binder {
		public GeneratorService getInstance() {
			return GeneratorService.this;
		}
	}

	class GeneratorTask extends TimerTask {

		@Override
		public void run() {
			Log.i("Generated number", String.valueOf(generateNumber()));
			Uri notificacao = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			Ringtone toque = RingtoneManager.getRingtone(GeneratorService.this, notificacao);
			
			try {
				toque.play();
			} catch (Exception e) {				
			}
		}
	}
}
