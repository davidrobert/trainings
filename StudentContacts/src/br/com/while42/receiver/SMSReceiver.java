package br.com.while42.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import br.com.while42.R;
import br.com.while42.activity.ListStudents;
import br.com.while42.model.Student;
import br.com.while42.persist.StudentDAO;

public class SMSReceiver extends BroadcastReceiver {
	
	public static String NOTIFICATION_LABEL = "idNotification";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Object[] messages = (Object[]) bundle.get("pdus");
		
		SmsMessage smsMessage[] = new SmsMessage[messages.length];
		
		StudentDAO dao = new StudentDAO(context);
		
		for (int i = 0; i < messages.length; i++) {
			smsMessage[i] = SmsMessage.createFromPdu((byte[]) messages[i]);
			
			String phone = smsMessage[i].getDisplayOriginatingAddress();
			Student student = dao.findByPhone(phone);
			
			String msg;
			if (student != null) {
				msg = "Recebido SMS de " + student.getName();
				Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
				
			} else {
				msg = "Recebido SMS de " + phone;
				Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
			}
						
			MediaPlayer player = MediaPlayer.create(context, R.raw.msg);
			player.start();
			
			notify(context, msg);
		}

		dao.close();		
	}

	private void notify(Context context, String message) {
				
		// O codigo 123456 deve ser gerado pois pode existir diferentes notificacoes e no momento de cancelar 
		// tem que associar a correta. Entretanto se qualquer modificacao leva-se pra mesma interface o codigo
		// poderia ser o mesmo. Uma das maneiras de gerar numeros "aleatorios" seria utilizar "preferences" do usuario
		int code = 123456;
		
		Intent notificationIntent = new Intent(context, ListStudents.class);
		notificationIntent.putExtra(NOTIFICATION_LABEL, code);
		
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, Intent.FLAG_ACTIVITY_NEW_TASK);
		
		Notification noty = new Notification(R.drawable.musica, message, System.currentTimeMillis());
		noty.setLatestEventInfo(context, "Mensagem do Aluno", message, contentIntent);
		
		NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);			
		manager.notify(code, noty);		
	}
}


