package com.example.gonzaga_formulascalculator.View.ui.main6;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gonzaga_formulascalculator.R;
import com.example.gonzaga_formulascalculator.View.GeoPyramid1;
import com.example.gonzaga_formulascalculator.View.GeoPyramid2;
import com.example.gonzaga_formulascalculator.View.GeoPyramid3;
import com.example.gonzaga_formulascalculator.View.GeoPyramid4;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.pyra_v, R.string.pyra_bl, R.string.pyra_bw, R.string.pyra_h};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new GeoPyramid1();
                break;
            case 1:
                fragment = new GeoPyramid2();
                break;
            case 2:
                fragment = new GeoPyramid3();
                break;
            case 3:
                fragment = new GeoPyramid4();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}