package br.com.season.laboratorio4;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button botaoOk;
	private Button botaoLimpar;
	private EditText campoUsuario;
	private EditText campoSenha;
	private TextView mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        botaoOk = (Button) findViewById(R.id.botaoOk);
        botaoLimpar = (Button) findViewById(R.id.botaoLimpar);
        campoUsuario = (EditText) findViewById(R.id.campoUsuario);
        campoSenha = (EditText) findViewById(R.id.campoSenha);
        mensagem = (TextView) findViewById(R.id.mensagem);
        
        botaoOk.setOnClickListener(this);
        botaoLimpar.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.botaoLimpar) {
			campoUsuario.setText("");
			campoSenha.setText("");
			mensagem.setText("");
		} else if (v.getId() == R.id.botaoOk) {
			String usuario = campoUsuario.getText().toString();
			String senha = campoSenha.getText().toString();
			if (usuario.equals("Rafael") && senha.equals("123")) {
				mensagem.setText("Login OK!");
				mensagem.setTextColor(Color.BLACK);
			} else {
				mensagem.setText("Acesso NEGADO!");
				mensagem.setTextColor(Color.RED);
			}
		}		
	}    
}
