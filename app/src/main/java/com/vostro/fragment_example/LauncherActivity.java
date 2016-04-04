package com.vostro.fragment_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LauncherActivity extends AppCompatActivity {

    // Used to Launch examples, this is not necessary class for fragment examples
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_activity);
    }

    public void btnOpen(View view) {

        switch (view.getId()) {
            case R.id.btnSimple:
                Intent simpleIntent = new Intent(this, MainActivity.class);
                startActivity(simpleIntent);
                break;

            case R.id.btnSwipe:
                Intent swipeIntent = new Intent(this, SwipeActivity.class);
                startActivity(swipeIntent);
                break;
        }

    }
}
