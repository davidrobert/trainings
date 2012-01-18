package br.com.while42;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWordActivity extends Activity {
	/** Called when the activity is first created. */
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		Log.i("DEBUG", "onStart");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		Log.i("DEBUG", "onPause");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		Log.i("DEBUG", "onStop");
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("DEBUG", "onRestart");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Log.i("DEBUG", "onResume");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		Log.i("DEBUG", "onDestroy");
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		

		Log.i("DEBUG", "onCreate");

		final Button alterar = (Button) findViewById(R.id.bt_changetext);
		final TextView text = (TextView) findViewById(R.id.txt_first);				
		final EditText edText = (EditText) findViewById(R.id.edtxt_text);		
		
		int maxChars = 5;
		
		InputFilter[] filters = new InputFilter[1];
		filters[0] = new InputFilter.LengthFilter(maxChars);				
		
		//edText.setFilters(filters);
		
		alterar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {				
				text.setText(edText.getText());
				edText.setText("");		
				
				if (text.getText().toString().length() > 0) {
					Toast.makeText(HelloWordActivity.this, text.getText().toString(), Toast.LENGTH_LONG).show();
				}
				
			}
		});
							
	}
}