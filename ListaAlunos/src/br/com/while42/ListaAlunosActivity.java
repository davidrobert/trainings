package br.com.while42;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends Activity {
    
	private String selectedItem;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuItem novo = menu.add(0, 0, 0, "Novo");
		MenuItem sync = menu.add(0, 1, 0, "Sicronizar");
		MenuItem album = menu.add(0, 2, 0, "Galeria");
		MenuItem map = menu.add(0, 3, 0, "Map");
		
		novo.setIcon(R.drawable.novo);
		sync.setIcon(R.drawable.smile);
		album.setIcon(R.drawable.foto);
		map.setIcon(R.drawable.mapa);
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);		
		
		menu.setHeaderTitle(selectedItem);
		
		menu.add(0, 0, 0, "Ligar");
		menu.add(0, 1, 0, "Enviar SMS");
		menu.add(0, 2, 0, "Achar no Mapa");
		menu.add(0, 3, 0, "Navegar no site");
		menu.add(0, 4, 0, "Deletar");
		menu.add(0, 5, 0, "Enviar E-mail");
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == 0) {
			Toast.makeText(ListaAlunosActivity.this, "Novo Aluno", Toast.LENGTH_SHORT).show();
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	
		Toast.makeText(ListaAlunosActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
		
		return super.onContextItemSelected(item);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        
        final ListView listaAlunos = (ListView) findViewById(R.id_lista.listagem);
        final List<String> nomes = Arrays.asList("David", "Eduardo", "João", "Maria", "Jose");
        
        int layout = android.R.layout.simple_list_item_1;
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout, nomes);
        listaAlunos.setAdapter(adapter);
        
        
        listaAlunos.setOnItemClickListener(new OnItemClickListener() {
        	
			@Override
			public void onItemClick(AdapterView<?> adapterView, View v, int posicao, long id) {
				Toast.makeText(ListaAlunosActivity.this, nomes.get(posicao), Toast.LENGTH_SHORT).show();				
			}
        	
		});
                
        listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View v,
					int posicao, long id) {
				selectedItem = nomes.get(posicao);
				registerForContextMenu(listaAlunos);
				
				//Toast.makeText(ListaAlunosActivity.this, "long", Toast.LENGTH_SHORT).show();
								
				return false; // se colocar true nao propaga o evento para outros listeners
			}
		});
        
    }
}