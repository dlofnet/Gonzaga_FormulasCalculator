package com.example.gonzaga_formulascalculator.View.ui.main3;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gonzaga_formulascalculator.R;
import com.example.gonzaga_formulascalculator.View.PhysProjectile1;
import com.example.gonzaga_formulascalculator.View.PhysProjectile2;
import com.example.gonzaga_formulascalculator.View.PhysProjectile3;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.horizontal_change, R.string.vertical_change, R.string.final_vertical};
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
                fragment = new PhysProjectile1();
                break;
            case 1:
                fragment = new PhysProjectile2();
                break;
            case 2:
                fragment = new PhysProjectile3();
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
        return 3;
    }
}