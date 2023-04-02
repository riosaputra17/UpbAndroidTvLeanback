package com.pelitabangsa.upbandroidtv;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
    private TextView title;
    private TextView language;
    private TextView description;
//    private FragmentContainerView listFragment;
    private ImageView imgBanner;

    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        listFragment = new ListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.list_fragment, listFragment);
        transaction.commit();
    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        language = (TextView) findViewById(R.id.language);
        description = (TextView) findViewById(R.id.description);
        imgBanner = (ImageView) findViewById(R.id.img_Banner);
//        listFragment = (FragmentContainerView) findViewById(R.id.list_fragment);
    }
}