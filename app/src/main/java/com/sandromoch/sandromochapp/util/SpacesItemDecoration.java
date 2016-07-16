package com.sandromoch.sandromochapp.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by vitaliy.komaniak on 6/26/16.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        // Add top margin only for the first item to avoid double space between items
//        switch (parent.getChildLayoutPosition(view)) {
//            case 0:
//                outRect.top = space;
//                outRect.left = 0;
//                outRect.right = space;
//                break;
//            case 1:
//                outRect.top = space;
//                outRect.left = 0;
//                outRect.right = space;
//                break;
//            case 2:
//                outRect.top = space;
//                outRect.left = 0;
//                outRect.right = 0;
//                break;
//        }

        outRect.top = space;
        outRect.left = space;
        outRect.right = 0;
    }
}