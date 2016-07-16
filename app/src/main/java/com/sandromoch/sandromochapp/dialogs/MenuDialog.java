package com.sandromoch.sandromochapp.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandromoch.sandromochapp.R;
import com.sandromoch.sandromochapp.listeners.OnChooseMenuItemListener;
import com.sandromoch.sandromochapp.ui.TextViewFont;
import com.sandromoch.sandromochapp.util.Const;

/**
 * Created by vitaliy.komaniak on 7/15/16.
 */
public class MenuDialog extends DialogFragment implements View.OnClickListener {

    private View mView;
    private OnChooseMenuItemListener onChooseMenuItemListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.dialog_menu, null);
        setupView();
        return mView;
    }

    private void initView() {
        TextViewFont memorialComplex = (TextViewFont) mView.findViewById(R.id.tv_memorial_complex);
        memorialComplex.setOnClickListener(this);
        TextViewFont memorialsMap = (TextViewFont) mView.findViewById(R.id.tv_memorials_map);
        memorialsMap.setOnClickListener(this);
        TextViewFont memorialsDays = (TextViewFont) mView.findViewById(R.id.tv_members_days);
        memorialsDays.setOnClickListener(this);
        TextViewFont howToGet = (TextViewFont) mView.findViewById(R.id.tv_how_to_get);
        howToGet.setOnClickListener(this);
    }

    private void setupView() {
        initView();
    }

    public OnChooseMenuItemListener getOnChooseMenuItemListener() {
        return onChooseMenuItemListener;
    }

    public void setOnChooseMenuItemListener(OnChooseMenuItemListener onChooseMenuItemListener) {
        this.onChooseMenuItemListener = onChooseMenuItemListener;
    }

    private void fireListener(String tag) {
        if (getOnChooseMenuItemListener() != null) {
            getOnChooseMenuItemListener().onItemChoose(tag);
            getDialog().dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_memorial_complex:
                fireListener(Const.MEMORIALS_COMPLEX);
                break;
            case R.id.tv_memorials_map:
                fireListener(Const.MEMORIALS_MAP);
                break;
            case R.id.tv_members_days:
                fireListener(Const.MEMORIALS_DAYS);
                break;
            case R.id.tv_how_to_get:
                fireListener(Const.HOW_TO_GET);
                break;
        }
    }
}
