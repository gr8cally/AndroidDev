package com.example.android.ugonabo;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 6/24/2019.
 */

public class UgonaboPagerAdapter extends FragmentPagerAdapter {
    Context context;
    public UgonaboPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getString(R.string.category_numbers);
            case 1:
                return context.getString(R.string.category_family);
            case 2:
                return  context.getString(R.string.category_colors);
            default:
                return context.getString(R.string.category_phrases);
        }
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            default:
                return new PhrasesFragment();
        }


    }
}
