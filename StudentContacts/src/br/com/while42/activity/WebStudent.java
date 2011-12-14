package br.com.while42.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import br.com.while42.R;
import br.com.while42.model.Student;

public class WebStudent extends Activity {
	
	private Student student;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.site);
		
		WebView view = (WebView) findViewById(R.id_site.webViewSite);
		student = (Student) getIntent().getSerializableExtra("alunoSelecionado");
		
		String url = student.getSite();
		if (!url.startsWith("http://") && !url.startsWith("https://") && !url.startsWith("ftp://")) {
			url = "http://" + url;
		}
		view.loadUrl(url);		
	}
}
