package br.com.season.laboratorio7;

import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

	private Set<Integer> imoveis = new HashSet<Integer>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (savedInstanceState != null) {
			EditText cidade = (EditText) findViewById(R.id.cidade);
			cidade.setText(savedInstanceState.getString("cidade"));
		}
		
		findViewById(R.id.tipo_operacao).setOnClickListener(this);
		findViewById(R.id.tipo_imovel).setOnClickListener(this);
		
		SeekBar seekMin = (SeekBar) findViewById(R.id.seekMin);
		seekMin.setOnSeekBarChangeListener(this);
		SeekBar seekMax = (SeekBar) findViewById(R.id.seekMax);
		seekMax.setOnSeekBarChangeListener(this);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		EditText cidade = (EditText) findViewById(R.id.cidade);
		outState.putString("cidade", cidade.getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		//Toast.makeText(this, "Opa, funcionou!", Toast.LENGTH_SHORT).show();
		if (view.getId() == R.id.tipo_operacao) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Tipo de Operação")
				.setSingleChoiceItems(new CharSequence[] { "Alugar", "Comprar" }, 0, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int option) {
						TextView operacao = (TextView) findViewById(R.id.operacao);
						operacao.setText(option == 0 ? "Alugar" : "Comprar");
					}
				})
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();					
					}
				}).show();	
		} else if (view.getId() == R.id.tipo_imovel) {
			final CharSequence[] tiposImovel = new CharSequence[] { "Casa", "Apartamento", "Kitnet" };
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Tipo de Imóvel")
				.setMultiChoiceItems(tiposImovel, new boolean[] {false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						if (isChecked) {
							imoveis.add(which);
						} else {
							imoveis.remove(which);
						}						
					}
				})
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialogInterface, int which) {
						TextView textView = (TextView) findViewById(R.id.imovel);
						StringBuilder str = new StringBuilder();
						for (Integer i : imoveis) {
							str.append(tiposImovel[i]).append(", ");
						}
						textView.setText(str.substring(0, str.length() - 2));
					}
				}).show();
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		if (seekBar.getId() == R.id.seekMax) {
			TextView textView = (TextView) findViewById(R.id.labelMax);
			textView.setText("Valor Máximo: " + progress);
		} else if (seekBar.getId() == R.id.seekMin) {
			TextView textView = (TextView) findViewById(R.id.labelMin);
			textView.setText("Valor Mínimo: " + progress);
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {		
	}
}
