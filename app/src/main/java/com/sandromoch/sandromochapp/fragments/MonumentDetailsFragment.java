package com.sandromoch.sandromochapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandromoch.sandromochapp.R;

import retrofit2.Response;

/**
 * Created by vitaliy.komaniak on 7/14/16.
 */
public class MonumentDetailsFragment  extends BaseFragment{

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_monuments_details, null);

        return mView;
    }

    @Override
    public void onResponse(Response<?> response, String pendingRequestTag) {
        super.onResponse(response, pendingRequestTag);
    }
}
