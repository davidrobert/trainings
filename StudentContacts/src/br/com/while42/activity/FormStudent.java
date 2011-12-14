package br.com.while42.activity;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import br.com.while42.R;
import br.com.while42.model.Student;
import br.com.while42.persist.StudentDAO;
import br.com.while42.view.IndicatorBar;

public class FormStudent extends Activity {

	protected static final int TAKE_PHOTO = 123;
	private Student student;	

	private ImageButton photo;
	private EditText name;
	private EditText phone;
	private EditText email;
	private EditText twitter;
	private EditText site;
	private EditText address;
	private IndicatorBar score;

	private Button gravar;
	private String fileName;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);                

		student = (Student) getIntent().getSerializableExtra("alunoSelecionado");

		photo = (ImageButton) findViewById(R.id_form.imageButtonPhoto);
		name = (EditText) findViewById(R.id_form.editTextName);
		phone = (EditText) findViewById(R.id_form.editTextPhone);
		email = (EditText) findViewById(R.id_form.editTextEmail);
		twitter = (EditText) findViewById(R.id_form.editTextTwitter);
		site = (EditText) findViewById(R.id_form.editTextSite);
		address = (EditText) findViewById(R.id_form.editTextEndereco);
		score = (IndicatorBar) findViewById(R.id_form.indicatorBarScore);

		gravar = (Button) findViewById(R.id_form.buttonRecord);

		if (student == null) {
			student = new Student();        	

		} else {        	
			gravar.setText("Alterar");

			name.setText(student.getName());
			phone.setText(student.getPhone());
			email.setText(student.getEmail());
			twitter.setText(student.getTwitter());
			site.setText(student.getSite());
			address.setText(student.getAddress());
			score.setRating((float) student.getScore());
		}   

		loadImage();

		photo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

				fileName = Environment.getExternalStorageDirectory() + "/student_" + System.currentTimeMillis() + ".jpg";
				File file = new File(fileName);
				Uri outputFileUri = Uri.fromFile(file);
				camera.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

				startActivityForResult(camera, TAKE_PHOTO);					
			}
		});

		gravar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				student.setName(name.getText().toString());
				student.setPhone(phone.getText().toString());
				student.setEmail(email.getText().toString());
				student.setTwitter(twitter.getText().toString());
				student.setSite(site.getText().toString());
				student.setAddress(address.getText().toString());
				student.setScore(score.getRating());

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

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == TAKE_PHOTO) {			
			if (resultCode == RESULT_OK) {
				student.setPhoto(fileName);
				loadImage();    			
			} else 
			{
				student.setPhoto(null);
			}
		}
	}

	public void loadImage() {
		Bitmap bm;
		if (student.getPhoto() != null && student.getPhoto() != "") {	
			bm = BitmapFactory.decodeFile(student.getPhoto());
		} else {					
			bm = BitmapFactory.decodeResource(this.getResources(), R.drawable.noimage);
		}

		bm = Bitmap.createScaledBitmap(bm, 100, 100, true);
		photo.setImageBitmap(bm);  
	}
}