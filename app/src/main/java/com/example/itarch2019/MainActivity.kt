package com.example.itarch2019

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    private var mServiceAidl: IMyAidlInterface? = null
    private val mAidlConnection = AidlConnection()
    var mBound = false
    var mService: MyService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val invokeNotificationAIDLEButton = findViewById<Button>(R.id.button)
        invokeNotificationAIDLEButton.setOnClickListener {
            val _mServiceAidl = mServiceAidl
            var ret = 1
            try {
                ret = _mServiceAidl!!.calc()
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
            val _ret = ret
            Log.d(TAG, "#### Received : " + _ret);
        }
    }

    override fun onStart() {
        super.onStart()
        val intentAidl = Intent()
            .setComponent(ComponentName("com.example.itarch2019", "com.example.itarch2019.MyService"))
        val bindAidl = bindService(Intent(this, MyService::class.java), AidlConnection(), Context.BIND_AUTO_CREATE)
        Log.d(TAG, "Bind Aidl Connection "+ bindAidl)
    }

    private inner class AidlConnection : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            mServiceAidl = IMyAidlInterface.Stub.asInterface(service)
            mBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mServiceAidl = null
            mBound = false
        }
    }
}
