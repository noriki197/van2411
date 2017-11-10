package androidcndd.bkdn.cvn.a311;

import android.app.Dialog;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by PC on 28-Sep-17.
 */

public class Music extends Service {
    MediaPlayer mediaPlayer;
    Dialog dialog;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this,R.raw.nc);
        mediaPlayer.start();
        return START_NOT_STICKY;
    }
}
