package com.example.androidstydy.drawer.twodrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidstydy.R;

public class ContentFragment extends Fragment {
    public static final String CONTENT = "ly_content";
    public static final String CONTENT_BG = "content_bg";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle arguments = getArguments();

        View view = inflater.inflate(R.layout.fragment_content2, container, false);
        LinearLayout content_bg = view.findViewById(R.id.content_bg);
        TextView ly_content = view.findViewById(R.id.ly_content);

        content_bg.setBackgroundColor(getResources().getColor(arguments.getInt(ContentFragment.CONTENT_BG)));
        ly_content.setText(arguments.getString(ContentFragment.CONTENT));

        return view;
    }

}
