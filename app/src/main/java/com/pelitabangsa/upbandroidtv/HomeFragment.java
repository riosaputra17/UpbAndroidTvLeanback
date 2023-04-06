package com.pelitabangsa.upbandroidtv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HomeFragment extends Fragment {
    private TextView title;
    private TextView language;
    private TextView description;
//    private FragmentContainerView listFragment;
    private ImageView imgBanner;

    private ListFragment listFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
    }

    private void init(View view) {
        initView(view);

        listFragment = new ListFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.list_fragment, listFragment);
        transaction.commit();

        Gson gson = new Gson();
        InputStream i = null;
        try {
            i = requireContext().getAssets().open("movies.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(i));
            DataModel dataList = gson.fromJson(br, DataModel.class);

            listFragment.bindData(dataList);

            listFragment.setOnContentSelectedListener(this::updateBanner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBanner(DataModel.Result.Detail dataList) {
        title.setText(dataList.title);
        language.setText(dataList.original_language);
        description.setText(dataList.overview);

        String url = "https://www.themoviedb.org/t/p/w500" + dataList.backdrop_path;
        Glide.with(this).load(url).into(imgBanner);
    }

    private void initView(View view) {
        title = (TextView) view.findViewById(R.id.title);
        language = (TextView) view.findViewById(R.id.language);
        description = (TextView) view.findViewById(R.id.description);
        imgBanner = (ImageView) view.findViewById(R.id.img_Banner);
//        listFragment = (FragmentContainerView) findViewById(R.id.list_fragment);
    }
}