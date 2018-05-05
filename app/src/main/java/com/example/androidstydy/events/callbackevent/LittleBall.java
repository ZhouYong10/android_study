package com.example.androidstydy.events.callbackevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class LittleBall extends View {
    public float X = 50f;
    public float Y = 50f;

    Paint paint = new Paint();

    public LittleBall(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(X, Y, 30, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.X = event.getX();
        this.Y = event.getY();
        this.invalidate();
        return true;
    }
}
