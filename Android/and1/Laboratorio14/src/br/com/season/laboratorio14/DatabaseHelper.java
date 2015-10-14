package br.com.season.laboratorio14;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static String DB_NAME = "tarefas.db";
	private static int DB_VERSION = 1;
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table tarefas (_id integer primary key autoincrement, titulo text," +
				" descricao text, concluida boolean);";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	}

	public List<Tarefa> lerTodas() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		Cursor cursor = getReadableDatabase().rawQuery("select * from tarefas", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(cursor.getInt(0));
			tarefa.setTitulo(cursor.getString(1));
			tarefa.setDescricao(cursor.getString(2));
			tarefa.setConcluida(cursor.getInt(3) == 1);
			tarefas.add(tarefa);
			cursor.moveToNext();
		}
		return tarefas;
	}
	
	public List<Tarefa> lerPendentes() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		Cursor cursor = getReadableDatabase().rawQuery("select * from tarefas where concluida = 0", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(cursor.getInt(0));
			tarefa.setTitulo(cursor.getString(1));
			tarefa.setDescricao(cursor.getString(2));
			tarefa.setConcluida(cursor.getInt(3) == 1);
			tarefas.add(tarefa);
			cursor.moveToNext();
		}
		return tarefas;
	}
	
	public void inserir(Tarefa tarefa) {
		ContentValues values = new ContentValues();
		values.put("titulo", tarefa.getTitulo());
		values.put("descricao", tarefa.getDescricao());
		values.put("concluida", false);
		getWritableDatabase().insert("tarefas", null, values);
	}
	
	public void excluir(int id) {
		getWritableDatabase().delete("tarefas", "_id = " + id, null);
	}
	
	public void atualizar(Tarefa tarefa) {
		ContentValues values = new ContentValues();
		values.put("titulo", tarefa.getTitulo());
		values.put("descricao", tarefa.getDescricao());
		values.put("concluida", tarefa.isConcluida());
		getWritableDatabase().update("tarefas", values, "_id = " + tarefa.getId(), null);
	}
}
