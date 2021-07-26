package com.aide.ui.views;

import abcd.ru;
import abcd.su;
import abcd.tu;
import abcd.uu;
import abcd.wu;
import abcd.xu;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.aide.common.g;
import com.s1243808733.aide.MainListener;

@xu
public class SplitView extends ViewGroup {

	@Override
	protected void onLayout(boolean p1, int p2, int p3, int p4, int p5) {
	}
	public SplitView(Context context){
		super(context);
	}
    @tu
    private static /* synthetic */ boolean $ON_ENTER_TOGGLE;
    @uu
    private static /* synthetic */ boolean $ON_THROW_TOGGLE;
    @ru(field = 305945481744851643L)
    private int animationPosition;
    @ru(field = -2220986906469670848L)
    private float dividerSpeed;
    @ru(field = 4376198832526380827L)
    private int dividerTouchSize;
    @ru(field = -2458900430770018197L)
    private int dragPosition;
    @ru(field = 6275994694731359941L)
    private float horizontalSplitRatio;
    @ru(field = -193356825386921805L)
    private boolean isDragging;
    @ru(field = 2965806935283339056L)
    private boolean isHorizontal;
    @ru(field = 1123020794462061216L)
    private boolean isSplit;
    @ru(field = -5477289533579244069L)
    private boolean isSwipeEnabled;
    @ru(field = 1306040584426626732L)
   // private a listener;
    @ru(field = -371747001152055781L)
    private float verticalSplitRatio;

    
}
