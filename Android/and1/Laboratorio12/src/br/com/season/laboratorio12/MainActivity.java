package br.com.season.laboratorio12;

import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button workerButton;
	private Button asyncButton;
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		workerButton = (Button) findViewById(R.id.worker_button);
		workerButton.setOnClickListener(this);
		asyncButton = (Button) findViewById(R.id.async_button);
		asyncButton.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.imagem);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class DownloadTask extends AsyncTask<String, Void, Bitmap> {

		private ProgressDialog p;
		
		@Override
		protected void onPreExecute() {
			p = new ProgressDialog(MainActivity.this);
			p.setMessage("Aguarde...");
			p.show();
		}
		
		@Override
		protected Bitmap doInBackground(String... params) {
			Bitmap bitmap = null;
			try {
				Thread.sleep(1000);
				bitmap = loadImage(params[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			img.setImageBitmap(result);
			p.dismiss();
		}
		
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == workerButton.getId()) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						final Bitmap bitmap = loadImage("http://www.rafaeltoledo.net/image.png");
						img.post(new Runnable() {
							
							@Override
							public void run() {
								img.setImageBitmap(bitmap);							
							}
						});
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		} else if (v.getId() == asyncButton.getId()) {
			new DownloadTask().execute("http://www.rafaeltoledo.net/image2.png");
		}
	}
	
	private Bitmap loadImage(String url) throws Exception {
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		Bitmap bitmap = BitmapFactory.decodeStream(conn.getInputStream());
		conn.disconnect();
		return bitmap;
	}

}
