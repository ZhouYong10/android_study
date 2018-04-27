package com.example.androidstydy.menus;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.androidstydy.R;

public class OptionMenuActivity extends AppCompatActivity {

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, RED, 4, "红色");
        menu.add(1, GREEN, 2, "绿色");
        menu.add(1, BLUE, 3, "蓝色");
        menu.add(1, YELLOW, 1, "黄色");
        menu.add(1, GRAY, 5, "灰色");
        menu.add(1, CYAN, 6, "蓝绿色");
        menu.add(1, BLACK, 7, "黑色");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
}
