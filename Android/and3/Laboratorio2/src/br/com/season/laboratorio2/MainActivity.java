package br.com.season.laboratorio2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener,
		SensorEventListener {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensores = manager.getSensorList(Sensor.TYPE_ALL);
		List<SensorLista> lista = new ArrayList<SensorLista>();
		for (Sensor sensor : sensores) {
			lista.add(new SensorLista(sensor.getName(), sensor));
		}
		
		lv = (ListView) findViewById(R.id.lista);
		lv.setAdapter(new ArrayAdapter<SensorLista>(this, android.R.layout.simple_list_item_1,
				lista));
		lv.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		SensorLista item = (SensorLista) lv.getAdapter().getItem(arg2);
		SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		manager.unregisterListener(this);
		manager.registerListener(this, item.getSensor(), SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {				
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		TextView tv = (TextView) findViewById(R.id.conteudo);
		StringBuilder builder = new StringBuilder();
		for (float value : event.values) {
			builder.append(value).append("\n");
		}
		tv.setText(builder.toString());
	}
}
