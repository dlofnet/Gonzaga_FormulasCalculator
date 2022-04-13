package com.example.gonzaga_formulascalculator.View.ui.main5;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gonzaga_formulascalculator.R;
import com.example.gonzaga_formulascalculator.View.GeoTorus1;
import com.example.gonzaga_formulascalculator.View.GeoTorus2;
import com.example.gonzaga_formulascalculator.View.GeoTorus3;
import com.example.gonzaga_formulascalculator.View.GeoTorus4;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.torus_v, R.string.torus_maj, R.string.torus_a, R.string.torus_min};
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
                fragment = new GeoTorus1();
                break;
            case 1:
                fragment = new GeoTorus2();
                break;
            case 2:
                fragment = new GeoTorus3();
                break;
            case 3:
                fragment = new GeoTorus4();
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
        // Show 4 total pages.
        return 4;
    }
}