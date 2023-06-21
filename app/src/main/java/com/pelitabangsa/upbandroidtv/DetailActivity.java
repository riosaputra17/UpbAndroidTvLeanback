package com.pelitabangsa.upbandroidtv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.pelitabangsa.upbandroidtv.adapter.SpecificationAdapter;
import com.pelitabangsa.upbandroidtv.models.motor.DetailsItem;
import com.pelitabangsa.upbandroidtv.models.motor2.MotorModel;
import com.pelitabangsa.upbandroidtv.models.motor2.SpesifikasiItem;
import com.pelitabangsa.upbandroidtv.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DetailActivity extends FragmentActivity {

    private ImageView imgBanner;
    private TextView tvModel;
    private TextView tvDescriptionContent;
    private TextView viewMore;
    private Boolean isViewMore = true;

    private ListFragment listFragment;

    ArrayList<SpesifikasiItem> spesifikasiItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        initView();
    }

    private void initView() {
        imgBanner = (ImageView) findViewById(R.id.img_banner);
        tvModel = (TextView) findViewById(R.id.tv_model);
        tvDescriptionContent = (TextView) findViewById(R.id.tv_deskripsi_content);
        viewMore = (TextView) findViewById(R.id.view_more);

        Bundle bundle = getIntent().getExtras();

        viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isViewMore = !isViewMore;
                if (isViewMore) {
                    tvDescriptionContent.setMaxLines(3);
                    viewMore.setText("View More Information");
                    viewMore.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_more, 0, 0, 0);
                } else {
                    tvDescriptionContent.setMaxLines(100);
                    viewMore.setText("View Less Information");
                    viewMore.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_less, 0, 0, 0);
                }

            }
        });

        getDetails(bundle);

        Gson gson = new Gson();
        InputStream i = null;
        try {
            i = getAssets().open("motor.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(i));
            MotorModel dataList = gson.fromJson(br, MotorModel.class);

            Constants constant = new Constants();
            int id = getIntent().getIntExtra(constant.ID, 0);

            RecyclerView rvSpesifikasi = (RecyclerView) findViewById(R.id.rv_spesifikasi);

            bindDataDetailSpecification(dataList, id, rvSpesifikasi);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void bindDataDetailSpecification(com.pelitabangsa.upbandroidtv.models.motor2.MotorModel motorList, int id, RecyclerView rvSpesifikasi) {

        for (com.pelitabangsa.upbandroidtv.models.motor2.ResultsItem motorModel : motorList.getResults()) {

            for (com.pelitabangsa.upbandroidtv.models.motor2.DetailsItem detail : motorModel.getDetails()) {
                for (SpesifikasiItem spesifikasiItem : detail.getSpesifikasi()) {
                    if (detail.getId() == id) {
                        spesifikasiItems.add(spesifikasiItem);
                    }
                }
            }

            SpecificationAdapter adapter = new SpecificationAdapter(spesifikasiItems);
            rvSpesifikasi.setAdapter(adapter);
            rvSpesifikasi.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    private void getDetails(Bundle bundle) {
        Constants constant = new Constants();

        getImgBanner(bundle, constant);
        tvModel.setText(bundle.getString(constant.TITLE));
        tvDescriptionContent.setText(bundle.getString(constant.DESCRIPTION));
    }

    private void getImgBanner(Bundle bundle, Constants constant) {
        String url = bundle.getString(constant.BACKDROP);
        Glide.with(this)
                .load(url)
                .into(imgBanner);
    }
}