package com.pelitabangsa.upbandroidtv;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        Gson gson = new Gson();
        InputStream i = null;
        try {
            i = this.getAssets().open("movies.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(i));
            DataModel dataList = gson.fromJson(br, DataModel.class);

            listFragment.bindData(dataList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        language = (TextView) findViewById(R.id.language);
        description = (TextView) findViewById(R.id.description);
        imgBanner = (ImageView) findViewById(R.id.img_Banner);
//        listFragment = (FragmentContainerView) findViewById(R.id.list_fragment);
    }
}