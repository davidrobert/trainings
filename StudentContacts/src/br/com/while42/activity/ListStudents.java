package br.com.while42.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.while42.model.Student;
import br.com.while42.persist.StudentDAO;

public class ListStudents extends Activity {

	private Student selectedItem;
	private List<Student> alunos = new ArrayList<Student>();
	private ArrayAdapter<Student> adapter;
	private ListView listStudents;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuItem newStudent = menu.add(0, 0, 0, "Novo");
		MenuItem sync = menu.add(0, 1, 0, "Sicronizar");
		MenuItem album = menu.add(0, 2, 0, "Galeria");
		MenuItem map = menu.add(0, 3, 0, "Map");		

		newStudent.setIcon(R.drawable.novo);
		sync.setIcon(R.drawable.smile);
		album.setIcon(R.drawable.foto);
		map.setIcon(R.drawable.mapa);

		newStudent.setIntent(new Intent(this, FormStudent.class));

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);		

		menu.setHeaderTitle(selectedItem.toString());

		menu.add(0, 0, 0, "Ligar");
		menu.add(0, 1, 0, "Enviar SMS");
		menu.add(0, 2, 0, "Achar no Mapa");
		menu.add(0, 3, 0, "Navegar no site");
		menu.add(0, 4, 0, "Deletar");
		menu.add(0, 5, 0, "Enviar E-mail");

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		if (item.getItemId() == 4) {
			StudentDAO dao = new StudentDAO(this);
			dao.delete(selectedItem);
			alunos.remove(selectedItem);
			dao.close();
			
			adapter.notifyDataSetChanged();
		}
		
		return super.onContextItemSelected(item);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();

		StudentDAO dao = new StudentDAO(this);
		alunos.clear();
		alunos.addAll(dao.getList());
		dao.close();

		adapter.notifyDataSetChanged();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista);

		listStudents = (ListView) findViewById(R.id_lista.listagem);                                      
		int layout = android.R.layout.simple_list_item_1;
		
		// TODO; Transformar em uma classe qu herde de ArrayAdapter
		adapter = new ArrayAdapter<Student>(this, layout, alunos) {
			
			public int getCount() {			
				return alunos.size();
			}
			
			public long getItemId(int posicao) {
				return alunos.get(posicao).getId();
			}
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View item = ListStudents.this.getLayoutInflater().inflate(R.layout.student_item, null);
				
				ImageView photo = (ImageView) item.findViewById(R.id_student_item.imageViewPhoto);
				TextView name = (TextView) item.findViewById(R.id_student_item.textViewName);
				
				Student student = alunos.get(position);
				name.setText(student.getName());
							
//				if (student.getPhoto()) {
//				
//					Bitmap bm = BitmapFactory.decodeFile(student.getPhoto());
//					bm = Bitmap.createScaledBitmap(bm, 100, 100, true);
//					photo.setImageBitmap(bm);					
//					
//				}
				
				
				return item;
			}
			
		};

		listStudents.setAdapter(adapter);
		listStudents.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View v, int posicao, long id) {
				Toast.makeText(ListStudents.this, alunos.get(posicao).toString(), Toast.LENGTH_SHORT).show();				
			}

		});

		listStudents.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View v,
					int posicao, long id) {

				Intent edit = new Intent(ListStudents.this, FormStudent.class);
				edit.putExtra("alunoSelecionado", alunos.get(posicao));
				startActivity(edit);
				
			}
		});
		
		listStudents.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View v,
					int posicao, long id) {
				selectedItem = alunos.get(posicao);
				registerForContextMenu(listStudents);

				//Toast.makeText(ListaAlunosActivity.this, "long", Toast.LENGTH_SHORT).show();

				return false; // se colocar true nao propaga o evento para outros listeners
			}
		});

	}
}