package br.com.season.laboratorio13;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new NewsTask().execute("http://api.ihackernews.com/page");
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//super.onListItemClick(l, v, position, id);
		Noticia n = (Noticia) getListView().getAdapter().getItem(position);
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(n.getUrl()));
		startActivity(i);
	}
	
	private class NewsTask extends AsyncTask<String, Void, List<Noticia>> {

		@Override
		protected List<Noticia> doInBackground(String... params) {
			try {
				URL url = new URL(params[0]);
				InputStream in = url.openStream();
				String content = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
				in.close();
				JSONObject json = new JSONObject(content);
				JSONArray noticias = json.getJSONArray("items");
				List<Noticia> retorno = new ArrayList<Noticia>();
				for (int i = 0; i < noticias.length(); i++) {
					JSONObject noticia = noticias.getJSONObject(i);
					Noticia n = new Noticia();
					n.setTitulo(noticia.getString("title"));
					n.setUrl(noticia.getString("url"));
					retorno.add(n);
				}
				return retorno;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}			
		}
		
		@Override
		protected void onPostExecute(List<Noticia> result) {
			super.onPostExecute(result);
			ArrayAdapter<Noticia> adapter = new ArrayAdapter<Noticia>(MainActivity.this, 
					android.R.layout.simple_list_item_1, result);
			getListView().setAdapter(adapter);
		}
	}
}
