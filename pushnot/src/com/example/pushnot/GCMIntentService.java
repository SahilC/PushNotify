package com.example.pushnot;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

	/**
	 * {@link IntentService} responsible for handling GCM messages.
	 */
	public class GCMIntentService extends GCMBaseIntentService {

		private static final String TAG = "GCMIntentService";

		public GCMIntentService() {
			super("927896247221");
		}

		/**
		 * Issues a notification to inform the user that server has sent a message.
		 */
		private static void generateNotification(Context context, String message) {
			NotificationCompat.Builder mBuilder =
			        new NotificationCompat.Builder(context)
			        .setSmallIcon(R.drawable.ic_launcher)
			        .setContentTitle("GCM notification")
			        .setContentText(message);
			// Creates an explicit intent for an Activity in your app
			Intent resultIntent = new Intent(context, MainActivity.class);

			// The stack builder object will contain an artificial back stack for the
			// started Activity.
			// This ensures that navigating backward from the Activity leads out of
			// your application to the Home screen.
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
			// Adds the back stack for the Intent (but not the Intent itself)
			stackBuilder.addParentStack(MainActivity.class);
			// Adds the Intent that starts the Activity to the top of the stack
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent =
			        stackBuilder.getPendingIntent(
			            0,
			            PendingIntent.FLAG_UPDATE_CURRENT
			        );
			mBuilder.setContentIntent(resultPendingIntent);
			NotificationManager mNotificationManager =
			    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
			// mId allows you to update the notification later on.
			mNotificationManager.notify(0, mBuilder.build());
		}

		@Override
		protected void onError(Context arg0, String arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		protected void onMessage(Context arg0, Intent arg1) {

			Log.d("GCM", "RECIEVED A MESSAGE");
			// Get the data from intent and send to notificaion bar
			generateNotification(arg0, arg1.getStringExtra("message"));
		}

		@Override
		protected void onRegistered(Context arg0, String arg1) {
			Log.d("info", arg1);
			// TODO Auto-generated method stub

		}

		@Override
		protected void onUnregistered(Context arg0, String arg1) {
			// TODO Auto-generated method stub

		}

	}

