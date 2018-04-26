package com.example.androidstydy.fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import com.example.androidstydy.R;

public class DynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        Display display = getWindowManager().getDefaultDisplay();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (display.getWidth() > display.getHeight()) {
            ft.replace(R.id.dynamic_fragment, new DynamicFragment1()).commit();
        } else {
            ft.replace(R.id.dynamic_fragment, new DynamicFragment2()).commit();
        }
    }
}
