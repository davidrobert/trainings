package br.com.while42.persist;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.while42.model.Student;

public class StudentDAO extends SQLiteOpenHelper {

	static final int VERSION = 5;
	static final String TABLE = "student";
	static final String[] COLS = {"id", "name", "address", "phone", "email", "twitter", "site", "score", "photo"};	
	
	public StudentDAO(Context context) {
		super(context, TABLE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		StringBuilder sb = new StringBuilder();		
		sb.append("CREATE TABLE ").append(TABLE).append(" (");
		sb.append("id INTEGER PRIMARY KEY, ");
		sb.append("name TEXT UNIQUE NOT NULL, ");
		sb.append("address TEXT, ");
		sb.append("phone TEXT, ");
		sb.append("email TEXT, ");
		sb.append("twitter TEXT, ");
		sb.append("site TEXT, ");
		sb.append("score REAL, ");
		sb.append("photo TEXT");
		sb.append(")");
		
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("DROP TABLE IF EXISTS ").append(TABLE);
		db.execSQL(sb.toString());
		
		onCreate(db);
	}
	
	public void save(Student student) {			
		
		ContentValues values = toValues(student);
				
		if (!student.isPersistent()) {
			
			long insert = getWritableDatabase().insert(TABLE, null, values);
			student.setId(insert);
			
		} else {
			String[] whereArgs = new String[] { Long.toString(student.getId()) };
			getWritableDatabase().update(TABLE, values, "id=?", whereArgs );
		}
	}
		
	public void delete(Student student) {		
		
		String[] whereArgs = new String[] { Long.toString(student.getId()) };
		getWritableDatabase().delete(TABLE, "id=?", whereArgs);		
	}
	
	public List<Student> getList() {			
		
		List<Student> students = new ArrayList<Student>();		
		Cursor cursor = getWritableDatabase().query(TABLE, 
				COLS,    // Colunas 
				null,    // where
				null,    // values
				null,    // group by
				null,    // having
				"name"); // order by
		
		while (cursor.moveToNext()) {
			
			Student student = new Student();
			
			student.setId(cursor.getInt(0));
			student.setName(cursor.getString(1));
			student.setAddress(cursor.getString(2));
			student.setPhone(cursor.getString(3));
			student.setEmail(cursor.getString(4));
			student.setTwitter(cursor.getString(5));
			student.setSite(cursor.getString(6));
			student.setScore(cursor.getDouble(7));
			student.setPhoto(cursor.getString(8));
			
			students.add(student);
		}
		
		cursor.close(); // !!!
		
		return students;
	}
	
	public ContentValues toValues(Student student) {
		
		ContentValues values = new ContentValues();
		
		if (student.isPersistent())
		{
			values.put("id", student.getId());
		}
		
		values.put("name", student.getName());
		values.put("address", student.getAddress());
		values.put("phone", student.getPhone());
		values.put("email", student.getEmail());
		values.put("twitter", student.getTwitter());
		values.put("site", student.getSite());
		values.put("score", student.getScore());
		values.put("photo", student.getPhoto());
		
		return values;
	}

}
