package br.com.season.exemplos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.botao1).setOnClickListener(this);
		findViewById(R.id.botao2).setOnClickListener(this);
		findViewById(R.id.botao3).setOnClickListener(this);
		
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, new PrimeiroFragment())
				.commit();
	}

	@Override
	public void onClick(View v) {
		FragmentTransaction t = getSupportFragmentManager().beginTransaction();
		switch (v.getId()) {
		case R.id.botao1:
			t.replace(R.id.container, new PrimeiroFragment());
			break;
		case R.id.botao2:
			t.replace(R.id.container, new SegundoFragment());
			break;
		case R.id.botao3:
			t.replace(R.id.container, new TerceiroFragment());
			break;
		}
		t.commit();		
	}
}
