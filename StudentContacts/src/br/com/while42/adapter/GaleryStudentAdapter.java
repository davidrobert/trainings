package br.com.while42.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import br.com.while42.activity.R;
import br.com.while42.model.Student;

public class GaleryStudentAdapter extends BaseAdapter {

	private Context context;
	private List<Student> students; 
	
	public GaleryStudentAdapter(Context context, List<Student> students) {
		this.context = context;
		this.students = students;
	}
	
	@Override
	public int getCount() {
		return students.size();
	}

	@Override
	public Object getItem(int position) {
		return students.get(position);
	}

	@Override
	public long getItemId(int position) {
		return students.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView image = new ImageView(context);
		
		Bitmap bm;
		if (students.get(position).getPhoto() != null) {					
			bm = BitmapFactory.decodeFile(students.get(position).getPhoto());
		} else {					
			bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.noimage);
		}

		bm = Bitmap.createScaledBitmap(bm, 70, 70, true);		
		image.setImageBitmap(bm);
		return image;
	}

}
