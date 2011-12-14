package br.com.while42.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;
import br.com.while42.adapter.GalleryStudentAdapter;
import br.com.while42.model.Student;
import br.com.while42.persist.StudentDAO;

public class GalleryStudents extends Activity {
	
	private List<Student> students = new ArrayList<Student>();
	private GalleryStudentAdapter adapter;
	private Gallery gallery;
	
	@Override
	protected void onResume() {
		super.onResume();

		StudentDAO dao = new StudentDAO(this);
		students.clear();
		students.addAll(dao.getList());
		dao.close();

		adapter.notifyDataSetChanged();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.gallery);
		
		adapter = new GalleryStudentAdapter(this, students);
		
		gallery = (Gallery) findViewById(R.id_galery.galleryPhoto);     
		gallery.setAdapter(adapter);
		
		gallery.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View v, int posicao, long id) {
				// Mostra o nome do estudante ao tocar na foto
				Toast.makeText(GalleryStudents.this, students.get(posicao).toString(), Toast.LENGTH_SHORT).show();			
			}
			
		});
	}
}
