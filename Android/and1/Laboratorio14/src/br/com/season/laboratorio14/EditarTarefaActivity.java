package br.com.season.laboratorio14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class EditarTarefaActivity extends Activity implements OnClickListener {

	private TextView titulo;
	private TextView descricao;
	private Button botaoConcluir;
	private Button botaoExcluir;
	
	private Tarefa tarefa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_tarefa);
		
		tarefa = (Tarefa) getIntent().getSerializableExtra("tarefa");
		
		titulo = (TextView) findViewById(R.id.titulo);
		descricao = (TextView) findViewById(R.id.descricao);
		botaoConcluir = (Button) findViewById(R.id.concluir);
		botaoExcluir = (Button) findViewById(R.id.excluir);
		
		titulo.setText(tarefa.getTitulo());
		descricao.setText(tarefa.getDescricao());
		
		botaoConcluir.setOnClickListener(this);
		botaoExcluir.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		DatabaseHelper helper = new DatabaseHelper(this);
		if (v.getId() == botaoExcluir.getId()) {
			helper.excluir(tarefa.getId());
		} else if (v.getId() == botaoConcluir.getId()) {
			tarefa.setConcluida(true);
			helper.atualizar(tarefa);
		}
		helper.close();
		finish();
	}
}
