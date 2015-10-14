package br.com.season.laboratorio14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NovaTarefaActivity extends Activity {

	private EditText titulo;
	private EditText descricao;
	private Button botaoSalvar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nova_tarefa);
		
		titulo = (EditText) findViewById(R.id.titulo);
		descricao = (EditText) findViewById(R.id.descricao);
		botaoSalvar = (Button) findViewById(R.id.botao_salvar);
		botaoSalvar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Tarefa tarefa = new Tarefa();
				tarefa.setTitulo(titulo.getText().toString());
				tarefa.setDescricao(descricao.getText().toString());
				DatabaseHelper helper = new DatabaseHelper(NovaTarefaActivity.this);
				helper.inserir(tarefa);
				helper.close();
				finish();
			}
		});
	}
}
