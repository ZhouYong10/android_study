package com.example.androidstydy.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidstydy.R;

public class ContextMenuActivity extends AppCompatActivity {

    private TextView contextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        contextMenu = findViewById(R.id.context_menu);

        // 给指定的view对象注册上下文菜单
        registerForContextMenu(contextMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blue:
                showToast("你选择了蓝色选项");
                break;
            case R.id.green:
                showToast("你选择了绿色的选项");
                break;
            case R.id.red:
                showToast("你选了红色选项");
                break;
        }
        return true;
    }

    private void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
