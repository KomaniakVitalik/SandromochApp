package com.sandromoch.sandromochapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sandromoch.sandromochapp.R;
import com.sandromoch.sandromochapp.models.monument.Monument;
import com.sandromoch.sandromochapp.ui.TextViewFont;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaliy.komaniak on 7/16/16.
 */
public class MonumentsAutoCompleteAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<Monument> monuments;

    public MonumentsAutoCompleteAdapter(Context context) {
        this.monuments = new ArrayList<>();
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return monuments != null ? monuments.size() : 0;
    }

    @Override
    public Monument getItem(int position) {
        return monuments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Monument monument = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_auto_complite, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mTitle.setText(monument.getName());

        return convertView;
    }

    public void setMonuments(List<Monument> monuments) {
        if (monuments.size() > 0) {
            this.monuments.clear();
        }
        this.monuments = monuments;
    }

    public static class ViewHolder {
        private TextViewFont mTitle;

        public ViewHolder(View view) {
            mTitle = (TextViewFont) view.findViewById(R.id.tv_auto_complite);
        }
    }
}
