package mtrzepacz.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button  buttonBasicNotification,
            buttonInboxNotification,
            buttonBigViewNotification,
            buttonBigPictureNotification,
            buttonCustomNotification,
            buttonToastNotification,
            buttonCustomToastNotification;
    Integer Counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBasicNotification  = (Button)findViewById(R.id.buttonBasicNotification);
        buttonBasicNotification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                addBasicNoticication();
            }
        });

        buttonInboxNotification = (Button)findViewById(R.id.buttonInBoxNotification);
        buttonInboxNotification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                addInboxStyleNotification();
            }
        });

        buttonBigViewNotification = (Button) findViewById(R.id.buttonBigViewNotification);
        buttonBigViewNotification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                addBigViewNotification();
            }
        });

        buttonBigPictureNotification = (Button) findViewById(R.id.buttonBigPictureNotification);
        buttonBigPictureNotification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                addBigPictureNotification();
            }
        });

        buttonCustomNotification = (Button) findViewById(R.id.buttonCustomNotification);
        buttonCustomNotification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                addCustomNotification();
            }
        });

        buttonToastNotification = (Button) findViewById(R.id.buttonToastNotification);
        buttonToastNotification.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addToast();
            }
        });

        buttonCustomToastNotification = (Button) findViewById(R.id.buttonCustomToastNotification);
        buttonCustomToastNotification.setOnClickListener(( new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                addCustomToast();
            }
        }));


    }

    private void addBasicNoticication()
    {
        NotificationCompat.Builder mBuilder = (android.support.v7.app.NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.icn)
                .setContentTitle("Basic Notification")
                .setContentText("Counter = " + Counter)
                .setAutoCancel(true);
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,0,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,mBuilder.build());
    }
    private void addInboxStyleNotification()
    {
        NotificationCompat.Builder mBuilder = (android.support.v7.app.NotificationCompat.Builder) new NotificationCompat.Builder(
                this).setSmallIcon(R.drawable.icn)
                .setContentTitle("Inbox Style Notification");
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("info");
        inboxStyle.addLine("123");
        inboxStyle.addLine("3453");
        mBuilder.setStyle(inboxStyle);
        mBuilder.setNumber(1);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());


    }
    private void addBigViewNotification()
    {
        NotificationCompat.Builder mBuilder = (android.support.v7.app.NotificationCompat.Builder) new NotificationCompat.Builder(
                this).setSmallIcon(R.drawable.icn)
                .setContentTitle("BigText Style Notification");
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText("This is a very " +
                "very very very very very very very very very very very very very" +
                "very very very very long long long long long long long long long long long long long long" +
                "long long long long long long long long long long long long long long" +
                "long long long long long long long long long long long long long long" +
                "long long long long long long long long long long long long long long text");
        mBuilder.setStyle(bigTextStyle);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }
    private void addBigPictureNotification()
    {
        NotificationCompat.Builder mBuilder = (android.support.v7.app.NotificationCompat.Builder) new NotificationCompat.Builder(
                this).setSmallIcon(R.drawable.icn)
                .setContentTitle("BigPicture Style Notification");
        NotificationCompat.BigPictureStyle bigPictureStyle  = new NotificationCompat.BigPictureStyle();
        // przetworzenie obrazu z drawable na bitmape
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.big_icn));
        mBuilder.setStyle(bigPictureStyle);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }
    private void addCustomNotification()
    {
        Counter++;
        NotificationCompat.Builder mBuilder = (android.support.v7.app.NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.icn)
                .setContentTitle("Custom Notification")
                .setColor(124452)
                .setContentText("Hey Guys")
                .setAutoCancel(true);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,mBuilder.build());

    }
    private void addToast()
    {
        Context context = getApplicationContext();
        CharSequence text = "Toast notification!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void addCustomToast()
    {
        Context context = getApplicationContext();
        CharSequence text = "Toast custom notification";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,text, duration);
        toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
        toast.show();
    }
}
