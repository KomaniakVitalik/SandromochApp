package com.sandromoch.sandromochapp;

import android.app.Application;

import com.sandromoch.sandromochapp.api.DataManager;
import com.sandromoch.sandromochapp.api.RetrofitRequest;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by vitaliy.komaniak on 7/14/16.
 */
public class CoreApp extends Application {

    private static CoreApp sInstance;
    private DataManager dataManager;

    private SweetAlertDialog loadDialog;

    public static CoreApp getInstance() {
        return sInstance;
    }

    public static void setInstance(CoreApp sInstance) {
        CoreApp.sInstance = sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        dataManager = new DataManager(new RetrofitRequest());

        loadDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
    }

    public DataManager getDataManager() {
        return this.dataManager;
    }

    public void showLoadingDialog() {
        if (loadDialog != null) {
            loadDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.bg));
            loadDialog.setCancelable(false);
            loadDialog.setTitleText(getResources().getString(R.string.please_wait));
            loadDialog.show();
        }
    }

    public void closeLoadingDialog() {
        if (loadDialog != null) {
            loadDialog.cancel();
        }
    }
}
