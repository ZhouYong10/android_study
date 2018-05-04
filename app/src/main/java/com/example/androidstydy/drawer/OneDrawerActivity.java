package com.example.androidstydy.drawer;

import android.content.ClipData;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.androidstydy.R;

import java.util.ArrayList;
import java.util.List;

public class OneDrawerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listLeftDrawer;
    private ArrayList<Item> menuLists;
    private BaseAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_drawer);

        drawerLayout = findViewById(R.id.drawer_layout);
        listLeftDrawer = findViewById(R.id.list_left_drawer);

        menuLists = new ArrayList<Item>();
        menuLists.add(new Item(R.mipmap.iv_menu_realtime, "实时信息"));
        menuLists.add(new Item(R.mipmap.iv_menu_laert, "提醒通知"));
        menuLists.add(new Item(R.mipmap.iv_menu_trace, "活动路线"));
        menuLists.add(new Item(R.mipmap.iv_menu_settings, "相关设置"));

        adapter = new MyAdapter(this, menuLists, R.layout.item_list);

        listLeftDrawer.setAdapter(adapter);
        listLeftDrawer.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ContentFragment.CONTENT, menuLists.get(position).getTitle());
        fragment.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.ly_content, fragment).commit();
        drawerLayout.closeDrawer(listLeftDrawer);
    }
}
