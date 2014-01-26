package com.androiddevios.simpletabs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;

public class TabFragmentActivity extends FragmentActivity {

	public ReClickableFragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.fragment_tab);
		setTheTabs();
	}

	private void setTheTabs() {

		mTabHost = (ReClickableFragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.container);

		Bundle mBundle = new Bundle();
		mBundle.putString("tabTab", "tab1");
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("First Tab"),
				FragAttacher.class, mBundle);

		mBundle = new Bundle();
		mBundle.putString("tabTab", "tab2");
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("Second Tab"),
				FragAttacher.class, mBundle);

		mBundle = new Bundle();
		mBundle.putString("tabTab", "tab3");
		mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("Third Tab"),
				FragAttacher.class, mBundle);

		mTabHost.getTabWidget().setBackgroundColor(Color.BLACK);

		mTabHost.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BaseFragment f = (BaseFragment) getSupportFragmentManager()
						.findFragmentByTag(mTabHost.getCurrentTabTag());
				clearStack(f.getChildFragmentManager());
			}

		});

	}

	public void clearStack(FragmentManager fm) {
		for (int i = 0; i < fm.getBackStackEntryCount() - 1; i++)
			fm.popBackStack();
	}

	public static <T extends ImageView> void setTabButtonState(T imageView,
			int selected, int normal) {
		Context ctx = imageView.getContext();
		StateListDrawable states = new StateListDrawable();
		states.addState(new int[] { android.R.attr.state_selected }, ctx
				.getResources().getDrawable(selected));
		states.addState(new int[] { android.R.attr.state_focused }, ctx
				.getResources().getDrawable(selected));
		states.addState(new int[] {}, ctx.getResources().getDrawable(normal));
		imageView.setImageDrawable(states);
	}

	public TabSpec setIndicator(TabSpec spec, int index, String title) {
		View v = LayoutInflater.from(this).inflate(R.layout.tab, null);
		/*
		 * ImageView image = (ImageView) v.findViewById(R.id.imgIcon); TextView
		 * txt = (TextView) v.findViewById(R.id.txtIcon); txt.setText(title);
		 * switch (index) { case 0: setTabButtonState(image,
		 * R.drawable.ic_launcher, R.drawable.ic_launcher); break; case 1:
		 * setTabButtonState(image, R.drawable.ic_launcher, 
		 * R.drawable.ic_launcher); break; case 2: setTabButtonState(image,
		 * R.drawable.ic_launcher, R.drawable.ic_launcher); break; case 3:
		 * setTabButtonState(image, R.drawable.ic_launcher,
		 * R.drawable.ic_launcher); break; case 4: setTabButtonState(image,
		 * R.drawable.ic_launcher, R.drawable.ic_launcher); break; default:
		 * break; }
		 */
		return spec.setIndicator(v);
	}

	@Override
	public void onBackPressed() {

		BaseFragment f = (BaseFragment) getSupportFragmentManager()
				.findFragmentByTag(mTabHost.getCurrentTabTag());
		if (!f.onBackPressed())
			super.onBackPressed();

	}
}
