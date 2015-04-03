package com.tronacademy.test;

import com.tronacademy.phantom.controls.Joystick;
import com.tronacademy.phantom.utils.ControlInputListener;

import android.support.v7.app.ActionBarActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class JoystickTest extends ActionBarActivity {
	
	private Joystick mJoystick;
	private CheckBox mJoystickEnableSwitch;
	private TextView[] mIndicatorPos = new TextView[2];
	private CheckBox mIndicatorTracking;
	private CheckBox mIndicatorBound;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joysticktest_activity);
		
		// binding objects to view element
		mJoystick = (Joystick) findViewById(R.id.joystick1);
		
		mJoystickEnableSwitch = (CheckBox) findViewById(R.id.joystickSwitch);
		
		mIndicatorPos[0] = (TextView) findViewById(R.id.indicatorPosX);
		mIndicatorPos[1] = (TextView) findViewById(R.id.indicatorPosY);
		
		mIndicatorTracking = (CheckBox) findViewById(R.id.indicatorTrack);
		
		mIndicatorBound = (CheckBox) findViewById(R.id.indicatorBoundary);
		
		final Resources res = getResources(); 
		
		mJoystickEnableSwitch.setText(
				String.format(res.getString(R.string.ctlinpt_enable_label), mJoystick.mName));
		mJoystickEnableSwitch.setChecked(true);
		
		String posIndicatorTmplt =res.getString(R.string.pos_indicator);
		// set text labels
		for (int i=0; i<mJoystick.getNumOfSubChans(); i++) {
			mIndicatorPos[i].setText(String.format(posIndicatorTmplt, i, 0));
		} 
		
		// bind events
		mJoystickEnableSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				mJoystick.setTouchable(isChecked);
				
			}
		});
		
		mJoystick.setControlInputListener(new ControlInputListener() {

			@Override
			public void onSubChanValChanged(View view, int subchannel,
					byte value) {
				
				String indicatorText = String.format(
						res.getString(R.string.pos_indicator), 
						subchannel, 
						value);
				
				mIndicatorPos[subchannel].setText(indicatorText);
			}

			@Override
			public void onStartTracking(View view) {
				mIndicatorTracking.setSelected(true);
			}

			@Override
			public void onReleaseTracking(View view) {
				mIndicatorTracking.setSelected(false);
			}

			@Override
			public void onTrackerHitBoundary(View view) {
				mIndicatorBound.setSelected(true);
			}
			
			@Override
			public void onTrackerLeaveBoundary(View view) {
				mIndicatorBound.setSelected(false);
			}
		}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.joystick_test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
