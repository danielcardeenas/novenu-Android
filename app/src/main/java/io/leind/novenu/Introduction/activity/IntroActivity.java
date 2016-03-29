package io.leind.novenu.Introduction.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.leind.novenu.Home.activity.HomeActivity;
import io.leind.novenu.Introduction.fragment.IntroFragment;
import io.leind.novenu.Profile.activity.ProfileActivity;
import io.leind.novenu.R;
import io.leind.novenu.Settings.SettingsActivity;
import io.leind.novenu.Views.Transforms.CircleTransform;
import me.relex.circleindicator.CircleIndicator;

public class IntroActivity extends AppCompatActivity {
    @Bind(R.id.intro_pager) ViewPager viewPager;
    @Bind(R.id.circle_indicator) CircleIndicator circleIndicator;
    @Bind(R.id.intro_button) Button introButton;
    //@Bind(R.id.intro_image) ImageView introImageView

    private static final int LAST_PAGE_INDEX = 2;
    private int pagerPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);

        //setupImage();
        setupViewPager();
        setupIndicator();

        introButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pagerPosition != 2) {
                    viewPager.setCurrentItem(pagerPosition + 1);
                }
                else {
                    // Start activity
                    Intent helpIntent = new Intent(IntroActivity.this, ProfileActivity.class);
                    IntroActivity.this.startActivity(helpIntent);
                    //IntroActivity.this.finish();
                }
            }
        });
    }

    /**
     * Set up view pager fragments
     * */
    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(IntroFragment.newInstance(0));
        adapter.addFrag(IntroFragment.newInstance(1));
        adapter.addFrag(IntroFragment.newInstance(2));

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                pagerPosition = position;
                if (position == LAST_PAGE_INDEX) {
                    introButton.setText("DONE");
                }
                else {
                    introButton.setText("NEXT");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * Set up the CircleIndicator and attach it into the ViewPager [global|viewPager]
     * */
    public void setupIndicator() {
        circleIndicator.setViewPager(viewPager);
        //tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));

    }

    private void setupImage() {
        //GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(introImageView);
        //Glide.with(this).load(R.raw.bear).into(imageViewTarget);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
