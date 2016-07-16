package com.sandromoch.sandromochapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandromoch.sandromochapp.R;

import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MemorialsDaysFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MemorialsDaysFragment extends BaseFragment {

    private View mView;


    public MemorialsDaysFragment() {
        // Required empty public constructor
    }

    public static MemorialsDaysFragment newInstance() {
        MemorialsDaysFragment fragment = new MemorialsDaysFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_memorials_days, container, false);
        return mView;
    }

    @Override
    public void onResponse(Response<?> response, String pendingRequestTag) {
        super.onResponse(response, pendingRequestTag);
    }
}
