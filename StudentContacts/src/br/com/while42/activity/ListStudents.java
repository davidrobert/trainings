package br.com.while42.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
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

	private Student studentSelected;
	private List<Student> students = new ArrayList<Student>();
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

		menu.setHeaderTitle(studentSelected.toString());

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

		switch (item.getItemId()) {
		case 0: // Ligar
			Intent ligar = new Intent(Intent.ACTION_CALL);
			ligar.setData(Uri.parse("tel:" + studentSelected.getPhone()));
			startActivity(ligar);
			break;
			
		case 1: // SMS
			
			Intent sms = new Intent(Intent.ACTION_VIEW);
			sms.setData(Uri.parse("sms:" + studentSelected.getPhone()));
			sms.putExtra("sms_body", "Minha mensagem!");
			startActivity(sms);
			
			
			/*
			SmsManager smsManager = SmsManager.getDefault();
			PendingIntent sentIntent = PendingIntent.getActivity(this, 0, null, 0);
			
			if (PhoneNumberUtils.isWellFormedSmsAddress(studentSelected.getPhone())) {
				String text = "Primeiro SMS!";
				smsManager.sendTextMessage(studentSelected.getPhone(), null, text, sentIntent, null);
				Toast.makeText(this, "SMS Enviado", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(this, "Telefone mal formatado", Toast.LENGTH_LONG).show();
			}
			*/
			
			break;
		
		case 2: // Mapa
			Intent map = new Intent(Intent.ACTION_VIEW);
			map.setData(Uri.parse("geo:0,0?z=14&q="+studentSelected.getAddress()));
			startActivity(map);
			break;
			
		case 3: // Site
			Intent web = new Intent(Intent.ACTION_VIEW);
			web.setData(Uri.parse(studentSelected.getSite()));
			startActivity(web);
			break;			
			
		case 4: // Deletar 
			StudentDAO dao = new StudentDAO(this);
			dao.delete(studentSelected);
			students.remove(studentSelected);
			dao.close();
			
			adapter.notifyDataSetChanged();
			break;
			

		default:
			break;
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
		students.clear();
		students.addAll(dao.getList());
		dao.close();

		adapter.notifyDataSetChanged();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista);

		listStudents = (ListView) findViewById(R.id_list.listagem);                                      
		int layout = android.R.layout.simple_list_item_1;
		
		// TODO; Transformar em uma classe qu herde de ArrayAdapter
		adapter = new ArrayAdapter<Student>(this, layout, students) {
			
			public int getCount() {			
				return students.size();
			}
			
			public long getItemId(int posicao) {
				return students.get(posicao).getId();
			}
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View item = ListStudents.this.getLayoutInflater().inflate(R.layout.student_item, null);
				
				ImageView photo = (ImageView) item.findViewById(R.id_student_item.imageViewPhoto);
				TextView name = (TextView) item.findViewById(R.id_student_item.textViewName);
				
				Student student = students.get(position);
				name.setText(student.getName());
						
				Bitmap bm;
				if (student.getPhoto() != null) {					
					bm = BitmapFactory.decodeFile(student.getPhoto());
					
				} else if (student.getTwitter() != null) {					
					// TODO; Carregar de forma correta a imagem do Twitter					
					bm = BitmapFactory.decodeResource(ListStudents.this.getResources(), R.drawable.noimage);					
					
				} else {					
					bm = BitmapFactory.decodeResource(ListStudents.this.getResources(), R.drawable.noimage);
				}
				
				bm = Bitmap.createScaledBitmap(bm, 70, 70, true);
				photo.setImageBitmap(bm);
				
				return item;
			}
			
		};

		listStudents.setAdapter(adapter);
		listStudents.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View v, int posicao, long id) {
				Toast.makeText(ListStudents.this, students.get(posicao).toString(), Toast.LENGTH_SHORT).show();				
			}

		});

		listStudents.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View v,
					int posicao, long id) {

				Intent edit = new Intent(ListStudents.this, FormStudent.class);
				edit.putExtra("alunoSelecionado", students.get(posicao));
				startActivity(edit);
				
			}
		});
		
		listStudents.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View v,
					int posicao, long id) {
				studentSelected = students.get(posicao);
				registerForContextMenu(listStudents);

				//Toast.makeText(ListaAlunosActivity.this, "long", Toast.LENGTH_SHORT).show();

				return false; // se colocar true nao propaga o evento para outros listeners
			}
		});

	}
}