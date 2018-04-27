package com.example.androidstydy.fragment.bottommenudemo3;

import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidstydy.R;

import org.w3c.dom.Text;

public class BottomMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView topBar;

    private TextView channel;
    private TextView channelNum;
    private TextView message;
    private TextView messageNum;
    private TextView better;
    private TextView betterNum;
    private TextView setting;
    private TextView settingNum;

    private android.support.v4.app.FragmentManager fm;
    private SimpleFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu3);

        bindView();

        fm = getSupportFragmentManager();
        fragment = new SimpleFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.ly_content, fragment);
        ft.commit();

        channel.performClick();
    }

    private void bindView() {
        topBar = findViewById(R.id.txt_topbar);

        channel = findViewById(R.id.tab_menu_channel);
        channelNum = findViewById(R.id.tab_menu_channel_num);

        message = findViewById(R.id.tab_menu_message);
        messageNum = findViewById(R.id.tab_menu_message_num);

        better = findViewById(R.id.tab_menu_better);
        betterNum = findViewById(R.id.tab_menu_better_num);

        setting = findViewById(R.id.tab_menu_setting);
        settingNum = findViewById(R.id.tab_menu_setting_num);

        channel.setOnClickListener(this);
        message.setOnClickListener(this);
        better.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    private void unSelectedAll() {
        channel.setSelected(false);
        message.setSelected(false);
        better.setSelected(false);
        setting.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_menu_channel:
                unSelectedAll();
                channel.setSelected(true);
                topBar.setText(R.string.tab_menu_alert);
                channelNum.setVisibility(View.INVISIBLE);
                fragment.resetNum(SimpleFragment.CHANNEL_NUM);
                break;
            case R.id.tab_menu_message:
                unSelectedAll();
                message.setSelected(true);
                topBar.setText(R.string.tab_menu_profile);
                messageNum.setVisibility(View.INVISIBLE);
                fragment.resetNum(SimpleFragment.MESSAGE_NUM);
                break;
            case R.id.tab_menu_better:
                unSelectedAll();
                better.setSelected(true);
                topBar.setText(R.string.tab_menu_pay);
                betterNum.setVisibility(View.INVISIBLE);
                fragment.resetNum(SimpleFragment.BETTER_NUM);
                break;
            case R.id.tab_menu_setting:
                unSelectedAll();
                setting.setSelected(true);
                topBar.setText(R.string.tab_menu_setting);
                settingNum.setVisibility(View.INVISIBLE);
                fragment.resetNum(SimpleFragment.SETTING_NUM);
                break;
        }
    }
}
