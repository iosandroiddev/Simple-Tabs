package com.androiddevios.simpletabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				navigateToSimpleTabs();
			}
		}, 1000);

	}

	private void navigateToSimpleTabs() {
		startActivity(new Intent(LoadingActivity.this,
				TabFragmentActivity.class));
		finish();
	}
}
