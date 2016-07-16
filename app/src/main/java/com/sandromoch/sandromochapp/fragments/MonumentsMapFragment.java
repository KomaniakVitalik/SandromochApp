package com.sandromoch.sandromochapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandromoch.sandromochapp.R;

import retrofit2.Response;

/**
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MonumentsMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonumentsMapFragment extends BaseFragment {

    private View mView;

    public MonumentsMapFragment() {
        // Required empty public constructor
    }

    public static MonumentsMapFragment newInstance() {
        MonumentsMapFragment fragment = new MonumentsMapFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_memorials_map, container, false);
        return mView;
    }

    @Override
    public void onResponse(Response<?> response, String pendingRequestTag) {
        super.onResponse(response, pendingRequestTag);
    }

}
