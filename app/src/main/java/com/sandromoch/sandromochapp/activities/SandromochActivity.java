package com.sandromoch.sandromochapp.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.sandromoch.sandromochapp.CoreApp;
import com.sandromoch.sandromochapp.R;
import com.sandromoch.sandromochapp.api.DataManager;
import com.sandromoch.sandromochapp.dialogs.MenuDialog;
import com.sandromoch.sandromochapp.fragments.BaseFragment;
import com.sandromoch.sandromochapp.fragments.HowToGetFragment;
import com.sandromoch.sandromochapp.fragments.MemorialsDaysFragment;
import com.sandromoch.sandromochapp.fragments.MonumentsComplexFragment;
import com.sandromoch.sandromochapp.fragments.MonumentsMapFragment;
import com.sandromoch.sandromochapp.listeners.OnChooseMenuItemListener;
import com.sandromoch.sandromochapp.util.Const;

import retrofit2.Response;

public class SandromochActivity extends BaseActivity
        implements
        View.OnClickListener
        , OnChooseMenuItemListener
        , DataManager.OnResponseListener {

    private MenuDialog menuDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandromoch);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.bg));
        }
        setupView();

        openMenu();
    }

    @Override
    protected void onResume() {
        super.onResume();
        CoreApp.getInstance().getDataManager().registerResponseListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CoreApp.getInstance().getDataManager().registerResponseListener(null);
    }

    private void initView() {
        menuDialog = new MenuDialog();
        menuDialog.setOnChooseMenuItemListener(this);

        ImageView menu = (ImageView) findViewById(R.id.img_menu);
        menu.setOnClickListener(this);
    }

    private void setupView() {
        initView();
    }

    private void openMenu() {
        if (menuDialog != null) {
            menuDialog.show(getFragmentManager(), null);
        }
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (!menuDialog.isVisible()
                && (fragment instanceof MonumentsComplexFragment
                || fragment instanceof MonumentsMapFragment
                || fragment instanceof HowToGetFragment)) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_menu:
                openMenu();
                break;
        }
    }

    @Override
    public void onItemChoose(String itemTag) {
        switch (itemTag) {
            case Const.MEMORIALS_COMPLEX:
                loadFragment(new MonumentsComplexFragment(), R.id.container, true);
                break;
            case Const.MEMORIALS_MAP:
                loadFragment(new MonumentsMapFragment(), R.id.container, true);
                break;
            case Const.MEMORIALS_DAYS:
                loadFragment(new MemorialsDaysFragment(), R.id.container, true);
                break;
            case Const.HOW_TO_GET:
                loadFragment(new HowToGetFragment(), R.id.container, true);
                break;
        }
    }

    private void notifyFragments(Response<?> response, String pendingRequestTag) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        ((BaseFragment) fragment).onResponse(response, pendingRequestTag);
    }

    @Override
    public void onResponseSuccess(Response<?> response, String pendingRequestTag) {
        notifyFragments(response, pendingRequestTag);
    }

    @Override
    public void onResponseFail(int statusMessage, String serverMessage) {
        Toast.makeText(getApplicationContext(), serverMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoNetwork() {

    }
}
