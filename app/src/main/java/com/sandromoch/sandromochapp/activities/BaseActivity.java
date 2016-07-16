package com.sandromoch.sandromochapp.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vitaliy.komaniak on 7/14/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void loadFragment(Fragment fragment, int id, boolean addToBackStack) {
        try {
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            boolean fragmentPopped = manager.popBackStackImmediate(fragment.getClass().getSimpleName(), 0);

            if (!fragmentPopped && addToBackStack) {
                android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(id, fragment, fragment.getClass().getSimpleName());
                transaction.addToBackStack(fragment.getClass().getSimpleName());
                transaction.commit();
                manager.executePendingTransactions();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
