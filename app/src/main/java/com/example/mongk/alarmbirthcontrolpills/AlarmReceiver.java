package com.example.mongk.alarmbirthcontrolpills;

import android.app.NativeActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;


import static android.app.NotificationManager.IMPORTANCE_DEFAULT;
import static android.content.ContentValues.TAG;

public class AlarmReceiver extends BroadcastReceiver{
    private static final String CHANNEL_ID = "com.example.mongk.alarmbirthcontrolpills";
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentAlert = new Intent(context,NotificationActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(intentAlert);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);
        Notification notification = builder.setContentTitle("Alarm Birth Control Pill")
                .setContentText("ได้เวลาทานยาแล้ว")
                .setTicker("ได้เวลาทานยาแล้ว!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent).build();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID);
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "NotificationPill",
                    IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(0, notification);

        intentAlert.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentAlert);
        Log.d(TAG, "onReceive: gg");
    }
}
