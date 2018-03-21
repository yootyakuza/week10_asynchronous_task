package com.example.apple.week10_asynchronous_task;

import android.os.AsyncTask;
import android.widget.TextView;


/**
 * Created by apple on 21/3/2018 AD.
 */

class MyTask extends AsyncTask<String, Integer, String>{//จาก param doInBackground, onProgressUpdate,onPostExecute สามารถแก้ไขได้ตามต้องการ
    TextView tv;

    public MyTask(TextView tv) {
        this.tv = tv;
    }

//    @Override
//    protected void onPreExecute() {
//
//    }

    @Override
    protected String doInBackground(String... param) {//... = Array ที่ไม่จำเป็นต้องระบุค่าจำนวนของ array ล่วงหน้า

        String myString = param[0];//เรียก param 0

        for(int i = 1; i <= myString.length(); i++){
            publishProgress(i);//อัพเดทไปที่คือมันจะเรียก ฟังชั่น onProgressUpdate ส่งค่าไปทีละ 1
            doSleepFor();
        }
        return "End loop";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        tv.setText(values[0].toString());
    }

    private void doSleepFor() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        tv.setText(result);// เมิื่อจบการทำงานจะ return end loop ไป TextView
    }
}

