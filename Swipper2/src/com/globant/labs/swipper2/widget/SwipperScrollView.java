package com.globant.labs.swipper2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;

public class SwipperScrollView extends ScrollView {

	public SwipperScrollView(Context context) {
		super(context);
	}
	
	public SwipperScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
	
	@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //if (!isFillViewport()) {
        //    return;
        //}

        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //if (heightMode == MeasureSpec.UNSPECIFIED) {
        //    return;
        //}

        int childrenHeight = 0;
        
        if(heightMode == MeasureSpec.EXACTLY) {
	        if (getChildCount() > 0) {
	            final View child = getChildAt(0);
	            int height = getMeasuredHeight();
	            //if (child.getMeasuredHeight() < height) {
	                final FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
	
	                int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
	                        getPaddingLeft() + getPaddingRight(), lp.width);
	                height -= getPaddingTop();
	                height -= getPaddingBottom();
	                int childHeightMeasureSpec =
	                        MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
	
	                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
	                childrenHeight = child.getMeasuredHeight();
	            //}
	        }
        }
        
        setMeasuredDimension(
        		MeasureSpec.getSize(widthMeasureSpec) | MEASURED_STATE_MASK,
        		Math.min(MeasureSpec.getSize(heightMeasureSpec), childrenHeight) | MEASURED_STATE_MASK);
    }

}
