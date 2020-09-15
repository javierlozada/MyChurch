package com.proyecto.mychurch.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.proyecto.mychurch.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private  final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return mFragmentList.get(position);
    }


    @Override
    public int getCount() {
        // Show n total pages.
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment){
        mFragmentList.add(fragment);
    }





}