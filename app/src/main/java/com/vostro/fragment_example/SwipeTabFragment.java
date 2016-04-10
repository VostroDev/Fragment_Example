package com.vostro.fragment_example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vostro.fragment_example.FragmentOne;
import com.vostro.fragment_example.FragmentThree;
import com.vostro.fragment_example.FragmentTwo;
import com.vostro.fragment_example.R;

public class SwipeTabFragment extends Fragment {

    //// public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate tab_layout and setup Views.
        //View x = inflater.inflate(R.layout.swipe_tab_layout, null);
        View x = inflater.inflate(R.layout.swipe_tab_layout, container, false);
        ////tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        //Set an Adapter for the View Pager
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        return x;
    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        // Return fragment with respect to Position .
        // Use same fragment as in normal fragment activity example
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentOne();
                case 1:
                    return new FragmentTwo();
                case 2:
                    return new FragmentThree();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        // This method returns the title of the tab according to the position.
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "One";
                case 1:
                    return "Two";
                case 2:
                    return "Three";
            }
            return null;
        }
    }

}
