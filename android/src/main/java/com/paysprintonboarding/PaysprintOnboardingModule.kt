package com.paysprintonboarding

import android.app.Activity
import android.content.Intent
import com.facebook.react.bridge.ActivityEventListener
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.paysprint.onboardinglib.activities.HostActivity

@ReactModule(name = PaysprintOnboardingModule.NAME)
class PaysprintOnboardingModule(reactContext: ReactApplicationContext) :
  NativePaysprintOnboardingSpec(reactContext), ActivityEventListener  {

  private var promise: Promise? = null
  private val REQUEST_CODE = 1111

  init {
    reactContext.addActivityEventListener(this)
  }

  override fun getName(): String {
    return NAME
  }


  override fun startPaysprintOnBoarding(
    partnerId: String,
    partnerApiKey: String,
    merchantCode: String,
    merchantMobile: String,
    firmName: String,
    email: String,
    lat: String,
    lng: String,
    pipe: String,
    promise: Promise
  ) {
    val currentActivity = reactApplicationContext.currentActivity
    if (currentActivity == null) {
      promise.reject("NO_ACTIVITY", "Current activity is null")
      return
    }

    this.promise = promise

    val intent = Intent(currentActivity, HostActivity::class.java).apply {
      putExtra("pId", partnerId)
      putExtra("pApiKey", partnerApiKey)
      putExtra("mCode", merchantCode)
      putExtra("mobile", merchantMobile)
      putExtra("lat", lat)
      putExtra("pipe", pipe)
      putExtra("lng", lng)
      putExtra("firm", firmName)
      putExtra("email", email)
    }

    currentActivity.startActivityForResult(intent, REQUEST_CODE)
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android

  override fun onActivityResult(
    activity: Activity,
    requestCode: Int,
    resultCode: Int,
    data: Intent?
  ) {
    if (requestCode == REQUEST_CODE && promise != null) {
      if (resultCode == Activity.RESULT_OK) {
        val map = Arguments.createMap().apply {
          putBoolean("status", data?.getBooleanExtra("status", false) ?: false)
          putInt("response", data?.getIntExtra("response", 0) ?: 0)
          putString("message", data?.getStringExtra("message") ?: "")
        }
        promise?.resolve(map)
      } else {
        promise?.reject("CANCELLED", "User cancelled the onboarding")
      }
      promise = null
    }
  }

  override fun onNewIntent(intent: Intent) {
    TODO("Not yet implemented")
  }

  companion object {
    const val NAME = "PaysprintOnboarding"
  }
}
