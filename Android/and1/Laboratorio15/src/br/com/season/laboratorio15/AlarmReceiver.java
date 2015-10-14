package br.com.season.laboratorio15;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		NotificationManager manager = (NotificationManager) 
				context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent i = new Intent(context, SegundaActivity.class);
		PendingIntent pending = PendingIntent.getActivity(context, 0, i, 0);
		
		Notification notificacao = new NotificationCompat.Builder(context)
			.setSmallIcon(android.R.drawable.ic_dialog_info)
			.setTicker("Opa! Notificação!")
			.setContentTitle("Notificação Importante!")
			.setContentText("Opa, nem tão importante assim...")
			.setWhen(System.currentTimeMillis())
			.setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
			.setContentIntent(pending)
			.setAutoCancel(true)
			.build();
		
		manager.notify(1, notificacao);
	}

}
