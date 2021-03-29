package com.ads.control;

import android.app.Application;

import java.util.Arrays;

public abstract class AdsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Admod.getInstance().init(this, enableTestAds() ? Arrays.asList(Admod.getInstance().getDeviceId(this)) : null);
        if (enableAdsResume()) {
            AppOpenManager.getInstance().init(this, getOpenAppAdId());
        }
    }

    public abstract boolean enableAdsResume();

    public abstract boolean enableTestAds();

    public abstract String getOpenAppAdId();
}
