package com.example.androidstydy.events.touchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidstydy.R;

public class TouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        ImageView touch = findViewById(R.id.imgtouch);

        touch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(TouchActivity.this, "你通过监听器模式：OnTouchListener摸了伦家~~", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
