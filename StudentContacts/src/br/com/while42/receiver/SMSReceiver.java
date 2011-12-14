package br.com.while42.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import br.com.while42.R;
import br.com.while42.model.Student;
import br.com.while42.persist.StudentDAO;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Object[] messages = (Object[]) bundle.get("pdus");
		
		SmsMessage smsMessage[] = new SmsMessage[messages.length];
		Log.i("DEBUG>>", Integer.toString(messages.length));
		
		StudentDAO dao = new StudentDAO(context);
		
		for (int i = 0; i < messages.length; i++) {
			smsMessage[i] = SmsMessage.createFromPdu((byte[]) messages[i]);
			Log.i("DEBUG", smsMessage[i].toString());
			
			String phone = smsMessage[i].getDisplayOriginatingAddress();
			Student student = dao.findByPhone(phone);
			Log.i("-->", phone);
			if (student != null) {				
				Toast.makeText(context, student.getName(), Toast.LENGTH_LONG);
				
			} else {
				Toast.makeText(context, phone, Toast.LENGTH_LONG);
			}
			MediaPlayer player = MediaPlayer.create(context, R.raw.msg);
			player.start();
		}

		dao.close();		
	}

}
