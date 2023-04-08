package com.pelitabangsa.upbandroidtv;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;

import com.bumptech.glide.Glide;
import com.pelitabangsa.upbandroidtv.utils.Constants;

public class DetailActivity extends FragmentActivity {

    private ImageView imgBanner;
    private TextView title;
    private TextView language;
    private TextView description;
    private TextView play;
    private TextView moreLikeThis;
    private TextView addToMylist;
    private FragmentContainerView castFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    private void initView() {
        imgBanner = (ImageView) findViewById(R.id.img_banner);
        title = (TextView) findViewById(R.id.title);
        language = (TextView) findViewById(R.id.language);
        description = (TextView) findViewById(R.id.description);
        play = (TextView) findViewById(R.id.play);
        moreLikeThis = (TextView) findViewById(R.id.more_like_this);
        addToMylist = (TextView) findViewById(R.id.add_to_mylist);
        castFragment = (FragmentContainerView) findViewById(R.id.cast_fragment);

        Bundle bundle = getIntent().getExtras();

        getDetails(bundle);
    }

    private void getDetails(Bundle bundle) {
        Constants constant = new Constants();

        getImgBanner(bundle, constant);
        title.setText(bundle.getString(constant.TITLE));
        language.setText(bundle.getString(constant.LANGUAGE));
        description.setText(bundle.getString(constant.DESCRIPTION));
    }

    private void getImgBanner(Bundle bundle, Constants constant) {
        String url = "https://www.themoviedb.org/t/p/w500" + bundle.getString(constant.BACKDROP);
        Glide.with(this)
                .load(url)
                .into(imgBanner);
    }
}