package br.com.season.laboratorio1;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetService extends IntentService {

	public WidgetService() {
		super("WidgetService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		try {
			URL url = new URL("http://api.ihackernews.com/page");
			InputStream in = url.openStream();
			String conteudo = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
			in.close();
			JSONObject json = new JSONObject(conteudo);
			JSONArray noticias = json.getJSONArray("items");
			List<Noticia> n = new ArrayList<Noticia>();
			for (int i = 0; i < noticias.length(); i++) {
				JSONObject jsonObject = noticias.getJSONObject(i);
				Noticia noticia = new Noticia();
				noticia.setTitulo(jsonObject.getString("title"));
				noticia.setUrl(jsonObject.getString("url"));
				n.add(noticia);
			}
			
			ComponentName referencia = new ComponentName(this, AppWidget.class);
			RemoteViews views = new RemoteViews(getPackageName(), R.layout.widget);
			
			Noticia noticiaAleatoria = n.get(new Random(System.currentTimeMillis()).nextInt(n.size()));
			views.setTextViewText(R.id.titulo, noticiaAleatoria.getTitulo());
			
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(noticiaAleatoria.getUrl()));
			PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
			views.setOnClickPendingIntent(R.id.titulo, pendingIntent);
			
			i = new Intent(this, WidgetService.class);
			pendingIntent = PendingIntent.getService(this, 0, i, 0);
			views.setOnClickPendingIntent(R.id.botaoProxima, pendingIntent);
			AppWidgetManager.getInstance(this).updateAppWidget(referencia, views);
		} catch (Exception e) {
			Log.e("WidgetService", e.getMessage(), e);
		}
	}
}
