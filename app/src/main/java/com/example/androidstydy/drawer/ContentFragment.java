package com.example.androidstydy.drawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidstydy.R;

public class ContentFragment extends Fragment {
    public static final String CONTENT = "tv_content";
    private TextView tvContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        tvContent = view.findViewById(R.id.tv_content);
        String content = getArguments().getString(CONTENT);
        tvContent.setText(content);
        return view;
    }

}
