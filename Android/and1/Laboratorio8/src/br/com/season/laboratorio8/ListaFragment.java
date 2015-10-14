package br.com.season.laboratorio8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaFragment extends ListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		String[] itens = new String[] { "Um", "Dois", "Três", "Quatro", "Cinco", "Seis" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itens);
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		DetalheFragment detalheFragment = (DetalheFragment) getFragmentManager().findFragmentById(R.id.detalheFragment);
		if (detalheFragment != null) {
			detalheFragment.setText(item);
		} else {
			Intent intent = new Intent(getActivity(), DetalheActivity.class);
			intent.putExtra("value", item);
			startActivity(intent);
		}
	}
}
