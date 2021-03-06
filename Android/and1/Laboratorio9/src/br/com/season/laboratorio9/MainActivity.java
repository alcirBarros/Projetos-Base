package br.com.season.laboratorio9;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        
        Tab tab = actionBar.newTab().setText("Primeira")
        		.setTabListener(new TabListener<PrimeiroFragment>(this, "primeiro", 
        				PrimeiroFragment.class));
        actionBar.addTab(tab);
        
        tab = actionBar.newTab().setText("Segunda")
        		.setTabListener(new TabListener<SegundoFragment>(this, "segundo", 
        				SegundoFragment.class));
        actionBar.addTab(tab);
        
        tab = actionBar.newTab().setText("Terceira")
        		.setTabListener(new TabListener<TerceiroFragment>(this, "terceiro", 
        				TerceiroFragment.class));
        actionBar.addTab(tab);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
