package com.example.luisito.notasapp.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.luisito.notasapp.views.fragments.MyNotesFragment;
import com.example.luisito.notasapp.views.fragments.MyNotesSharedFragment;

/**
 * Created by luisito on 10/12/17.
 */

public class MainNotasPagerAdapter extends FragmentPagerAdapter {
    public  MyNotesFragment mnf;
    public MyNotesSharedFragment msf;

    public MainNotasPagerAdapter(FragmentManager fm) {
        super(fm);
        mnf = new MyNotesFragment();
        msf = new MyNotesSharedFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return mnf;
            case 1:
                return msf;
        }
        return null;
    }
    @Override
    public int getCount() {
        return 2;
    }
}
