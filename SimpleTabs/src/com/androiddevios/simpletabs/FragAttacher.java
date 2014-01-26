package com.androiddevios.simpletabs;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androiddevios.simpletabs.firsttab.FirstTab;
import com.androiddevios.simpletabs.secondtab.SecondTab;
import com.androiddevios.simpletabs.thirdtab.ThirdTab;

public class FragAttacher extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.frag_attacher_layout, null);

		if (getChildFragmentManager().findFragmentByTag("innerfrag") == null) {

			Fragment child = new FirstTab();
			if (getArguments() != null) {

				String tag = getArguments().getString("tabTab");
				if (tag.equalsIgnoreCase("tab1")) {
					child = new FirstTab();
				} else if (tag.equalsIgnoreCase("tab2")) {
					child = new SecondTab();
				} else if (tag.equalsIgnoreCase("tab3")) {
					child = new ThirdTab();
				}

			}
			getChildFragmentManager().beginTransaction()
					.add(R.id.child_container, child, "innerfrag")
					.addToBackStack(null).commitAllowingStateLoss();
		}
		return view;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		List<Fragment> mList = getChildFragmentManager().getFragments();
		for (Fragment f : mList) {
			try {
				f.onActivityResult(requestCode, resultCode, data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
