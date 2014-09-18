package com.allegrogroup.demo.material;

import android.app.Application;

public class MaterialDemoApplication extends Application {
	
	private static MaterialDemoApplication sInstance = null;

	@Override
	public void onCreate() {
		super.onCreate();
		
		sInstance = this;
	}

	public static MaterialDemoApplication getInstance() {
		return sInstance;
	}
}
