package com.example.androidstydy.fragment.bottommenudemo3;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidstydy.R;

public class SimpleFragment extends Fragment implements View.OnClickListener {
    public static final String CHANNEL_NUM = "channel_num";
    public static final String MESSAGE_NUM = "message_num";
    public static final String BETTER_NUM = "better_num";
    public static final String SETTING_NUM = "setting_num";

    private Activity parent;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;

    private int channelNum = 0;
    private int messageNum = 0;
    private int betterNum = 0;
    private int settingNum = 0;

    public void resetNum(String type) {
        switch (type) {
            case CHANNEL_NUM:
                channelNum = 0;
                break;
            case MESSAGE_NUM:
                messageNum = 0;
                break;
            case BETTER_NUM:
                betterNum = 0;
                break;
            case SETTING_NUM:
                settingNum = 0;
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple2, container, false);
        btnOne = view.findViewById(R.id.btn_one);
        btnTwo = view.findViewById(R.id.btn_two);
        btnThree = view.findViewById(R.id.btn_three);
        btnFour = view.findViewById(R.id.btn_four);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);

        parent = getActivity();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                channelNum++;
                TextView channelNumView = parent.findViewById(R.id.tab_menu_channel_num);
                channelNumView.setText(channelNum > 99 ? "99+" : String.valueOf(channelNum));
                channelNumView.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_two:
                messageNum++;
                TextView messageNumView = parent.findViewById(R.id.tab_menu_message_num);
                messageNumView.setText(messageNum > 99 ? "99+" : String.valueOf(messageNum));
                messageNumView.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_three:
                betterNum++;
                TextView betterNumView = parent.findViewById(R.id.tab_menu_better_num);
                betterNumView.setText(betterNum > 99 ? "99+" : String.valueOf(betterNum));
                betterNumView.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_four:
                settingNum++;
                TextView settingNumView = parent.findViewById(R.id.tab_menu_setting_num);
                settingNumView.setText(settingNum > 99 ? "99+" : String.valueOf(settingNum));
                settingNumView.setVisibility(View.VISIBLE);
                break;
        }
    }
}
