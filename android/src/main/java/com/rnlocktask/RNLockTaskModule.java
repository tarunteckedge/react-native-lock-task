
package com.rnlocktask;

import android.app.Activity;
import android.view.WindowManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNLockTaskModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNLockTaskModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNLockTask";
  }

  @ReactMethod
  public  void lockNow() {
    try {
      Activity mActivity = reactContext.getCurrentActivity();
      if (mActivity != null) {
        DevicePolicyManager myDevicePolicyManager = (DevicePolicyManager) mActivity.getSystemService(Context.DEVICE_POLICY_SERVICE);
        myDevicePolicyManager.lockNow();
      }
    } catch (Exception e) {
    }
  }
}
