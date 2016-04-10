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
import android.widget.RadioGroup;

// Modified Example from http://developer.android.com/training/animation/screen-slide.html

public class TransformerSwipeTabFragment extends Fragment {

    //// public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate tab_layout and setup Views.
        View x = inflater.inflate(R.layout.transformer_swipe_tab_layout, container, false);
        ////tabLayout = (TabLayout) x.findViewById(R.id.tabs);

        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        //Set an Adapter for the View Pager
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        viewPager.setPageTransformer(true, new ZoomOutPagerTransformer());

        return x;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RadioGroup radioGroup = (RadioGroup) getActivity().findViewById(R.id.rdoGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButton = group.getCheckedRadioButtonId();

                switch (checkedRadioButton) {
                    case R.id.rdoZoom:
                        viewPager.setPageTransformer(true, new ZoomOutPagerTransformer());

                        break;
                    case R.id.rdoDepth:
                        viewPager.setPageTransformer(true, new DepthPageTransformer());

                        break;
                }
            }
        });
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

    public class ZoomOutPagerTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.95f;     // 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(View page, float position) {
            int pageWidth = page.getWidth();
            int pageHeight = page.getHeight();

            if (position < -1) {
                page.setAlpha(0);      // [- infinity, -1] Page way off screen to the left
            } else if (position <= 1) {  // [-1, 1]
                // modify the default slide transformation to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    page.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    page.setTranslationX(-horzMargin + vertMargin / 2);
                }

                //Scale the page down (between MIN_SCALE and 1)
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);

                //Fade the page relative to its size
                page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else {
                // This page is way off screen to the right [1, +Infinity]
                page.setAlpha(0);
            }
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}








