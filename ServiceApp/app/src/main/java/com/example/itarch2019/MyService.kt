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
    val operation = mapOf<String, String>("JA381A" to "国際線運用","JA382A" to "国際線運用","JA383A" to "国際線運用",
        "JA131A" to "国内線運用","JA132A" to "国内線運用","JA133A" to "国内線運用","JA134A" to "国内線運用","JA135A" to "国内線運用","JA135A" to "国内線運用","JA136A" to "国内線運用","JA137A" to "国内線運用","JA138A" to "国内線運用","JA138A" to "国内線運用","JA139A" to "国内線運用","JA140A" to "国内線運用","JA141A" to "国内線運用",
        "JA111A" to "国内線運用","JA112A" to "国内線運用","JA113A" to "国内線運用","JA114A" to "国内線運用",
        "JA211A" to "国際線運用","JA212A" to "国際線運用","JA213A" to "国際線運用","JA214A" to "国際線運用","国際線運用" to "国際線運用","JA216A" to "国際線運用","JA217A" to "国際線運用","JA218A" to "国際線運用","JA219A" to "国際線運用","JA220A" to "国際線運用",
        "JA8997" to "国内線運用",
        "JA731A" to "国際線運用","JA732A" to "国際線運用","JA733A" to "国際線運用","JA734A" to "国際線運用","JA735A" to "国際線運用","JA736A" to "国際線運用",
        "JA777A" to "国際線運用","JA778A" to "国際線運用","JA779A" to "国際線運用","JA780A" to "国際線運用","JA781A" to "国際線運用","JA782A" to "国際線運用","JA783A" to "国際線運用","JA784A" to "国際線運用","JA785A" to "国際線運用","JA786A" to "国際線運用","JA787A" to "国際線運用","JA789A" to "国際線運用","JA790A" to "国際線運用","JA791A" to "国際線運用","JA792A" to "国際線運用",
        "JA793A" to "国際線運用","JA794A" to "国際線運用","JA795A" to "国際線運用","JA796A" to "国際線運用","JA797A" to "国際線運用","JA798A" to "国際線運用",
        "JA751A" to "国内線運用","JA752A" to "国内線運用","JA753A" to "国内線運用","JA754A" to "国内線運用","JA755A" to "国内線運用","JA756A" to "国内線運用","JA757A" to "国内線運用",
        "JA707A" to "国内線運用","JA708A" to "国内線運用","JA709A" to "国内線運用","JA710A" to "国内線運用","JA715A" to "国内線運用","JA716A" to "国内線運用","JA717A" to "国内線運用","JA741A" to "国内線運用","JA742A" to "国内線運用","JA743A" to "国内線運用","JA744A" to "国内線運用","JA745A" to "国内線運用",
        "JA702A" to "国内線運用","JA704A" to "国内線運用","JA705A" to "国内線運用","JA706A" to "国内線運用","JA711A" to "国内線運用","JA712A" to "国内線運用","JA713A" to "国内線運用","JA714A" to "国内線運用",
        "JA771F" to "貨物運用","JA772F" to "貨物運用",
        "JA900A" to "国際線運用","JA901A" to "国際線運用","国際線運用" to "国際線運用",
        "JA830A" to "国内線運用","JA833A" to "国内線運用","JA836A" to "国際線運用","JA837A" to "国際線運用","JA839A" to "国際線運用","JA871A" to "国際線運用","JA872A" to "国際線運用","JA873A" to "国際線運用","JA875A" to "国際線運用","JA876A" to "国際線運用","JA877A" to "国際線運用","JA879A" to "国際線運用","JA880A" to "国際線運用","JA882A" to "国際線運用","JA883A" to "国際線運用","JA884A" to "国際線運用","JA885A" to "国際線運用","JA886A" to "国際線運用","JA887A" to "国際線運用","JA888A" to "国際線運用","JA890A" to "国際線運用","JA891A" to "国際線運用","JA892A" to "国際線運用","JA893A" to "国際線運用","JA894A" to "国際線運用","JA895A" to "国際線運用","JA896A" to "国際線運用","JA897A" to "国際線運用","JA898A" to "国際線運用","JA899A" to "国際線運用","JA921A" to "国際線運用","JA922A" to "国際線運用","JA923A" to "国際線運用",
        "JA801A" to "国際線運用","JA802A" to "国際線運用","JA803A" to "国際線運用","JA804A" to "国際線運用","JA805A" to "国際線運用","JA806A" to "国際線運用","JA807A" to "国際線運用","JA808A" to "国際線運用","JA809A" to "国内線運用","JA810A" to "国内線運用","JA811A" to "国内線運用","JA812A" to "国内線運用","JA813A" to "国際線運用","JA814A" to "国際線運用","JA815A" to "国際線運用","JA816A" to "国内線運用","JA817A" to "国内線運用","JA818A" to "国内線運用","JA819A" to "国内線運用","JA820A" to "国際線運用","JA821A" to "国内線運用","JA822A" to "国際線運用","JA823A" to "国際線運用","JA824A" to "国内線運用","JA825A" to "国内線運用","JA827A" to "国際線運用","JA828A" to "国際線運用","JA829A" to "国際線運用","JA831A" to "国際線運用","JA832A" to "国際線運用","JA834A" to "国際線運用","JA835A" to "国際線運用","JA838A" to "国際線運用","JA839A" to "国際線運用","JA840A" to "国際線運用","JA874A" to "国際線運用","JA878A" to "国際線運用",
        "JA604A" to "国内線運用","JA605A" to "国内線運用","JA606A" to "国内線運用","JA607A" to "国内線運用","JA608A" to "国内線運用","JA609A" to "国内線運用","JA610A" to "国内線運用","JA611A" to "国内線運用","JA614A" to "国内線運用","JA615A" to "国内線運用","JA616A" to "国内線運用","JA617A" to "国際線運用","JA618A" to "国内線運用","JA619A" to "国際線運用","JA620A" to "国際線運用","JA621A" to "国際線運用","JA622A" to "国際線運用","JA623A" to "国際線運用","JA624A" to "国際線運用","JA625A" to "国際線運用","JA626A" to "国際線運用","JA627A" to "国際線運用","JA8791" to "国内線運用",
        "JA8342" to "国内線運用","JA8669" to "国内線運用"
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
        override fun getOperation(aircraft_number: String): String{
            if(operation[aircraft_number] != null) {
                return operation[aircraft_number]!!
            }else {
                return ""
            }
        }

    }

}
