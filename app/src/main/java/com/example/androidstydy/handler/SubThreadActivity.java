package com.example.androidstydy.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidstydy.R;

import java.util.ArrayList;
import java.util.List;

public class SubThreadActivity extends AppCompatActivity {
    static final String UPPER_NUM = "upper_num";
    EditText etNum;
    CalThread calThread;

    // 自定义一个子线程类
    class CalThread extends Thread{
        // 子线程类中包含一个 Handler 对象
        public Handler mHandler;

        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler() {
                // Handler 接收对应消息运行计算
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0x123) {
                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<>();
                        outer:
                        for (int i = 2; i <= upper; i++) {
                            for (int j = 2; j <= Math.sqrt(i); j++) {
                                if (i != 2 && i % j == 0) {
                                    continue outer;
                                }
                            }
                            nums.add(i);
                        }
                        Toast.makeText(SubThreadActivity.this, nums.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            };
            Looper.loop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_thread);

        etNum = findViewById(R.id.etNum);
        // 创建子线程对象
        calThread = new CalThread();
        // 开启子线程
        calThread.start();
    }

    public void cal(View view) {
        Message msg = new Message();
        msg.what = 0x123;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
        // 使用消息对象携带信息
        msg.setData(bundle);
        // 发送指定消息
        calThread.mHandler.sendMessage(msg);
    }
}
