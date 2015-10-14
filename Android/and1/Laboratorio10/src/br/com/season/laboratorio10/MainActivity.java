package br.com.season.laboratorio10;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        List<Imovel> imoveis = new ArrayList<Imovel>();
        imoveis.add(new Imovel().setWebsite("http://www.season.com.br").setEmail("season@season.com.br")
        		.setTelefone("99999999").setTitulo("Apartamento"));
        imoveis.add(new Imovel().setWebsite("http://www.season.com.br").setEmail("season@season.com.br")
        		.setTelefone("99999999").setTitulo("Casa"));
        imoveis.add(new Imovel().setWebsite("http://www.season.com.br").setEmail("season@season.com.br")
        		.setTelefone("99999999").setTitulo("Sítio"));
        
        setListAdapter(new ArrayAdapter<Imovel>(this, android.R.layout.simple_list_item_1, imoveis));
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	Intent intent = new Intent(this, DetalhesActivity.class);
    	
    	Imovel imovel = (Imovel) getListAdapter().getItem(position);
    	intent.putExtra("imovel", imovel);
    	
    	startActivity(intent);
    }
}
