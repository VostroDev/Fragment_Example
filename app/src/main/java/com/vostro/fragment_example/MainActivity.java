package com.vostro.fragment_example;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentOne objOne = new FragmentOne();   // instance of FragmentOne.java
        FragmentTwo objTwo = new FragmentTwo();   // instance of FragmentTwo.java
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_top, objOne, "FragOne");
        fragmentTransaction.add(R.id.container_bottom, objTwo, "FragTwo");
        fragmentTransaction.commit();
    }

    public void btnViewDialog(View view) {
        showDialogX();
    }

    public void swapFragment(View view) {
        FragmentThree objThree = new FragmentThree();   // instance of FragmentThree.java
        FragmentTwo objTwo = new FragmentTwo();         // instance of FragmentTwo.java

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.findFragmentByTag("FragTwo") != null &&
                fragmentManager.findFragmentByTag("FragTwo").isVisible()) {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_bottom, objThree, "FragThree");
            fragmentTransaction.commit();
        } else {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_bottom, objTwo, "FragTwo");
            fragmentTransaction.commit();
        }
    }

    private void showDialogX() {
        DialogX dialogX = new DialogX();
        dialogX.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        dialogX.show(getSupportFragmentManager(), "DialogX");
    }
}
