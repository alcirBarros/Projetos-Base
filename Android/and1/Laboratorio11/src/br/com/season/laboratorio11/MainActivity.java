package br.com.season.laboratorio11;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.season.laboratorio11.GeneratorService.ServiceBinder;

public class MainActivity extends Activity implements OnClickListener, ServiceConnection {

	private EditText minimo;
	private EditText maximo;
	private Button redefinir;
	private Button gerar;
	
	private ServiceBinder binder;
	private boolean conectado = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		minimo = (EditText) findViewById(R.id.minimo);
		maximo = (EditText) findViewById(R.id.maximo);
		redefinir = (Button) findViewById(R.id.redefinir);
		redefinir.setOnClickListener(this);
		gerar = (Button) findViewById(R.id.gerar);
		gerar.setOnClickListener(this);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Intent i = new Intent(this, GeneratorService.class);
		bindService(i, this, BIND_AUTO_CREATE);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		if (conectado) {
			unbindService(this);
			conectado = false;
		}
		stopService(new Intent(this, GeneratorService.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == gerar.getId()) {
			int numero = binder.getInstance().generateNumber();
			Toast.makeText(this, String.valueOf(numero), Toast.LENGTH_SHORT).show();
		} else if (v.getId() == redefinir.getId()) {
			binder.getInstance().setMinMax(Integer.valueOf(minimo.getText().toString()), 
					Integer.valueOf(maximo.getText().toString()));
		}
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		conectado = true;
		binder = (ServiceBinder) service;
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		conectado = false;		
	}

}
