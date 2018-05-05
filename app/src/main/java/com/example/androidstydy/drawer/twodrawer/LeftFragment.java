package com.example.androidstydy.drawer.twodrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidstydy.R;

public class LeftFragment extends Fragment {

    private DrawerLayout drawer_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        Button btn_one = view.findViewById(R.id.btn_one);
        Button btn_two = view.findViewById(R.id.btn_two);

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "你点击了右边侧滑菜单的菜单一", Toast.LENGTH_SHORT).show();
                drawer_layout.closeDrawer(Gravity.START);
            }
        });

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "你点击了右边侧滑菜单的菜单二", Toast.LENGTH_SHORT).show();
                drawer_layout.closeDrawer(Gravity.START);
            }
        });
        return view;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.drawer_layout = drawerLayout;
    }

}
