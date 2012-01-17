package br.com.while42.studantcontacts.communication;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import br.com.while42.studantcontacts.conveter.StudentToJSON;
import br.com.while42.studantcontacts.model.Student;
import br.com.while42.studantcontacts.persist.StudentDAO;

public class Synchronism {
	private String address = "http://www.caelum.com.br/mobile?dado=";

	private Context context;
	private ProgressDialog progress;
	private Toast message;

	public Synchronism(Context context) {
		this.context = context;
	}

	public void syncronize() {
		// TODO: Escrever um comentario explicando a funcionalidade dos dois "true" na metodo show
		progress = ProgressDialog.show(context, "Aguarde...", "Sincronizando dados com o servidor", true, true);
		message = Toast.makeText(context, "Dados enviados com sucesso", Toast.LENGTH_LONG);

		new Thread(new Runnable() {

			@Override
			public void run() {

				StudentDAO dao = new StudentDAO(context);
				List<Student> students = dao.getList();
				dao.close();

				Log.i("DEBUG", address + StudentToJSON.convert(students));

				/* 
				 * Exemplo de requisicao (sem encode) 
				 * http://www.caelum.com.br/mobile?dado={"list":[{"aluno":{"id":1,"nome":"David Robert","endereco":"Avenida Leonardo da Vinci, 2713, Sao Paulo","telefone":"11123456789","email":"davidrobert@gmail.com","twitter":"while42","site":"http:\/\/while42.com.br","nota":5}},{"aluno":{"id":2,"nome":"jonas","endereco":"","telefone":"","email":"","twitter":"","site":"","nota":3.5}},{"aluno":{"id":3,"nome":"maria","endereco":"","telefone":"","email":"","twitter":"","site":"","nota":3}}]}
				 */

				String encode = URLEncoder.encode(StudentToJSON.convert(students));
				encode = address + encode; 

				HttpClient client = new DefaultHttpClient();
				Log.i("ENVIANDO", encode);
				HttpGet httpget = new HttpGet(encode);

				try {
					HttpResponse response = client.execute(httpget);
					String msg = EntityUtils.toString(response.getEntity());

					message.setText(msg);
					Log.i("RECEBENDO", msg);

				} catch (ClientProtocolException e) {
					Log.i("ERROR", "ClientProtocolException");
					e.printStackTrace();

				} catch (ParseException e) {
					Log.i("ERROR", "ParseException");
					e.printStackTrace();

				} catch (IOException e) {
					Log.i("ERROR", "IOException");
					e.printStackTrace();
				}

				progress.dismiss();
				message.show();
			}
		}).start();
	}

}
