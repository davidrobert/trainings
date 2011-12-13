package br.com.while42.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class GaleryStudents extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ListView listStudents = (ListView) findViewById(R.id_galery.listagem);                                      
		int layout = android.R.layout.simple_list_item_1;

		
		
	}
}
