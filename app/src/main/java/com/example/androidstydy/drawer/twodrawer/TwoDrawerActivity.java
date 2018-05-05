package com.example.androidstydy.drawer.twodrawer;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.androidstydy.R;

public class TwoDrawerActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = TwoDrawerActivity.class.getSimpleName();

    private DrawerLayout drawer_layout;
    private FrameLayout fly_content;
    private View topbar;
    private Button btn_right;
    private RightFragment fg_right_menu;
    private LeftFragment fg_left_menu;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_drawer);

        fm = getSupportFragmentManager();
        fg_right_menu = (RightFragment) fm.findFragmentById(R.id.fg_right_menu);
        fg_left_menu = (LeftFragment) fm.findFragmentById(R.id.fg_left_menu);

        initViews();
    }

    private void initViews() {
        drawer_layout = findViewById(R.id.drawer_layout);
        fly_content = findViewById(R.id.fly_content);
        topbar = findViewById(R.id.topbar);
        btn_right = findViewById(R.id.btn_right);

        btn_right.setOnClickListener(this);

        //设置右侧的侧滑菜单只能通过按钮点击打开
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);

        drawer_layout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                Log.d(TAG, "onDrawerSlide: ");
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                Log.d(TAG, "onDrawerOpened: ");
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.d(TAG, "onDrawerStateChanged: ");
            }
        });

        fg_left_menu.setDrawerLayout(drawer_layout);
        fg_right_menu.setDrawerLayout(drawer_layout);
    }

    @Override
    public void onClick(View v) {
        drawer_layout.openDrawer(Gravity.RIGHT);
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, Gravity.END);
    }
}
