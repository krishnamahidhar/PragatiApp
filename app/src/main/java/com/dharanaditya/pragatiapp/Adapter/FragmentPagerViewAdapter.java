package com.dharanaditya.pragatiapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dharanaditya.pragatiapp.ui.ExamsFragment;
import com.dharanaditya.pragatiapp.ui.FeedFragment;

/**
 * Created by dharan1011 on 29/11/16.
 */

public class FragmentPagerViewAdapter extends FragmentPagerAdapter {
    public FragmentPagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FeedFragment();
            case 1:
                return new ExamsFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Feeds";
            case 1:
//                Log.d(MainActivity.TAG,context.getResources().getString(R.string.strip_palace_holder_1));
                return "Exams";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
