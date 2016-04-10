package com.vostro.fragment_example;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

// Notes
/*
  1. Simple loading of a fragment into a container
  2. Swipe transitions between fragment in a container using swipe gestures
  3. Swipe transitions between fragment in a container using buttons

  files:
      FragmentOne.java
      FragmentTwo.java
      FragmentThree.java
      CombinationActivity.java (this file)
      CombinationTabFragment.java

      fragment_one.xml
      fragment_two.xml
      fragment_three.xml
      combination_activity.xml
      combination_tab_layout.xml

      styles.xml
      colors.xml
 */

public class CombinationActivity extends AppCompatActivity {

    private static final String TAG = "FRAG";
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combination_activity);

        // Inflate top static fragment
        FragmentOne objOne = new FragmentOne();   // instance of FragmentOne.java
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_comnbi_top, objOne, "FragOne");
        fragmentTransaction.commit();

        // Inflating Bottom Swipe Fragment with initial Fragment
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container_combi_bottom, new CombinationTabFragment());
        mFragmentTransaction.commit();

        /* alternative to using instance variables
           getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerTransformView, new TransformerSwipeTabFragment())
                .commit();
         */
    }

    public void swipeBottomFragment(View view) {
        ViewPager vp = (ViewPager) findViewById(R.id.combiviewpager);

        switch (view.getId()) {
            case R.id.btn_combi_right:
                if (vp != null) {
                    vp.setCurrentItem(vp.getCurrentItem() + 1);
                }
                break;

            case R.id.btn_combi_left:
                if (vp != null) {
                    vp.setCurrentItem(vp.getCurrentItem() - 1);
                }
                break;
        }



    }
}
