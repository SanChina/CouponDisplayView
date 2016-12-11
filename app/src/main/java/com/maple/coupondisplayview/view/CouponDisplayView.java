package com.maple.coupondisplayview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by San on 2016/12/11.
 */

public class CouponDisplayView extends LinearLayout {

    private Paint mPaint;

    private float gap = 8; //圆间距
    private float radius = 10; //圆半径
    private int circleCount; //圆数量
    private float remain;

    public CouponDisplayView(Context context) {
        super(context);
    }

    public CouponDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    public CouponDisplayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("onSizeChanged","w:"+ w + "h:"+ h + " " + oldw + " " + oldh);
        if (remain==0){
            remain = (int)(w-gap)%(2*radius+gap);
        }
        circleCount = (int) ((w-gap)/(2*radius+gap));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < circleCount; i++) {
            float x = gap + radius + remain/2 + ((gap+radius*2)*i);
            canvas.drawCircle(x,0,radius,mPaint);
            Log.d("onDraw", "getHeight: " + getHeight());
            canvas.drawCircle(x,getHeight(),radius,mPaint);
        }
    }
}
