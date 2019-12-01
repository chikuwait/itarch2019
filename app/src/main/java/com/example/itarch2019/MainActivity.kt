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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    var mBound = false
    var mService: MyService? = null
    private val mAidlConnection = AidlConnection()
    private var mServiceAidl: IMyAidlInterface? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val invokeNotificationAIDLEButton = findViewById<Button>(R.id.button)
        invokeNotificationAIDLEButton.setOnClickListener {
            val _mServiceAidl = mServiceAidl
            if(editText.text != null){
                // 取得したテキストを TextView に張り付ける
                var ret = ""
                try {
                    ret = _mServiceAidl!!.getModel(editText.text.toString())
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
                textView.text = ret
                Log.d(TAG, "#### Received : " + ret);
            }

        }
    }

    override fun onStart() {
        super.onStart()
        val intentAidl = Intent().setComponent(ComponentName("com.example.itarch2019", "com.example.itarch2019.MyService"))
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
