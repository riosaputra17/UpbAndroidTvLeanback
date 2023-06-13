package com.pelitabangsa.upbandroidtv;

import android.content.Intent;
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
import com.pelitabangsa.upbandroidtv.models.motor.DetailsItem;
import com.pelitabangsa.upbandroidtv.models.motor.MotorModel;
import com.pelitabangsa.upbandroidtv.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MotorFragment extends Fragment {
    private TextView title;
    private TextView language;
    private TextView description;
    //    private FragmentContainerView listFragment;
    private ImageView imgBanner;

    private ListFragment listFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_motor, container, false);
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
            i = requireContext().getAssets().open("motor.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(i));
            MotorModel dataList = gson.fromJson(br, MotorModel.class);

            listFragment.bindData(dataList);

            listFragment.setOnContentSelectedListener(this::updateBanner);
            listFragment.setOnContentClickedListener(new ListFragment.OnItemClickListener() {
                @Override
                public void onItemClick(DetailsItem item) {
                    Constants constant = new Constants();

                    Intent intent = new Intent(requireContext(), DetailActivity.class);
                    intent.putExtra(constant.ID, item.getId());
                    intent.putExtra(constant.BACKDROP, item.getMotorBg());
                    intent.putExtra(constant.TITLE, item.getMotorModel());
                    intent.putExtra(constant.DESCRIPTION, item.getDeskripsi());
                    startActivity(intent);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBanner(DetailsItem dataList) {
        title.setText(dataList.getMotorModel());
        description.setText(dataList.getDeskripsi());

        String url = dataList.getMotorBg();
        Glide.with(this)
                .load(url)
                .into(imgBanner);
    }

    private void initView(View view) {
        title = (TextView) view.findViewById(R.id.title);
        language = (TextView) view.findViewById(R.id.language);
        description = (TextView) view.findViewById(R.id.description);
        imgBanner = (ImageView) view.findViewById(R.id.img_Banner);
//        listFragment = (FragmentContainerView) findViewById(R.id.list_fragment);
    }
}