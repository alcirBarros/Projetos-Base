package br.com.season.laboratorio8;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetalheFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.detalhe, container, false);
		return view;
	}
	
	public void setText(String text) {
		TextView textView = (TextView) getView().findViewById(R.id.textoDetalhe);
		textView.setText(text);
	}
}
