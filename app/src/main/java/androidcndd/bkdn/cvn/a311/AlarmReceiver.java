package androidcndd.bkdn.cvn.a311;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by PC on 28-Sep-17.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //Intent myIntent = new Intent(context, notification.class);
        //context.startActivity(myIntent);

        Intent myIntent = new Intent(context,Music.class);
        context.startService(myIntent);

    }
}
