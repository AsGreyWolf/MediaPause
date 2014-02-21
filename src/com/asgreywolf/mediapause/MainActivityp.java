package com.asgreywolf.mediapause;


import java.io.DataOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;

public class MainActivityp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Process p = null;
		try {
			p=Runtime.getRuntime().exec("su");
		} catch (IOException e) {
			finish();
		}
		DataOutputStream os=new DataOutputStream(p.getOutputStream());
		try {
			os.writeBytes("input keyevent 88\n");
			os.writeBytes("exit\n");
			os.flush();
		} catch (IOException e) {
			finish();
		}
		finish();
	}
}