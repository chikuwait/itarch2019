package com.example.itarch2019

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import android.util.Log

class MyService : Service() {
    override fun onCreate(){
        super.onCreate()
    }
    override fun onBind(intent : Intent): IBinder {
        return mBinder
    }
    val TAG = "Service"
    private val mBinder = object : IMyAidlInterface.Stub() {
        @Throws(RemoteException::class)
        override fun calc(): Int {
            Log.d(TAG, "startCalcColor")
            return 100
        }
    }

}
