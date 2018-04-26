package com.example.androidstydy.radioandcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.androidstydy.R;

public class RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        final RadioGroup radioGroup = findViewById(R.id.radio_group);
        Button commit = findViewById(R.id.btn_commit);

        /*
        * 获取选中的 RadioButton 的值：
        * 第一种：（切换单选按钮时获取）
        *   给 RadioGroup 设置 OnCheckedChangeListener ，监听器需要实现一个 onCheckChanged(RadioGroup group, int viewId)
        *   在 onCheckedChanged 方法中，通过 viewId 获取当前选中的 RadioButton ，从而获取当前被选中的值
        *
        *   注意：必须为每个 RadioButton 设置 id，不然单选功能不会生效。
        * */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String value = (String) radioButton.getText();
                Toast.makeText(getApplicationContext(), "按钮值发生了改变，你选择了： " + value, Toast.LENGTH_SHORT).show();
            }
        });

        /*
        * 获取选中的 RadioButton 的值：
        * 第二种：（通过其他控件的事件获取）
        *   通过 RadioGroup 的 getChildCount() 方法获取 RadioGroup 中 RadioButton 的个数
        *   遍历 RadioGroup ，通过 RadioGroup 的 getChildAt(int index) 方法，获取 RadioGroup 中指定索引位置的 RadioButton
        *   通过 RadioButton 的 isChecked() 方法，判断状态是否为选中
        * */
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton rb = (RadioButton) radioGroup.getChildAt(i);
                    if (rb.isChecked()) {
                        Toast.makeText(getApplicationContext(), "点击提交按钮，获取选中的值为：" + rb.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });

    }
}
