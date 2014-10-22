package com.example.myfirstapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyMarquee extends TextView{

	public MyMarquee(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
/*
	@Override
	public boolean hasFocus() {
		// TODO Auto-generated method stub
		return super.hasFocus();
	}

	@Override
	public boolean hasFocusable() {
		// TODO Auto-generated method stub
		return super.hasFocusable();
	}
*/
	@Override
	public boolean isFocused() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
