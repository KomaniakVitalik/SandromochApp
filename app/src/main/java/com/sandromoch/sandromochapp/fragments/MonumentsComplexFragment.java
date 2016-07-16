package com.sandromoch.sandromochapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sandromoch.sandromochapp.CoreApp;
import com.sandromoch.sandromochapp.R;
import com.sandromoch.sandromochapp.adapters.MonumentsAutoCompleteAdapter;
import com.sandromoch.sandromochapp.models.monument.Monument;
import com.sandromoch.sandromochapp.models.monument.MonumentResponse;
import com.sandromoch.sandromochapp.util.Const;
import com.sandromoch.sandromochapp.util.Logger;

import java.util.List;

import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonumentsComplexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonumentsComplexFragment extends BaseFragment
        implements
        View.OnClickListener
        , CompoundButton.OnCheckedChangeListener
        , OnMapReadyCallback
        // , GoogleMap.InfoWindowAdapter
        , GoogleMap.OnMapClickListener {

    private View mView;
    private EditText mSearchFiled;
    private int monumentType = 0;
    private MonumentsAutoCompleteAdapter autoCompleteAdapter;
    private MapFragment mapFragment;
    private GoogleMap googleMap;

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

        ListView monumentsVariants = (ListView) mView.findViewById(R.id.lv_variants);
        autoCompleteAdapter = new MonumentsAutoCompleteAdapter(getActivity());
        monumentsVariants.setAdapter(autoCompleteAdapter);

        iniMap();
    }

    private void iniMap() {
        mapFragment = (MapFragment) getActivity().getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void addMarker(GoogleMap map, double lat, double lon, String title) {
        map.addMarker(new MarkerOptions().position(new LatLng(lat, lon))
                .title(title)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.google_marker)));
    }


    private void setupView() {
        initView();
        getMonuments();
    }

    private void getMonuments() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                CoreApp.getInstance().getDataManager().getMonuments();
            }
        }).start();
    }

    private void fillScreen(MonumentResponse monument) {
        fillGoogleMap(monument.getResults());
    }

    private void fillGoogleMap(List<Monument> monuments) {
        if(getGoogleMap() != null){
            getGoogleMap().clear();
            for (Monument monument : monuments) {
                addMarker(getGoogleMap(), monument.getLat(), monument.getLon(), monument.getName());
            }
        }
    }

    private void fillAdapter(List<Monument> monuments) {
        autoCompleteAdapter.setMonuments(monuments);
        autoCompleteAdapter.notifyDataSetChanged();
    }

    private void makeSearch(int type) {
    }

    @Override
    public void onResponse(Response<?> response, String pendingRequestTag) {
        super.onResponse(response, pendingRequestTag);
        if (response.body() instanceof MonumentResponse) {
            fillScreen((MonumentResponse) response.body());
            Logger.e("onResponse():", ((MonumentResponse) response.body()).getCount() + "");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_clear:
                mSearchFiled.setText(Const.EMPTY);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.rd_all:
                if (isChecked) {
                    setMonumentType(0);
                    makeSearch(getMonumentType());
                }
                break;
            case R.id.rd_private:
                if (isChecked) {
                    setMonumentType(1);
                    makeSearch(getMonumentType());
                }
                break;
            case R.id.rd_group:
                if (isChecked) {
                    setMonumentType(2);
                    makeSearch(getMonumentType());
                }
                break;
        }
    }

    public int getMonumentType() {
        return monumentType;
    }

    public void setMonumentType(int monumentType) {
        this.monumentType = monumentType;
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        setGoogleMap(googleMap);
    }

    public GoogleMap getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }
}
