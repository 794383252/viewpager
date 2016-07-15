package com.imooc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by Administrator on 2016/7/14.
 */
public class viewPagerIndicator extends LinearLayout {

    private Paint mPaint;

    private Path mPath;

    private int triangleWeight;

    private int triangleHeight;

    private static final float RADIO_TRIANG_WIDTH = 1 / 6F;

    private int mInitTranslation;

    private int mTranslation;

    private int mTabVisibleCount;

    private final int COUNT_DEFAULT_TAB = 4;

    public viewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        //获取可见tab的数量
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.viewPagerIndicator);
        mTabVisibleCount = a.getInt(R.styleable.viewPagerIndicator_visiable_tab_count, COUNT_DEFAULT_TAB);
        if (mTabVisibleCount < 0) {
            mTabVisibleCount = COUNT_DEFAULT_TAB;
        }
        //释放TypeArray
        a.recycle();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setColor(Color.parseColor("#ffffffff"));//设置画笔的颜色
        mPaint.setStyle(Paint.Style.FILL);//设置所画的三角形为空心
        mPaint.setPathEffect(new CornerPathEffect(3));//设置三角形的的样式，由他的6个子类实现
    }


    public viewPagerIndicator(Context context) {
        this(context, null);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {

        canvas.save();
        canvas.translate(mInitTranslation + mTranslation, getHeight());
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        super.dispatchDraw(canvas);
    }

    /*
       适合需要知道控件的宽高或者控件的宽高会发生变化的情况
        */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        triangleWeight = (int) (w / mTabVisibleCount * RADIO_TRIANG_WIDTH);
        mInitTranslation = w / mTabVisibleCount / 2 - triangleWeight / 2;
        initTriang();

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int cCount = getChildCount();
        if (cCount == 0) return;
        for (int i = 0; i < cCount; i++) {
            View view = getChildAt(i);
            LinearLayout.LayoutParams lp = (LayoutParams) view.getLayoutParams();
            lp.weight = 0;
            lp.width = getScreenWidth() / mTabVisibleCount;
            view.setLayoutParams(lp);
        }

    }

    //获得屏幕的宽度
    private int getScreenWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /*
        初始化三角形
        注意Y轴向下为负
         */
    private void initTriang() {
        triangleHeight = triangleWeight / 2;
        mPath = new Path();
        mPath.moveTo(0, 0);
        mPath.lineTo(triangleWeight, 0);
        mPath.lineTo(triangleWeight / 2, -triangleHeight);
        mPath.close();
    }

    /**
     * 指示器跟随手指滚动
     *
     * @param position
     * @param Offset
     */
    public void scroll(int position, float Offset) {
        int tabWidth = getWidth() / mTabVisibleCount;
        mTranslation = (int) (tabWidth * Offset + tabWidth * position);
        //scrollTo函数:在当前视图内容偏移至(x , y)坐标处，即显示(可视)区域位于(x , y)坐标处
        if (position > (mTabVisibleCount - 2) && Offset == 0 && getChildCount() > mTabVisibleCount && position < (getChildCount() - 2))
        {
            if (mTabVisibleCount!=1)
            {
                this.scrollTo((position*(mTabVisibleCount-2))*tabWidth+(int)(tabWidth*Offset),0);
            }else {
                this.scrollTo(position*tabWidth+(int)(tabWidth*Offset),0);
            }
        }
            //invalidate函数用来自动刷新view,调用invalidate之后系统会自动调用view的ondraw函数
            invalidate();
    }
}
