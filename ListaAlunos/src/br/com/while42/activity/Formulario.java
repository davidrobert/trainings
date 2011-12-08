package br.com.while42.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import br.com.while42.model.Aluno;
import br.com.while42.persist.AlunoDAO;

public class Formulario extends Activity {
    	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        
        final EditText nome = (EditText) findViewById(R.id.editTextName);
        final EditText telefone = (EditText) findViewById(R.id.editTextPhone);
        final EditText email = (EditText) findViewById(R.id.editTextEmail);
        final EditText twitter = (EditText) findViewById(R.id.editTextTwitter);
        final EditText endereco = (EditText) findViewById(R.id.editTextEndereco);
        final RatingBar nota = (RatingBar) findViewById(R.id.ratingBarScore);
        
        final Button gravar = (Button) findViewById(R.id.buttonRecord);
        
        gravar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Aluno a = new Aluno();
				a.setNome(nome.getText().toString());
				a.setTelefone(telefone.getText().toString());
				a.setEmail(email.getText().toString());
				a.setTwitter(twitter.getText().toString());
				a.setEndereco(endereco.getText().toString());
				a.setNota(nota.getRating());
				
				AlunoDAO dao = new AlunoDAO(Formulario.this);
				dao.add(a);		
				dao.close();
								
				startActivity(new Intent(Formulario.this, ListaAlunos.class));
			}
		});
    }
}