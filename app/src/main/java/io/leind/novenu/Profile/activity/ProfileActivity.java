package io.leind.novenu.Profile.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.leind.novenu.Home.activity.BaseActivity;
import io.leind.novenu.R;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;


public class ProfileActivity extends BaseActivity {
    @Bind(R.id.profile_image) ImageView profileImage;
    @Bind(R.id.appbar) AppBarLayout appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setTitle("");

        float heightDp = getResources().getDisplayMetrics().heightPixels / 3;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams)appBar.getLayoutParams();
        lp.height = (int)heightDp * 2;

        setUpProfileItems();
    }

    private void setUpProfileItems() {
        Glide.with(this)
                .load("https://scontent-mia1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/1546343_10202027354337682_1784165829_n.jpg?_nc_eui=ARhd6UmVXfcZFVIO7CjU7UzWay2m1vH7HDPhzl3e_i42Cix2oU14_woeGOMO&oh=cf1160bb99b1be9a96863c4cd1b0f2fb&oe=57859003")
                .centerCrop()
                .bitmapTransform(new ColorFilterTransformation(this, Color.argb(100, 0, 0, 0)))
                .into(profileImage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
    }
}
