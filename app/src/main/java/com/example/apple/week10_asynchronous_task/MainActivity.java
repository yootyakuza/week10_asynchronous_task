package com.example.apple.week10_asynchronous_task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv1;
    EditText editText;
    Button but1, but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText1);
        tv = findViewById(R.id.textView1);
        tv1 = findViewById(R.id.textView);
        but1 = findViewById(R.id.button1);
        but2 = findViewById(R.id.button2);


        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = editText.getText().toString();
                tv1.setText("Length of Text View : " + result.length());
                new MyTask(tv).execute(result);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoadImageTask.class);
                startActivity(intent);
            }
        });
    }
}
