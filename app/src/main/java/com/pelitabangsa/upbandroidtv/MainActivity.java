package com.pelitabangsa.upbandroidtv;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.widget.BrowseFrameLayout;

import com.pelitabangsa.upbandroidtv.utils.Common;

public class MainActivity extends FragmentActivity implements View.OnKeyListener {

    private TextView btnSearch;
    private TextView btnHome;
    private TextView btnMovies;
    private TextView btnTv;
    private TextView btnSports;
    private TextView btnSettings;
    private TextView btnLanguage;
    private TextView btnGenre;
    private boolean SIDE_MENU = false;
    private BrowseFrameLayout navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        changeFragment(new HomeFragment());
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void initView() {
        btnSearch = (TextView) findViewById(R.id.btn_search);
        btnHome = (TextView) findViewById(R.id.btn_home);
        btnMovies = (TextView) findViewById(R.id.btn_movies);
        btnTv = (TextView) findViewById(R.id.btn_tv);
        btnSports = (TextView) findViewById(R.id.btn_sports);
        btnSettings = (TextView) findViewById(R.id.btn_settings);
        btnLanguage = (TextView) findViewById(R.id.btn_language);
        btnGenre = (TextView) findViewById(R.id.btn_genre);
        navBar = (BrowseFrameLayout) findViewById(R.id.bflNavBar);

        initSetOnKeyListener();
    }

    private void initSetOnKeyListener() {
        btnSearch.setOnKeyListener(this);
        btnHome.setOnKeyListener(this);
        btnMovies.setOnKeyListener(this);
        btnTv.setOnKeyListener(this);
        btnSports.setOnKeyListener(this);
        btnSettings.setOnKeyListener(this);
        btnLanguage.setOnKeyListener(this);
        btnGenre.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (i) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (!SIDE_MENU) {
                    openMenu();
                    SIDE_MENU = true;
                }
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT && SIDE_MENU) {
            SIDE_MENU = false;
            closeMenu();
        }

        return super.onKeyDown(keyCode, event);
    }

    private void openMenu() {
        navBar.requestLayout();
        navBar.getLayoutParams().width = Common.getWidthInPercent(this, 16);
    }

    private void closeMenu() {
        navBar.requestLayout();
        navBar.getLayoutParams().width = Common.getWidthInPercent(this, 5);
    }
}