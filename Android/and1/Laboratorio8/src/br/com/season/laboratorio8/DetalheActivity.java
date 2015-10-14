package br.com.season.laboratorio8;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class DetalheActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (getResources().getConfiguration().orientation == 
				Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}
		
		setContentView(R.layout.activity_detalhe);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String str = extras.getString("value");
			TextView textView = (TextView) findViewById(R.id.textoDetalhe);
			textView.setText(str);
		}
	}
}
