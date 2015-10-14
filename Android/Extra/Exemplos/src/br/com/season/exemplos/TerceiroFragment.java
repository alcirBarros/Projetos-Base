package br.com.season.exemplos;

import java.util.Arrays;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class TerceiroFragment extends Fragment implements OnItemSelectedListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.outro_fragment, container, false);
		
		Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
		spinner.setAdapter(new ArrayAdapter<Conteudo>(getActivity(), 
				android.R.layout.simple_list_item_1, Arrays.asList(new Conteudo(1, "Item 1"),
						new Conteudo(2, "Item 2"), new Conteudo(4, "Item Outro"))));
		spinner.setOnItemSelectedListener(this);
		
		return view;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		Conteudo conteudo = (Conteudo) arg0.getItemAtPosition(position);
		Toast.makeText(getActivity(), String.valueOf(conteudo.getId()), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {		
	}
}