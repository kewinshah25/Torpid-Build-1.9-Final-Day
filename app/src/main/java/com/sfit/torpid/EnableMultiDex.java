package com.sfit.torpid;

/**
 * Created by kewin on 3/13/2017.
 */

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class EnableMultiDex extends MultiDexApplication {
    private static EnableMultiDex enableMultiDex;
    public static Context context;

    public EnableMultiDex(){
        enableMultiDex=this;
    }

    public static EnableMultiDex getEnableMultiDexApp() {
        return enableMultiDex;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }
}