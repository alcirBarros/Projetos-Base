package br.com.season.laboratorio14;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	private DatabaseHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		helper = new DatabaseHelper(this);
		
		atualizaLista();
	}
	
	@Override
	protected void onResume() {		
		super.onResume();
		atualizaLista();
	}
	
	@Override
	protected void onDestroy() {
		helper.close();
		super.onDestroy();
	}
	
	private void atualizaLista() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		boolean exibir = prefs.getBoolean("exibir", true);
		
		ArrayAdapter<Tarefa> adapter = new ArrayAdapter<Tarefa>(this, android.R.layout.simple_list_item_1,
				exibir ? helper.lerTodas() : helper.lerPendentes());
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if (item.getItemId() == R.id.action_adicionar) {
			Intent i = new Intent(this, NovaTarefaActivity.class);
			startActivity(i);
		} else if (item.getItemId() == R.id.action_exibir) {
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
			boolean exibir = prefs.getBoolean("exibir", true);
			prefs.edit().putBoolean("exibir", !exibir).commit();
			atualizaLista();
		}
		return true;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Tarefa tarefa = (Tarefa) getListAdapter().getItem(position);
		Intent i = new Intent(this, EditarTarefaActivity.class);
		i.putExtra("tarefa", tarefa);
		startActivity(i);
	}
}
