package ro.upt.sma.context.activity

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.google.android.gms.location.ActivityRecognition
import com.google.android.gms.location.ActivityRecognitionClient

class ActivityRecognitionHandler(context: Context) {

    private val client: ActivityRecognitionClient = ActivityRecognition.getClient(context)

    var myContext = context;

    fun registerPendingIntent(): PendingIntent {

    /*TO-DO 5: Create a pending intent for ActivityRecognitionService and register for updates to activity recognition client.*/
        var myIntent = Intent(myContext, ActivityRecognitionService::class.java);

        var pendingIntent = PendingIntent.getService(myContext, 1, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        client.requestActivityUpdates(5000, pendingIntent);

        return pendingIntent;
    }

    fun unregisterPendingIntent(pendingIntent: PendingIntent) {
        client.removeActivityUpdates(pendingIntent)
    }

}
