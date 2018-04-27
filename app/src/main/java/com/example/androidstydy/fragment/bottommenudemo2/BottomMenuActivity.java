package com.example.androidstydy.fragment.bottommenudemo2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.androidstydy.R;

public class BottomMenuActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView txtTopBar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;

    private SimpleFragment fg1, fg2, fg3, fg4;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu2);

        fm = getSupportFragmentManager();

        txtTopBar = findViewById(R.id.txt_topbar);

        rg_tab_bar = findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);

        rb_channel = findViewById(R.id.rb_channel);
        rb_channel.setChecked(true);
        txtTopBar.setText(R.string.tab_menu_alert);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = fm.beginTransaction();
        hideAllFragment(transaction);
        Bundle bundle = new Bundle();
        switch (checkedId) {
            case R.id.rb_channel:
                if (fg1 == null) {
                    fg1 = new SimpleFragment();
                    bundle.putString(SimpleFragment.TXT_CONTENT, "这是第一个 fragment，这是提醒页面");
                    fg1.setArguments(bundle);
                    transaction.add(R.id.ly_content, fg1);
                } else {
                    transaction.show(fg1);
                }
                txtTopBar.setText(R.string.tab_menu_alert);
                break;
            case R.id.rb_message:
                if (fg2 == null) {
                    fg2 = new SimpleFragment();
                    bundle.putString(SimpleFragment.TXT_CONTENT, "这是第二个 fragment，这是消息页面");
                    fg2.setArguments(bundle);
                    transaction.add(R.id.ly_content, fg2);
                } else {
                    transaction.show(fg2);
                }
                txtTopBar.setText(R.string.tab_menu_profile);
                break;
            case R.id.rb_better:
                if (fg3 == null) {
                    fg3 = new SimpleFragment();
                    bundle.putString(SimpleFragment.TXT_CONTENT, "这是第三个 fragment，这是我的页面");
                    fg3.setArguments(bundle);
                    transaction.add(R.id.ly_content, fg3);
                } else {
                    transaction.show(fg3);
                }
                txtTopBar.setText(R.string.tab_menu_pay);
                break;
            case R.id.rb_setting:
                if (fg4 == null) {
                    fg4 = new SimpleFragment();
                    bundle.putString(SimpleFragment.TXT_CONTENT, "这是第四个 fragment，这是设置页面");
                    fg4.setArguments(bundle);
                    transaction.add(R.id.ly_content, fg4);
                }else{
                    transaction.show(fg4);
                }
                txtTopBar.setText(R.string.tab_menu_setting);
                break;
        }
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction ft) {
        if (fg1 != null) {
            ft.hide(fg1);
        }
        if (fg2 != null) {
            ft.hide(fg2);
        }
        if (fg3 != null) {
            ft.hide(fg3);
        }
        if (fg4 != null) {
            ft.hide(fg4);
        }
    }
}
