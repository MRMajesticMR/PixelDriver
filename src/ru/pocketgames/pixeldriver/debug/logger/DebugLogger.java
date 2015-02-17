package ru.pocketgames.pixeldriver.debug.logger;

import android.util.Log;

public class DebugLogger {
	
	private static final int MODE_DEBUG 			= 0;
	private static final int MODE_PRODUCTION 		= 1;
	
	private static final int CURRENT_MODE = MODE_DEBUG;
//	private static final int CURRENT_VERSION = VERSION_PRODUCTION;
	

	public static boolean isDebugMode() {
		return CURRENT_MODE == MODE_DEBUG;
	}
	
	public static void logDebugI(String tag, String message) {
		if(isDebugMode())
			Log.i(tag, message);
	}

	public static void logDebugW(String tag, String message) {
		if(isDebugMode())
			Log.w(tag, message);		
	}

	public static void logDebugE(String tag, String message) {
		if(isDebugMode())
			Log.e(tag, message);		
	}

	public static void logProductionI(String tag, String message) {
		Log.i(tag, message);
	}

	public static void logProductionW(String tag, String message) {
		Log.w(tag, message);		
	}

	public static void logProductionE(String tag, String message) {
		Log.e(tag, message);		
	}

}
