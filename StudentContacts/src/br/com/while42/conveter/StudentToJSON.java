package br.com.while42.conveter;

import java.util.List;

import org.json.JSONException;
import org.json.JSONStringer;

import android.util.Log;
import br.com.while42.model.Student;

public class StudentToJSON {

	private static void convert(JSONStringer j, Student student) throws JSONException {
		j.object().key("aluno")
			.object()
				.key("id").value(student.getId())
				.key("nome").value(student.getName())
				.key("endereco").value(student.getAddress())
				.key("telefone").value(student.getPhone())
				.key("email").value(student.getEmail())
				.key("twitter").value(student.getTwitter())
				.key("site").value(student.getSite())
				.key("nota").value(student.getScore())
			.endObject()
		.endObject();
	}

	public static String convert(List<Student> students) {
		JSONStringer j = new JSONStringer();

		try {
			j.object().key("list").array();

			for (Student student: students) {
				convert(j, student);			
			}

			j.endArray().endObject();

		} catch (JSONException e) {
			Log.i("ERROR", "JSONException");
			e.printStackTrace();
		}


		return j.toString();
	}

	public static String convert(Student student) {
		JSONStringer j = new JSONStringer();

		try {		
			convert(j, student);

		} catch (JSONException e) {
			Log.i("ERROR", e.toString());
			e.printStackTrace();
		}
		return j.toString();
	}

}
