package com.sandromoch.sandromochapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.sandromoch.sandromochapp.CoreApp;
import com.sandromoch.sandromochapp.R;
import com.sandromoch.sandromochapp.models.monument.MonumentResponse;

import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonumentsComplexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonumentsComplexFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private View mView;
    private EditText mSearchFiled;
    private int monumentType;

    public MonumentsComplexFragment() {
        // Required empty public constructor
    }

    public static MonumentsComplexFragment newInstance() {
        MonumentsComplexFragment fragment = new MonumentsComplexFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_monuments_complex, null);
        setupView();
        return mView;
    }

    private void initView() {
        RadioButton allRadio = (RadioButton) mView.findViewById(R.id.rd_all);
        allRadio.setOnCheckedChangeListener(this);
        RadioButton privateRadio = (RadioButton) mView.findViewById(R.id.rd_private);
        privateRadio.setOnCheckedChangeListener(this);
        RadioButton groupRadio = (RadioButton) mView.findViewById(R.id.rd_group);
        groupRadio.setOnCheckedChangeListener(this);

        ImageView clear = (ImageView) mView.findViewById(R.id.img_clear);
        clear.setOnClickListener(this);

        mSearchFiled = (EditText) mView.findViewById(R.id.edt_search);
    }

    private void setupView() {
        initView();

        CoreApp.getInstance().getDataManager().getMonuments();
    }

    private void fillScreen(MonumentResponse monument) {
    }

    @Override
    public void onResponse(Response<?> response, String pendingRequestTag) {
        super.onResponse(response, pendingRequestTag);
        if (response.body() instanceof MonumentResponse) {
            fillScreen((MonumentResponse) response.body());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_clear:
                mSearchFiled.setText("");
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    public int getMonumentType() {
        return monumentType;
    }

    public void setMonumentType(int monumentType) {
        this.monumentType = monumentType;
    }
}
