package com.vostro.fragment_example;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

// Notes
/*
  1. Swipe transitions between fragment in a container using swipe gestures

  files:
      FragmentOne.java
      FragmentTwo.java
      FragmentThree.java
      SwipeActivity.java (this file)
      SwipeTabFragment.java

      fragment_one.xml
      fragment_two.xml
      fragment_three.xml
      swipe_activity.xml
      swipe_tab_layout.xml

      styles.xml
      colors.xml
 */

public class SwipeActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_activity);

        // Inflating SwipeTabFragment as the first Fragment
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerFlipView, new SwipeTabFragment());
        mFragmentTransaction.commit();

        /* alternative to using instance variables
           getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerTransformView, new TransformerSwipeTabFragment())
                .commit();
         */
    }
}
