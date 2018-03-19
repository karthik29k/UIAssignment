package com.example.karthikreddy.inteliment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;
import icepick.Icicle;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.actionText) TextView textView;
    @BindView(R.id.mainRelativeLayout) RelativeLayout relativeLayout;
    @Icicle int colourId;
    @Icicle String actionText;
    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<Fragment> fragments = getFragments();

        pageAdapter = new PageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        actionText = textView.getText().toString();
        Drawable background = relativeLayout.getBackground();
        colourId = ((ColorDrawable) background).getColor();
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        refreshScreen();
    }

    private void refreshScreen() {
        textView.setText(actionText);
        relativeLayout.setBackgroundColor(colourId);
    }

    @NonNull private List<Fragment> getFragments() {
        List<Fragment> fragmentList = new ArrayList<Fragment>();

        fragmentList.add(MyFragment.newInstance("Fragment 1"));
        fragmentList.add(MyFragment.newInstance("Fragment 2"));
        fragmentList.add(MyFragment.newInstance("Fragment 3"));
        return fragmentList;
    }

    @OnClick(R.id.greenButton)
    public void onGreenButtonClicked() {
        relativeLayout.setBackgroundColor(Color.GREEN);
    }

    @OnClick(R.id.redButton)
    public void onRedButtonClicked() {
        relativeLayout.setBackgroundColor(Color.RED);
    }

    @OnClick(R.id.blueButton)
    public void onBlueButtonClicked() {
        relativeLayout.setBackgroundColor(Color.BLUE);
    }

    @OnClick(R.id.camera)
    public void onCameraClicked() {
        textView.setText(R.string.take_a_photo);
    }

    @OnClick(R.id.alarm)
    public void onAlarmClicked() {
        textView.setText(R.string.set_alarm);
    }

    @OnClick(R.id.location)
    public void onLocationClicked() {
        textView.setText(R.string.location_on);
    }

    @OnClick(R.id.music)
    public void onMusicClicked() {
        textView.setText(R.string.listen_music);
    }

    @OnClick(R.id.settings)
    public void onSettingsClicked() {
        textView.setText(R.string.go_to_settings);
    }

    private class PageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        PageAdapter(@NonNull FragmentManager fm, @NonNull List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override @NonNull
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

}

