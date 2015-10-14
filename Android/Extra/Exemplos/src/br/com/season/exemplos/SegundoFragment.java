package br.com.season.exemplos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SegundoFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, container, false);
		
		final TextView tv = (TextView) view.findViewById(R.id.texto);
		tv.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				
				tv.setVisibility(View.GONE);
				Animation animFadeOut = AnimationUtils.loadAnimation(getActivity(),
                        R.anim.splash_fadeout);
				tv.startAnimation(animFadeOut);
				
			}
		}, 1000);
		
		return view;
	}
}
