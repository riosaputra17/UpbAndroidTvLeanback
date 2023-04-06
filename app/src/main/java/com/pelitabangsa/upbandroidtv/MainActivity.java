package com.pelitabangsa.upbandroidtv;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    private TextView btnSearch;
    private TextView btnHome;
    private TextView btnMovies;
    private TextView btnTv;
    private TextView btnSports;
    private TextView btnSettings;
    private TextView btnLanguage;
    private TextView btnGenre;

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
    }
}