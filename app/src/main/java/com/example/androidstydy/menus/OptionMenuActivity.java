package com.example.androidstydy.menus;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidstydy.R;

public class OptionMenuActivity extends AppCompatActivity {
    public static final String TAG = OptionMenuActivity.class.getName();

    private final int RED = 110;
    private final int GREEN = 111;
    private final int BLUE = 112;
    private final int YELLOW = 113;
    private final int GRAY = 114;
    private final int CYAN = 115;
    private final int BLACK = 116;

    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        tv_text = findViewById(R.id.content_msg);
        
        getSupportActionBar().addOnMenuVisibilityListener(new android.support.v7.app.ActionBar.OnMenuVisibilityListener() {
            @Override
            public void onMenuVisibilityChanged(boolean isVisible) {
                if (isVisible) {
                    Log.d(TAG, "onMenuVisibilityChanged: 选项菜单打开了。");
                } else {
                    Log.d(TAG, "onMenuVisibilityChanged: 选项菜单关闭了。");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu: 这个方法用户初始化选项菜单");

        menu.add(1, RED, 4, "红色");
        menu.add(1, GREEN, 2, "绿色");
        menu.add(1, BLUE, 3, "蓝色");
        menu.add(1, YELLOW, 1, "黄色");
        menu.add(2, GRAY, 5, "灰色");
        menu.add(2, CYAN, 6, "蓝绿色");
        menu.add(2, BLACK, 7, "黑色");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: 你点击了 " + item.getTitle());
        switch (item.getItemId()) {
            case RED:
                tv_text.setTextColor(Color.RED);
                break;
            case GREEN:
                tv_text.setTextColor(Color.GREEN);
                break;
            case BLUE:
                tv_text.setTextColor(Color.BLUE);
                break;
            case YELLOW:
                tv_text.setTextColor(Color.YELLOW);
                break;
            case GRAY:
                tv_text.setTextColor(Color.GRAY);
                break;
            case CYAN:
                tv_text.setTextColor(Color.CYAN);
                break;
            case BLACK:
                tv_text.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    * 测试发现，选项菜单关闭时，并没有回调该方法，具体原因暂时不知
    * 下面提供一种检测选项菜单打开和关闭状态的方法：
    * getSupportActionBar().addOnMenuVisibilityListener()
    * 通过上面的方式给选项菜单设置监听器
    * */
    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Log.d(TAG, "onOptionsMenuClosed: 选项菜单关闭时调用这个方法");
        Toast.makeText(this, "选项菜单关闭时调用这个方法", Toast.LENGTH_SHORT).show();
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d(TAG, "onPrepareOptionsMenu: 选项菜单显示前调用该方法，可在这里进行菜单的调整");

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Log.d(TAG, "onMenuOpened: 选项菜单打开了");
        return super.onMenuOpened(featureId, menu);
    }


}
