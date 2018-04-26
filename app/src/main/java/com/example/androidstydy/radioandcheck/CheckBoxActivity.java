package com.example.androidstydy.radioandcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.androidstydy.R;

public class CheckBoxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox banana;
    private CheckBox apple;
    private CheckBox boluo;
    private Button commit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        banana = findViewById(R.id.checkbox_banana);
        apple = findViewById(R.id.checkbox_apple);
        boluo = findViewById(R.id.checkbox_boluo);
        commit = findViewById(R.id.btn_commit);

        banana.setOnCheckedChangeListener(this);
        apple.setOnCheckedChangeListener(this);
        boluo.setOnCheckedChangeListener(this);
        commit.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Toast.makeText(this, "当前选中的水果是：" + buttonView.getText() + ",状态为：" + isChecked, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        String choose = "";
        if (banana.isChecked()) {
            choose += banana.getText() + " ";
        }
        if (apple.isChecked()) {
            choose += apple.getText() + " ";
        }
        if (boluo.isChecked()) {
            choose += boluo.getText() + " ";
        }
        Toast.makeText(this,"被选中的水果有：" + choose, Toast.LENGTH_SHORT).show();
    }
}
