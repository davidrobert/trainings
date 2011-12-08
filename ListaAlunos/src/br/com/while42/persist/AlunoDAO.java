package br.com.while42.persist;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.while42.model.Aluno;

public class AlunoDAO extends SQLiteOpenHelper {

	static final int VERSION = 2;
	static final String TABELA = "aluno";
	static final String[] COLS = {"id", "nome", "endereco", "telefone", "email", "twitter", "nota"};	
	
	public AlunoDAO(Context context) {
		super(context, TABELA, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		StringBuilder sb = new StringBuilder();		
		sb.append("CREATE TABLE ").append(TABELA).append(" (");
		sb.append("id INTEGER PRIMARY KEY, ");
		sb.append("nome TEXT UNIQUE NOT NULL, ");
		sb.append("endereco TEXT, ");
		sb.append("telefone TEXT, ");
		sb.append("email TEXT, ");
		sb.append("twitter TEXT, ");
		sb.append("nota REAL");
		sb.append(")");
		
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("DROP TABLE IF EXISTS ").append(TABELA);
		db.execSQL(sb.toString());
		
		onCreate(db);
	}
	
	public void add(Aluno a) {
		
		ContentValues values = toValues(a);				
		getWritableDatabase().insert(TABELA, null, values);
	}
	
	public List<Aluno> getList() {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		Cursor cursor = getWritableDatabase().query(TABELA, 
				COLS,    // Colunas 
				null,    // where
				null,    // values
				null,    // group by
				null,    // having
				"nome"); // order by
		
		while (cursor.moveToNext()) {
			
			Aluno aluno = new Aluno();
			
			aluno.setId(cursor.getInt(0));
			aluno.setNome(cursor.getString(1));
			aluno.setEndereco(cursor.getString(2));
			aluno.setTelefone(cursor.getString(3));
			aluno.setEmail(cursor.getString(4));
			aluno.setTwitter(cursor.getString(5));
			aluno.setNota(cursor.getDouble(6));
			
			alunos.add(aluno);
		}
		
		cursor.close(); // !!!
		
		return alunos;
	}
	
	public ContentValues toValues(Aluno a) {
		
		ContentValues values = new ContentValues();
		values.put("nome", a.getNome());
		values.put("endereco", a.getEndereco());
		values.put("telefone", a.getTelefone());
		values.put("email", a.getEmail());
		values.put("twitter", a.getTwitter());
		values.put("nota", a.getNota());
		
		return values;
	}

}
