package com.example.apple.week10_asynchronous_task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadImageTask extends AppCompatActivity {
    Button but3;
    TextView tv;
    ImageView imageView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image_task);
        but3 = findViewById(R.id.buttonShowImg);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar1);
        tv = findViewById(R.id.textViewShowimg);

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imgUrl = "https://wallpaperscraft.com/image/mountains_sky_clouds_mountain_range_stones_99500_1920x1080.jpg";
                new LoadImageTask2(imageView,progressBar,tv).execute(imgUrl);
            }
        });
    }
}
