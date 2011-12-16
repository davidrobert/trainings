package br.com.while42.studantcontacts.activity;

import br.com.while42.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;

public class Preferences extends Activity {

	private CheckBox check = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		check = (CheckBox) findViewById(R.id_preferences.checkBoxOrder);
	}
	
	
}
