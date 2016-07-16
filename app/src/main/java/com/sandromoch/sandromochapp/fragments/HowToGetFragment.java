package com.sandromoch.sandromochapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandromoch.sandromochapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HowToGetFragment extends BaseFragment {

    private View mView;


    public HowToGetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_how_to_get, container, false);

        return mView;
    }

}
