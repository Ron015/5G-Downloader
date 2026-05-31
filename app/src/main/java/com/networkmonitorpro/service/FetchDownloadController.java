package com.networkmonitorpro.service;

import android.content.Context;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchConfiguration;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Request;

public class FetchDownloadController {
    private static volatile FetchDownloadController instance;
    private final Fetch fetch;
    private FetchDownloadController(Context context) {
        FetchConfiguration configuration = new FetchConfiguration.Builder(context.getApplicationContext())
                .setDownloadConcurrentLimit(3)
                .enableLogging(true)
                .build();
        fetch = Fetch.Impl.getInstance(configuration);
    }
    public static FetchDownloadController get(Context context) {
        if (instance == null) synchronized (FetchDownloadController.class) { if (instance == null) instance = new FetchDownloadController(context); }
        return instance;
    }
    public void enqueue(String url, String filePath) {
        Request request = new Request(url, filePath);
        request.setPriority(Priority.HIGH);
        request.setNetworkType(NetworkType.ALL);
        fetch.enqueue(request, updated -> { }, error -> { });
    }
    public void pause(int id) { fetch.pause(id); }
    public void resume(int id) { fetch.resume(id); }
    public void cancel(int id) { fetch.cancel(id); }
    public void retry(int id) { fetch.retry(id); }
    public void pauseAll() { fetch.pauseAll(); }
    public void resumeAll() { fetch.resumeAll(); }
}
