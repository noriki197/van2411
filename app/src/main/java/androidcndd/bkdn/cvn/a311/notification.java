package androidcndd.bkdn.cvn.a311;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;

public class notification extends Activity {

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i =getIntent();
        String CV = i.getStringExtra("congviec");
        String TG = i.getStringExtra("thoigian");
        String DD = i.getStringExtra("diadiem");

        RemoteViews contentView = new RemoteViews(getPackageName(),R.layout.noti);
        contentView.setTextViewText(R.id.tvCV,"CONG VIEC");
        contentView.setTextViewText(R.id.tvTG,TG);
        contentView.setTextViewText(R.id.tvDD,DD);

        Notification.Builder mbuilder = new Notification.Builder(notification.this);

        mbuilder.setCustomContentView(contentView);
        mbuilder.setSmallIcon(R.drawable.camera);
        Intent intentcancel = new Intent(notification.this,cancel_notification.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(cancel_notification.class);

        stackBuilder.addNextIntent(intentcancel);

        PendingIntent pendingIntentnoti = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        mbuilder.setContentIntent(pendingIntentnoti);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(100,mbuilder.build());


    }
}
