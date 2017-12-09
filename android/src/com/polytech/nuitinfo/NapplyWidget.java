package com.polytech.nuitinfo;

/**
 * Created by ha501914 on 28/03/2017.
 */

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

public class NapplyWidget extends AppWidgetProvider {

    public static final String ACTION_SHOW_NOTIFICATION = "com.example.ha501914.anglais_cm2.SHOW_NOTIFICATION";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this
        // provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    /**
     * Update the widget
     *
     * @param context
     * @param appWidgetManager
     * @param appWidgetId
     */
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        // Prepare widget views
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.napply_widget_layout);
        views.setTextViewText(R.id.nap_time, "English widget");

        // Prepare intent to launch on widget click
        Intent intent = new Intent(context, NapplyWidget.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setAction(ACTION_SHOW_NOTIFICATION);

        // Launch intent on widget click
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.napply_widget, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    /**
     * Handle new messages
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (ACTION_SHOW_NOTIFICATION.equals(intent.getAction())) {
            showNotification(context);
        }
    }

    /**
     * Displays a notification message
     * @param context
     */
    protected void showNotification(Context context) {
        CharSequence message = "You're currently learning on our apps. Amazing isn't it ?";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}