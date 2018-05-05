package com.example.androidstydy.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.androidstydy.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainThreadActivity extends AppCompatActivity {

    private int[] imgids = new int[]{
            R.drawable.tiger_one, R.drawable.tiger_two,
            R.drawable.tiger_three, R.drawable.tiger_four,
            R.drawable.tiger_five, R.drawable.tiger_six,
            R.drawable.tiger_seven, R.drawable.tiger_eight
    };
    private ImageView imageView;

    int currImg = 0;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                imageView.setImageResource(imgids[currImg++ % 8]);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thread);

        imageView = findViewById(R.id.imgchange);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 150);
    }
}
