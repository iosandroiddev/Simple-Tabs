package com.androiddevios.simpletabs.firsttab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androiddevios.simpletabs.BaseFragment;
import com.androiddevios.simpletabs.R;
import com.androiddevios.simpletabs.TabFragmentActivity;

public class FirstTab extends BaseFragment implements OnClickListener {

	View mCurrenView;
	Button mbtnPush, mbtnPop;
	TextView mtxtTitle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		mCurrenView = inflater.inflate(R.layout.fragment_view, null);
		mCurrenView.setBackgroundColor(Color.YELLOW);
		loadTheFragment();
		return mCurrenView;
	}

	private void loadTheFragment() {
		setUpReferences();
		setValues();
		setClickEvents();
	}

	private void setUpReferences() {
		mbtnPush = (Button) mCurrenView.findViewById(R.id.btnPush);
		mbtnPop = (Button) mCurrenView.findViewById(R.id.btnPop);
		mtxtTitle = (TextView) mCurrenView.findViewById(R.id.txtTitle);
	}

	private void setValues() {
		mbtnPush.setText("Push");
		mbtnPop.setText("Exit");
		mtxtTitle.setText("First Tab");
	}

	private void setClickEvents() {
		mbtnPop.setOnClickListener(this);
		mbtnPush.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnPush:
			btnPushClicked();
			break;
		case R.id.btnPop:
			btnPopClicked();
		default:
			break;
		}
	}

	private void btnPopClicked() {
		((TabFragmentActivity) getActivity()).onBackPressed();
	}

	private void btnPushClicked() {
		SubFirstTab subTab = new SubFirstTab();
		addFragment(subTab);
	}

}
