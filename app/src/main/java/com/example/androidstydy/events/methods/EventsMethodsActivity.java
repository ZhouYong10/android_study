package com.example.androidstydy.events.methods;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidstydy.R;

public class EventsMethodsActivity extends AppCompatActivity {
    private MyButton btn;
    private Button btnClear;
    private TextView msgShower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_methods);

        btn = findViewById(R.id.test_btn);
        btnClear = findViewById(R.id.btn_clear);
        msgShower = findViewById(R.id.mes_show);
        msgShower.setMovementMethod(ScrollingMovementMethod.getInstance());

        btn.setShower(msgShower);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.clearMsg();
                msgShower.setText("");
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        btn.appendMsg("EventsMethodsActivity.onTouchEvent: \n");
        btn.showMsg("");
        return super.onTouchEvent(event);
    }
}

