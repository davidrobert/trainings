package br.com.while42.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import br.com.while42.model.Student;
import br.com.while42.persist.StudentDAO;

public class FormStudent extends Activity {
    	
	private Student student;	
	
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
        
        student = (Student) getIntent().getSerializableExtra("alunoSelecionado");
        
        if (student == null) {
        	student = new Student();
        } else {        	
        	gravar.setText("Alterar");
        	
            nome.setText(student.getName());
            telefone.setText(student.getPhone());
            email.setText(student.getEmail());
            twitter.setText(student.getTwitter());
            endereco.setText(student.getAddress());
            nota.setRating((float) student.getScore());
        }               
        
        gravar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				student.setName(nome.getText().toString());
				student.setPhone(telefone.getText().toString());
				student.setEmail(email.getText().toString());
				student.setTwitter(twitter.getText().toString());
				student.setAddress(endereco.getText().toString());
				student.setScore(nota.getRating());
				
				StudentDAO dao = new StudentDAO(FormStudent.this);				
				dao.save(student);			
				dao.close();
				
				/* Mata a activity corrente e retorna para a activity anterior.
				 * A activity anterior retorna para o onStart (e ela nao passa pelo onCreate).
				 * 
				 * Se em vez do finish fosse chamado o
				 * startActivity(new Intent(FormStudent.this, ListStudents.class));
				 * a ativity atual nao morreria
				 */
				finish(); 
			}
		});
    }
}