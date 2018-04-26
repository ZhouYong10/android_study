package com.example.androidstydy.events;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidstydy.MainActivity;

class OuterOnClickListener implements View.OnClickListener {
    private Context context;

    public OuterOnClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, ((Button) v).getText(), Toast.LENGTH_SHORT).show();
    }
}
