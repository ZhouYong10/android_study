package com.example.androidstydy.events.methods;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

public class MyButton extends android.support.v7.widget.AppCompatButton {
    private static final String TAG = MyButton.class.getSimpleName();
    private TextView msgShower;
    private String msg = "";

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setShower(TextView view) {
        this.msgShower = view;
    }

    public void showMsg(String s) {
        msg += s;
        msgShower.setText(msg);
    }

    public void setMsg(String s) {
        this.msg = s;
    }

    public void clearMsg() {
        this.msg = "";
    }

    public void appendMsg(String s) {
        this.msg += s;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        showMsg("onTouchEvent: \n");
        Log.d(TAG, "onTouchEvent: ");
        super.onTouchEvent(event);
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        showMsg("onKeyDown: \n");
        Log.d(TAG, "onKeyDown: ");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        showMsg("onKeyUp: \n");
        Log.d(TAG, "onKeyUp: ");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        showMsg("onKeyLongPress: \n");
        Log.d(TAG, "onKeyLongPress: ");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        showMsg("onKeyShortcut: \n");
        Log.d(TAG, "onKeyShortcut: ");
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        showMsg("onTrackballEvent: \n");
        Log.d(TAG, "onTrackballEvent: ");
        return super.onTrackballEvent(event);
    }

    @Override
    public void setSelectAllOnFocus(boolean selectAllOnFocus) {
        showMsg("setSelectAllOnFocus: \n");
        Log.d(TAG, "setSelectAllOnFocus: ");
        super.setSelectAllOnFocus(selectAllOnFocus);
    }
}
