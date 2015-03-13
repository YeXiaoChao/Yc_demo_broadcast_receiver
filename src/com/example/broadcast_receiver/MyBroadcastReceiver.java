package com.example.broadcast_receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 
 * @author yechao
 * @说明 创建BroadcastReceiver
 * @注意 记得将 BroadcastReceiver 进行注册
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

	private Context context;

	/**
	 * 重写 onReceive 方法
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		this.context = context;
		showNotification(intent);
	}

	/**
	 * 创建 Notification 对象
	 */
	private void showNotification(Intent intent) {
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notification = new Notification(R.drawable.ic_launcher,
				intent.getExtras().getString("content"),
				System.currentTimeMillis());

		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
				new Intent(context, MainActivity.class), 0);

		notification.setLatestEventInfo(context,
				intent.getExtras().getString("content"), null, pendingIntent);

		notificationManager.notify(R.layout.activity_main, notification);
	}
}
