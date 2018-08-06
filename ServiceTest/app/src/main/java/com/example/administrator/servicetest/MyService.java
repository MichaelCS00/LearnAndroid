package com.example.administrator.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.Bidi;

public class MyService extends Service {
    private final String TAG = "MichaelCS";

    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.i(TAG, "startDownload: executed");
        }
        public int getProgress(){
            Log.i(TAG, "getProgress: executed");
            return 0;
        }
    }


    //TO DO!!!!!!


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: executed");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: executed");
    }
}
