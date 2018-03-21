package com.example.apple.week10_asynchronous_task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadImageTask2 extends AsyncTask<String, Integer, Bitmap> {
    private ImageView _imgv = null;
    private ProgressBar _pgb = null;
    private TextView tv;


    public LoadImageTask2(ImageView _imgv, ProgressBar _pgb, TextView tv) {
        this._imgv = _imgv;
        this._pgb = _pgb;
        this.tv = tv;
    }

    @Override
    protected Bitmap doInBackground(String... param) {
        Bitmap bitmap = null;
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        try {
            URL url = new URL(param[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int imgSize = connection.getContentLength();
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            int sum = 0;
            while ((len = inputStream.read(buffer)) > 0) {
                byteBuffer.write(buffer, 0, len);
                sum += len;
                float percent = (sum * 100.0f) / imgSize;
                publishProgress((int) percent);
            }
            bitmap = BitmapFactory.decodeByteArray(byteBuffer.toByteArray(), 0, byteBuffer.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    @Override
    protected void onProgressUpdate(Integer... progress) {
        _pgb.setProgress(progress[0]);
        tv.setText(progress[0].toString());
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        _imgv.setImageBitmap(result);
    }
}
