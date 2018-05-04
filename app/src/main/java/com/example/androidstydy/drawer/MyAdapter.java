package com.example.androidstydy.drawer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidstydy.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Item> menus;
    private int layoutId;

    public MyAdapter(Context context, List<Item> menus, int layoutId) {
        this.context = context;
        this.menus = menus;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);
        Item item = menus.get(position);
        TextView menuItem = view.findViewById(R.id.menu_item);
        menuItem.setText(item.getTitle());
        Drawable drawable = context.getResources().getDrawable(item.getIcon());
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        menuItem.setCompoundDrawables(drawable,null, null, null);
        return view;
    }
}
