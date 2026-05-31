package com.networkmonitorpro;

import android.app.Application;
import com.google.android.material.color.DynamicColors;
import com.networkmonitorpro.service.NotificationHelper;
import com.networkmonitorpro.worker.CleanupWorker;
import androidx.work.*;
import java.util.concurrent.TimeUnit;

public class NetworkMonitorApplication extends Application {
 @Override public void onCreate(){ super.onCreate(); DynamicColors.applyToActivitiesIfAvailable(this); NotificationHelper.createChannels(this); WorkManager.getInstance(this).enqueueUniquePeriodicWork("cleanup", ExistingPeriodicWorkPolicy.UPDATE, new PeriodicWorkRequest.Builder(CleanupWorker.class,1,TimeUnit.DAYS).build()); }
}
