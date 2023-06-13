package com.pelitabangsa.upbandroidtv;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.widget.BrowseFrameLayout;

import com.pelitabangsa.upbandroidtv.fragment.AboutFragment;
import com.pelitabangsa.upbandroidtv.fragment.HomeFragment;
import com.pelitabangsa.upbandroidtv.utils.Common;
import com.pelitabangsa.upbandroidtv.utils.Constants;

public class MainActivity extends FragmentActivity implements View.OnKeyListener {


    private TextView btnHome;
    private TextView btnMotor;
    private TextView btnAbout;

    private BrowseFrameLayout navBar;
    private boolean SIDE_MENU = false;

    Constants constants = new Constants();
    private String selectedMenu = constants.MENU_HOME;

    private View lastSelectedMenu = null;
    private FrameLayout fragmentContainer;

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

        closeMenu();
    }

    private void initView() {
        btnHome = (TextView) findViewById(R.id.btn_home);
        btnMotor = (TextView) findViewById(R.id.btn_motor);
        btnAbout = (TextView) findViewById(R.id.btn_about);
        navBar = (BrowseFrameLayout) findViewById(R.id.bflNavBar);
        fragmentContainer = (FrameLayout) findViewById(R.id.container);

        initSetOnKeyListener();

        lastSelectedMenu = btnHome;
        lastSelectedMenu.setActivated(true);
        changeFragment(new HomeFragment());
    }

    private void initSetOnKeyListener() {
        btnHome.setOnKeyListener(this);
        btnMotor.setOnKeyListener(this);
        btnAbout.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (i) {
            case KeyEvent.KEYCODE_DPAD_CENTER:

                lastSelectedMenu.setActivated(false);
                view.setActivated(true);
                lastSelectedMenu = view;

                switch (view.getId()) {
                    case R.id.btn_home:
                        if (view.getId() != R.id.btn_start) {
                            selectedMenu = constants.MENU_HOME;
                            changeFragment(new HomeFragment());
                            break;
                        }
                    case R.id.btn_motor:
                        selectedMenu = constants.MENU_MOTOR;
                        changeFragment(new MotorFragment());
                        break;
                    case R.id.btn_about:
                        selectedMenu = constants.MENU_ABOUT;
                        changeFragment(new AboutFragment());
                        break;

                }
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (!SIDE_MENU) {
                    switchToLastSelectedMenu();

                    openMenu();
                    SIDE_MENU = true;
                }
                break;
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

    @Override
    public void onBackPressed() {
        if (SIDE_MENU) {
            SIDE_MENU = false;
            closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    private void switchToLastSelectedMenu() {
        switch (selectedMenu) {

            case "home":
                btnHome.requestFocus();
                break;
            case "motor":
                btnMotor.requestFocus();
                break;
            case "about":
                btnAbout.requestFocus();
                break;

        }
    }

    private void openMenu() {
        Animation animSlide = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        navBar.startAnimation(animSlide);

        navBar.requestLayout();
        navBar.getLayoutParams().width = Common.getWidthInPercent(this, 16);
    }

    private void closeMenu() {
        navBar.requestLayout();
        navBar.getLayoutParams().width = Common.getWidthInPercent(this, 6);

        fragmentContainer.requestFocus();
        SIDE_MENU = false;
    }
}