package br.com.season.laboratorio9;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class TabListener<T extends Fragment> implements ActionBar.TabListener {

	private Activity activity;
	private String tag;
	private Class<T> clazz;
	private Fragment fragment;

	public TabListener(Activity activity, String tag, Class<T> clazz) {
		this.activity = activity;
		this.tag = tag;
		this.clazz = clazz;		
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		if (fragment == null) {
			fragment = Fragment.instantiate(activity, clazz.getName());
			ft.add(android.R.id.content, fragment, tag);
		} else {
			ft.attach(fragment);
		}
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (fragment != null) {
			ft.detach(fragment);
		}		
	}

}
