package com.androiddevios.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.androiddevios.simpletabs.R;

public class CustomTextView extends TextView {

	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		try {
			TypedArray a = context.obtainStyledAttributes(attrs,
					R.styleable.Font, defStyle, 0);

			String str = a.getString(R.styleable.Font_type);
			a.recycle();
			switch (Integer.parseInt(str)) {
			case 0:
				str = "fonts/Trebuchet_MS.ttf";
				break;
			default:
				break;
			}

			setTypeface(FontManager.getInstance(getContext()).loadFont(str));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CustomTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	@SuppressWarnings("unused")
	private void internalInit(Context context, AttributeSet attrs) {

	}
}
