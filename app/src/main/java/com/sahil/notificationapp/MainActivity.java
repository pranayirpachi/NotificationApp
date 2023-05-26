package com.sahil.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID  = "hello sahil";
    private static final int NOTIFICATION_ID = 100;
    private static final int PIN_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating the drawable

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.web1,null);

        //converts into bitmap
        Notification notification;

        BitmapDrawable drawable1 = (BitmapDrawable) drawable;
        Bitmap imagecon = drawable1.getBitmap();
        Intent inotify = new Intent(getApplicationContext(),MainActivity.class);
        inotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,PIN_CODE,inotify,PendingIntent.FLAG_UPDATE_CURRENT);

        //Big Picture Style


      //  Notification.BigPictureStyle bigPictureStyle =  new Notification.BigPictureStyle().bigPicture((BitmapDrawable)(ResourcesCompat.getDrawable(),R.drawable.web1,null))


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            notification = new Notification.Builder(this).setLargeIcon(imagecon)
                    .setSmallIcon(R.drawable.web1)
                    .setContentText("new message")
                    .setSubText("this my message")
                    .setContentIntent(pendingIntent)
                    .setChannelId(CHANNEL_ID).build();
            manager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"sanjay tea",NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification = new Notification.Builder(this).setLargeIcon(imagecon)
                    .setSmallIcon(R.drawable.web1)
                    .setContentText("new message")
                    .setSubText("this my message")
                    .setContentIntent(pendingIntent)
                    .build();

        }
        manager.notify(NOTIFICATION_ID,notification);

    }
}