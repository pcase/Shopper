package com.azurehorsecreations.photoalbum.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.InputStream;

/**
 * Created by pattycase on 9/14/17.
 */

public class ImageDownloader {

    private static final String TAG = "ImageDownloader";
    private Bitmap bitmap;
    private Handler handler;
    private String url;

    public void loadImage(String url, Handler handler) {
        this.url = url;
        this.handler = handler;

        DownloadBitmapThread thread = new DownloadBitmapThread();
        thread.start();
    }

    private class DownloadBitmapThread extends Thread {

        @Override
        public void run() {
            bitmap = downloadBitmap(url);
            Message message = new Message();
            message.obj = bitmap;
            handler.sendMessage(message);
        }
    }

    private Bitmap downloadBitmap(String url) {
        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e(TAG + ":" + "Error", e.toString());
        }
        return bitmap;
    }
}
