package com.example.androidstydy.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidstydy.R;

public class SubMenuActivity extends AppCompatActivity {

    private TextView subMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        subMenu = findViewById(R.id.sub_menu);

        registerForContextMenu(subMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_sub, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one_one:
                toastMes("父菜单一的第一个子菜单");
                break;
            case R.id.one_two:
                toastMes("父菜单一的第二个子菜单");
                break;
            case R.id.one_three:
                toastMes("父菜单一的第三个子菜单");
                break;
            case R.id.two_one:
                toastMes("父菜单二的第一个子菜单");
                break;
            case R.id.two_two:
                toastMes("父菜单二的第二个子菜单");
                break;
            case R.id.two_three:
                toastMes("父菜单二的第三个子菜单");
                break;
        }
        return true;
    }

    private void toastMes(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
