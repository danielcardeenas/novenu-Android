package io.leind.novenu.Home.activity;

import android.os.Bundle;
import android.view.Menu;

import butterknife.ButterKnife;
import io.leind.novenu.R;

/**
 * Created by leind on 11/20/15.
 */
public class HomeActivity extends BaseActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        startIntroAnimation();
        return true;
    }
}
