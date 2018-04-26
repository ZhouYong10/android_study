package com.example.androidstydy.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidstydy.R;

public class FiveMethodsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_methods);

        /*
        * 1. 直接使用匿名内部类作为监听器
        * */
        btn_one = findViewById(R.id.btn_one);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), ((Button)v).getText(), Toast.LENGTH_SHORT).show();
            }
        });

        /*
        * 2. 使用内部类作为监听器
        * */
        btn_two = findViewById(R.id.btn_two);
        btn_two.setOnClickListener(new InnerOnClickListener());

        /*
        * 3. 使用外部类作为监听器
        * */
        btn_three = findViewById(R.id.btn_three);
        btn_three.setOnClickListener(new OuterOnClickListener(this));

        /*
        * 4. 使用当前Activity作为监听器
        * */
        btn_four = findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

    }

    /*
    * 5. 使用标签的 onClick 属性绑定监听器
    * */
    public void onClickFive(View view) {
        Toast.makeText(this, ((Button)view).getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, ((Button)v).getText(), Toast.LENGTH_SHORT).show();
    }

    private class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(FiveMethodsActivity.this, ((Button)v).getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
