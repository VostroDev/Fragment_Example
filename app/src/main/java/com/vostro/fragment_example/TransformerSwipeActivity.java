package com.vostro.fragment_example;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Notes
/*
  1. Simple loading of a fragment into a container
  2. Swipe transitions between fragment in a container using swipe gestures
  3. Swipe transitions between fragment in a container using buttons

  files:
      FragmentOne.java
      FragmentTwo.java
      FragmentThree.java
      TransformerSwipeActivity.java (this file)
      TransformerSwipeTabFragment.java

      fragment_one.xml
      fragment_two.xml
      fragment_three.xml
      transformer_swipe_activity.xml
      transformer_swipe_tab_layout.xml

      styles.xml
      colors.xml
 */

public class TransformerSwipeActivity extends AppCompatActivity {

    /*
      FragmentManager mFragmentManager;
      FragmentTransaction mFragmentTransaction;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transformer_swipe_activity);

        // Inflating TransformerSwipeTabFragment as the first Fragment
        /*
          mFragmentManager = getSupportFragmentManager();
          mFragmentTransaction = mFragmentManager.beginTransaction();
          mFragmentTransaction.replace(R.id.containerTransformView, new TransformerSwipeTabFragment());
          mFragmentTransaction.commit();
         */

        // alternative to using instance variables
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerTransformView, new TransformerSwipeTabFragment())
                .commit();
    }
}
