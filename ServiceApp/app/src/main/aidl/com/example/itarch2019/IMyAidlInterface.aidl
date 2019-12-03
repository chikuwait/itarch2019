// IMyAidlInterface.aidl
package com.example.itarch2019;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String getModel(String aircraft_number);
    String getOperation(String aircraft_number);
   // void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
    //        double aDouble, String aString);
}
