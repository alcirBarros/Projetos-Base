package br.com.season.laboratorio10;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DetalhesActivity extends Activity implements OnClickListener {

	private Imovel imovel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes);
		
		imovel = (Imovel) getIntent().getExtras().getSerializable("imovel");

		Button botaoEmail = (Button) findViewById(R.id.email);
		botaoEmail.setOnClickListener(this);
		botaoEmail.setText("Enviar e-mail para " + imovel.getEmail());
		
		Button botaoTelefone = (Button) findViewById(R.id.telefone);
		botaoTelefone.setOnClickListener(this);
		botaoTelefone.setText("Ligar para " + imovel.getTelefone());
		
		Button botaoSite = (Button) findViewById(R.id.site);
		botaoSite.setOnClickListener(this);
		botaoSite.setText("Acessar " + imovel.getWebsite());
		
		Button botaoCompartilhar = (Button) findViewById(R.id.compartilhar);
		botaoCompartilhar.setOnClickListener(this);
		botaoCompartilhar.setText("Compartilhar " + imovel.getTitulo());
		
		setTitle(imovel.getTitulo());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.site:
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse(imovel.getWebsite()));
			startActivity(intent);
			break;
		case R.id.telefone:
			intent = new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:" + imovel.getTelefone()));
			startActivity(intent);
			break;
		case R.id.email:
			intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_EMAIL, new String[] {imovel.getEmail()});
			intent.putExtra(Intent.EXTRA_SUBJECT, "Tenho interesse em " + imovel.getTitulo());
			intent.putExtra(Intent.EXTRA_TEXT, "Olá, tenho interesse no imóvel " + imovel.getTitulo());
			startActivity(intent);
			break;
		case R.id.compartilhar:
			intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, "Vi o imóvel " + imovel.getTitulo() + 
					" no app\nVeja você também em " + imovel.getWebsite());
			startActivity(intent);
			break;
		}
	}
}
