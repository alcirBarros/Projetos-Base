package br.com.selfsystem.scjp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import android.os.Bundle;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.AssetManager.AssetInputStream;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView count;
	private Button start;

	private String[] files;
	private AssetManager assets;
	private Random gerador;

	private Pergunta pergunta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		count = (TextView) findViewById(R.id.textViewCount);

		assets = getAssets();
		try {
			files = assets.list("questions");
			count.setText(String.valueOf(files.length));

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		start = (Button) findViewById(R.id.buttonStart);
		start.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setContentView(R.layout.question);

				gerador = new Random(System.currentTimeMillis());

				nextQuetion();

				Button buttonCheck = (Button) findViewById(R.id.buttonCheck);

				buttonCheck.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						RadioGroup question = (RadioGroup) findViewById(R.id.radio);


						final Button buttonCheck = (Button) findViewById(R.id.buttonCheck);
						buttonCheck.setVisibility(View.GONE);
						
						// get selected radio button from radioGroup
						int selectedId = question.getCheckedRadioButtonId();
						
						//Toast.makeText(MainActivity.this,String.valueOf(selectedId)+" "+String.valueOf(pergunta.getResposta()) , Toast.LENGTH_LONG).show();
						
						
						final TextView textViewAcert = (TextView) findViewById(R.id.textViewAcert);
						textViewAcert.setVisibility(View.VISIBLE);
						
						if(selectedId == pergunta.getResposta()){
							textViewAcert.setText("Correct.");
						}else{
							textViewAcert.setText("Option "+ (pergunta.getResposta()+1) +" is correct.");
						}

						
						final Button buttonNext = (Button) findViewById(R.id.buttonNext);
						buttonNext.setVisibility(View.VISIBLE);
						
						 buttonNext.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								nextQuetion();
								buttonNext.setVisibility(View.INVISIBLE);
								buttonCheck.setVisibility(View.VISIBLE);
								textViewAcert.setVisibility(View.INVISIBLE);
							}
						});

					}
				});

			}
		});

	}

	

	private Pergunta getQuestion(int nextInt) throws IOException {

		InputStream a = getAssets().open("questions/" + files[nextInt]);

		int qtdLinha = numeroLinhasArquivo(a);
		a.reset();

		Reader reader = new InputStreamReader(a, "UTF-8");
		BufferedReader br = new BufferedReader(reader);

		Pergunta pergunta = new Pergunta();
		for (int i = 1; i <= qtdLinha; i++) {
			if (i < qtdLinha) {
				String linha = br.readLine();
				pergunta.getQuestion().append(linha).append("\n");
			} else {
				String linha = br.readLine();
				resposta(pergunta, linha);

			}
		}

		return pergunta;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private int numeroLinhasArquivo(InputStream inputStream) throws IOException {

		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		LineNumberReader linhaLeitura = new LineNumberReader(reader);
		linhaLeitura.skip(inputStream.available());
		int qtdLinha = linhaLeitura.getLineNumber();

		return qtdLinha;
	}

	private void resposta(Pergunta pergunta, String linha) {
		
		
		Map<Integer, String> opcoes = new HashMap<Integer, String>();
		
		String[] respostas = linha.split("\\|");
		
		for(int i = 0; i < respostas.length -1; i++){
			opcoes.put(i, respostas[i]);
		}
		pergunta.setOpcoes(opcoes);
		pergunta.setResposta(Integer.parseInt(respostas[respostas.length -1]));
		
	}

	public void nextQuetion() {
		try {
			int nextInt = gerador.nextInt(files.length);

			pergunta = getQuestion(nextInt);

			TextView text = (TextView) findViewById(R.id.textViewQuestion);
			text.setText(pergunta.getQuestion());

			RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
			radioGroup.removeAllViews();
			radioGroup.clearCheck();
			for (Map.Entry<Integer, String> entry : pergunta.getOpcoes().entrySet()) {
				Integer numero = entry.getKey();
				String opcao = entry.getValue();

				RadioButton radioButton = new RadioButton(MainActivity.this);
				radioButton.setId(numero);
				radioButton.setText((numero+1)+" "+opcao);
				radioGroup.addView(radioButton);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
