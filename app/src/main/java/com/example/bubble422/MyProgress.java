package com.example.bubble422;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;

public class MyProgress extends View {

    private int maxProgress;
    private int curProgress;
    private int lineHeight;
    private int lineLength;
    private int circleDiameter;
    private int selectedColor;
    private int noSelectedColor;
    private int width = 0;
    private int height = 0;
    private int w;
    private int h;

    public MyProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.MyProgress, 0, 0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.MyProgress_maxprogrss:
                    maxProgress = typedArray.getInteger(i, 5);
                    break;
                case R.styleable.MyProgress_curprogrss:
                    curProgress = typedArray.getInteger(i, 5);
                    curProgress = curProgress > maxProgress ? maxProgress
                            : curProgress;
                    break;
                case R.styleable.MyProgress_lineheight:
                    lineHeight = typedArray.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_PX, 6, getResources()
                                            .getDisplayMetrics()));
                    break;
                case R.styleable.MyProgress_linelength:
                    lineLength = typedArray.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_PX, 32, getResources()
                                            .getDisplayMetrics()));
                    ;
                    break;
                case R.styleable.MyProgress_circlediameter:
                    circleDiameter = typedArray.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_PX, 32, getResources()
                                            .getDisplayMetrics()));
                    ;
                    break;
                case R.styleable.MyProgress_selectedcolor:
                    selectedColor = typedArray.getColor(attr, Color.BLUE);
                    break;
                case R.styleable.MyProgress_noselectedcolor:
                    noSelectedColor = typedArray.getColor(attr, Color.BLUE);
                default:
                    break;
            }
        }
        init();
    }

    public MyProgress(Context context) {
        super(context);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int w = circleDiameter + (maxProgress - 1) * lineLength;
        int h = circleDiameter > lineHeight ? circleDiameter : lineHeight;

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                width = getPaddingLeft() + getPaddingRight() + specSize;
                break;
            case MeasureSpec.AT_MOST:
                width = getPaddingLeft() + getPaddingRight() + w;
                break;
        }

        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                height = getPaddingTop() + getPaddingBottom() + specSize;
                break;
            case MeasureSpec.AT_MOST:
                height = getPaddingTop() + getPaddingBottom() + h;
                break;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < maxProgress; i++) {
            RectF oval = new RectF(lineLength * i, height / 2 - circleDiameter
                    / 2, lineLength * i + circleDiameter, height / 2
                    + circleDiameter / 2);

            if (curProgress - 1 > i) {
                canvas.drawLine(circleDiameter / 2 + lineLength * i,
                        height / 2, circleDiameter / 2 + lineLength * (i + 1),
                        height / 2, linePaint);
            }
            if (curProgress <= i) {
                canvas.drawArc(oval, 0, 360, false, nocirclePaint);
            }else{
                canvas.drawArc(oval, 0, 360, false, circlePaint);
            }


        }
    }

    public void setCurProgress(int curProgress) {
        curProgress = curProgress > maxProgress ? maxProgress : curProgress;
        curProgress = curProgress < 0 ? 0 : curProgress;
        this.curProgress = curProgress;
        postInvalidate();
    }

    private Paint linePaint, circlePaint, nocirclePaint;

    private void init() {
        linePaint = new Paint();
        circlePaint = new Paint();
        nocirclePaint = new Paint();
        nocirclePaint.setColor(noSelectedColor);
        circlePaint.setColor(selectedColor);
        linePaint.setColor(selectedColor);
        linePaint.setStrokeWidth(lineHeight);
    }

}