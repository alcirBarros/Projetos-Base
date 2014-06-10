package br.com.season.laboratorio2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

public class PushReceiver extends WakefulBroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		String str = bundle.getString("mensagem");
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}
}
