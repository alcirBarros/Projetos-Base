package br.com.season.laboratorio11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("SMSReceiver", "Mensagem recebida!");

		Intent i = new Intent(context, GeneratorService.class);
		context.startService(i);
	}

}
