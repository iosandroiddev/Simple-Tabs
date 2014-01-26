package com.androiddevios.simpletabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public abstract class BaseFragment extends Fragment {

	protected void addFragment(Fragment child) {
		getParentFrag(this).beginTransaction()
				.replace(R.id.child_container, child, "innerfrag")
				.addToBackStack(null).commitAllowingStateLoss();
	}

	public boolean onBackPressed() {
		if (getChildFragmentManager().getBackStackEntryCount() > 1) {
			getChildFragmentManager().popBackStack();
			return true;
		}
		return false;
	}

	public FragmentManager getParentFrag(Fragment frag) {
		Fragment f = frag.getParentFragment();
		if (f != null) {
			return getParentFrag(f);
		} else
			return frag.getChildFragmentManager();
	}

}
