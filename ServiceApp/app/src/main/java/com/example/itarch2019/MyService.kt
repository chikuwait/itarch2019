package com.example.itarch2019

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R.attr.name



class MyService : Service() {
    override fun onCreate(){
        super.onCreate()
    }
    override fun onBind(intent : Intent): IBinder {
        return mBinder
    }
    val TAG = "Service"
    val model = mapOf<String, String>("JA381A" to "A380-841","JA382A" to "A380-841","JA383A" to "A380-841",
        "JA131A" to "A321-272N","JA132A" to "A321-272N","JA133A" to "A321-272N","JA134A" to "A321-272N","JA135A" to "A321-272N","JA135A" to "A321-272N","JA136A" to "A321-272N","JA137A" to "A321-272N","JA138A" to "A321-272N","JA138A" to "A321-272N","JA139A" to "A321-272N","JA140A" to "A321-272N","JA141A" to "A321-272N",
        "JA111A" to "A321-211","JA112A" to "A321-211","JA113A" to "A321-211","JA114A" to "A321-211",
        "JA211A" to "A320-271N","JA212A" to "A320-271N","JA213A" to "A320-271N","JA214A" to "A320-271N","JA215A" to "A320-271N","JA216A" to "A320-271N","JA217A" to "A320-271N","JA218A" to "A320-271N","JA219A" to "A320-271N","JA220A" to "A320-271N",
        "JA8997" to "A320-211",
        "JA731A" to "B777-381ER","JA732A" to "B777-381ER","JA733A" to "B777-381ER","JA734A" to "B777-381ER","JA735A" to "B777-381ER","JA736A" to "B777-381ER",
        "JA777A" to "B777-381ER","JA778A" to "B777-381ER","JA779A" to "B777-381ER","JA780A" to "B777-381ER","JA781A" to "B777-381ER","JA782A" to "B777-381ER","JA783A" to "B777-381ER","JA784A" to "B777-381ER","JA785A" to "B777-381ER","JA786A" to "B777-381ER","JA787A" to "B777-381ER","JA789A" to "B777-381ER","JA790A" to "B777-381ER","JA791A" to "B777-381ER","JA792A" to "B777-381ER",
        "JA793A" to "B777-300ER","JA794A" to "B777-300ER","JA795A" to "B777-300ER","JA796A" to "B777-300ER","JA797A" to "B777-300ER","JA798A" to "B777-300ER",
        "JA751A" to "B777-381","JA752A" to "B777-381","JA753A" to "B777-381","JA754A" to "B777-381","JA755A" to "B777-381","JA756A" to "B777-381","JA757A" to "B777-381",
        "JA707A" to "B777-281ER","JA708A" to "B777-281ER","JA709A" to "B777-281ER","JA710A" to "B777-281ER","JA715A" to "B777-281ER","JA716A" to "B777-281ER","JA717A" to "B777-281ER","JA741A" to "B777-281ER","JA742A" to "B777-281ER","JA743A" to "B777-281ER","JA744A" to "B777-281ER","JA745A" to "B777-281ER",
        "JA702A" to "B777-281","JA704A" to "B777-281","JA705A" to "B777-281","JA706A" to "B777-281","JA711A" to "B777-281","JA712A" to "B777-281","JA713A" to "B777-281","JA714A" to "B777-281",
        "JA771F" to "B777-F","JA772F" to "B777-F",
        "JA900A" to "B787-10","JA901A" to "B787-10","JA902A" to "B787-10",
        "JA830A" to "B787-9","JA833A" to "B787-9","JA836A" to "B787-9","JA837A" to "B787-9","JA839A" to "B787-9","JA871A" to "B787-9","JA872A" to "B787-9","JA873A" to "B787-9","JA875A" to "B787-9","JA876A" to "B787-9","JA877A" to "B787-9","JA879A" to "B787-9","JA880A" to "B787-9","JA882A" to "B787-9","JA883A" to "B787-9","JA884A" to "B787-9","JA885A" to "B787-9","JA886A" to "B787-9","JA887A" to "B787-9","JA888A" to "B787-9","JA890A" to "B787-9","JA891A" to "B787-9","JA892A" to "B787-9","JA893A" to "B787-9","JA894A" to "B787-9","JA895A" to "B787-9","JA896A" to "B787-9","JA897A" to "B787-9","JA898A" to "B787-9","JA899A" to "B787-9","JA921A" to "B787-9","JA922A" to "B787-9","JA923A" to "B787-9",
        "JA801A" to "B787-8","JA802A" to "B787-8","JA803A" to "B787-8","JA804A" to "B787-8","JA805A" to "B787-8","JA806A" to "B787-8","JA807A" to "B787-8","JA808A" to "B787-8","JA809A" to "B787-8","JA810A" to "B787-8","JA811A" to "B787-8","JA812A" to "B787-8","JA813A" to "B787-8","JA814A" to "B787-8","JA815A" to "B787-8","JA816A" to "B787-8","JA817A" to "B787-8","JA818A" to "B787-8","JA819A" to "B787-8","JA820A" to "B787-8","JA821A" to "B787-8","JA822A" to "B787-8","JA823A" to "B787-8","JA824A" to "B787-8","JA825A" to "B787-8","JA827A" to "B787-8","JA828A" to "B787-8","JA829A" to "B787-8","JA831A" to "B787-8","JA832A" to "B787-8","JA834A" to "B787-8","JA835A" to "B787-8","JA838A" to "B787-8","JA839A" to "B787-8","JA840A" to "B787-8","JA874A" to "B787-8","JA878A" to "B787-8",
        "JA604A" to "B767-381ER","JA605A" to "B767-381ER","JA606A" to "B767-381ER","JA607A" to "B767-381ER","JA608A" to "B767-381ER","JA609A" to "B767-381ER","JA610A" to "B767-381ER","JA611A" to "B767-381ER","JA614A" to "B767-381ER","JA615A" to "B767-381ER","JA616A" to "B767-381ER","JA617A" to "B767-381ER","JA618A" to "B767-381ER","JA619A" to "B767-381ER","JA620A" to "B767-381ER","JA621A" to "B767-381ER","JA622A" to "B767-381ER","JA623A" to "B767-381ER","JA624A" to "B767-381ER","JA625A" to "B767-381ER","JA626A" to "B767-381ER","JA627A" to "B767-381ER",
        "JA8342" to "B767-381","JA8669" to "B767-381"
        )

    private val mBinder = object : IMyAidlInterface.Stub() {
        @Throws(RemoteException::class)
        override fun getModel(aircraft_number: String): String{
            if(model[aircraft_number] != null) {
                return model[aircraft_number]!!
            }else {
                return ""
            }
        }
    }

}
