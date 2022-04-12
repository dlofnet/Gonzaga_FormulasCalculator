package com.example.gonzaga_formulascalculator.View.ui.main2;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gonzaga_formulascalculator.R;
import com.example.gonzaga_formulascalculator.View.PhysCircular1;
import com.example.gonzaga_formulascalculator.View.PhysCircular2;
import com.example.gonzaga_formulascalculator.View.PhysCircular3;
import com.example.gonzaga_formulascalculator.View.PhysStraight1;
import com.example.gonzaga_formulascalculator.View.PhysStraight2;
import com.example.gonzaga_formulascalculator.View.PhysStraight3;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.centripetal_acceleration,
            R.string.tangential_velocity,
            R.string.tangential_acceleration};
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
                fragment = new PhysCircular1();
                break;
            case 1:
                fragment = new PhysCircular2();
                break;
            case 2:
                fragment = new PhysCircular3();
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