package com.example.androidstydy.drawer.twodrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidstydy.R;

public class RightFragment extends Fragment implements View.OnClickListener {

    private DrawerLayout drawer_layout;
    private FragmentManager fm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        view.findViewById(R.id.btn_one).setOnClickListener(this);
        view.findViewById(R.id.btn_two).setOnClickListener(this);
        view.findViewById(R.id.btn_three).setOnClickListener(this);

        fm = getActivity().getSupportFragmentManager();
        return view;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.drawer_layout = drawerLayout;
    }


    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        ContentFragment fragment = null;
        switch (v.getId()) {
            case R.id.btn_one:
                fragment = new ContentFragment();
                bundle.putInt(ContentFragment.CONTENT_BG, R.color.blue);
                bundle.putString(ContentFragment.CONTENT, "1.你点击了右侧菜单项一");
                break;
            case R.id.btn_two:
                fragment = new ContentFragment();
                bundle.putInt(ContentFragment.CONTENT_BG, R.color.red);
                bundle.putString(ContentFragment.CONTENT, "2.你点击了右侧菜单项二");
                break;
            case R.id.btn_three:
                fragment = new ContentFragment();
                bundle.putInt(ContentFragment.CONTENT_BG, R.color.yellow);
                bundle.putString(ContentFragment.CONTENT, "3.你点击了右侧菜单项三");
                break;
        }

        fragment.setArguments(bundle);
        fm.beginTransaction().replace(R.id.fly_content, fragment).commit();
        drawer_layout.closeDrawer(Gravity.END);
    }
}
