package com.pelitabangsa.upbandroidtv.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.pelitabangsa.upbandroidtv.MotorFragment;
import com.pelitabangsa.upbandroidtv.R;

public class HomeFragment extends Fragment implements View.OnClickListener, View.OnKeyListener {

    private VideoView bgVideo;
    private TextView btnStart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initView(view);
    }

    private void initView(View view) {
        bgVideo = (VideoView) view.findViewById(R.id.bg_video);

        setVideo();
        btnStart = (TextView) view.findViewById(R.id.btn_start);
        btnStart.requestFocus();

        btnStart.setOnClickListener(this);
        btnStart.setOnKeyListener(this);
    }

    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void setVideo() {
        String path = "android.resource://com.pelitabangsa.upbandroidtv/" + R.raw.bg_home;
        Uri u = Uri.parse(path);
        bgVideo.setVideoURI(u);
        bgVideo.start();

        bgVideo.setOnPreparedListener(mediaPlayer -> mediaPlayer.setLooping(true));
    }

    @Override
    public void onClick(View view) {
        changeFragment(new MotorFragment());
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == KeyEvent.KEYCODE_DPAD_CENTER && view.getId() == R.id.btn_start) {
            changeFragment(new MotorFragment());
        }
        return false;
    }
}
