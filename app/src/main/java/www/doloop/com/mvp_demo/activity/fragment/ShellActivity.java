package www.doloop.com.mvp_demo.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import www.doloop.com.mvp_demo.R;

/**
 * Created by ZHAO_NAN on 2018/2/4.
 */

public class ShellActivity extends AppCompatActivity {
    public static final String FRAGMENT_TAG = "fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);
        init();
    }

    private void init() {
        //初始化view
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FrameFragment fragment = (FrameFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
//        if (fragment == null) {
//            fragment = FrameFragment.newInstance();
//            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment, FRAGMENT_TAG).commit();
//        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FrameFragment3 fragment3 = (FrameFragment3) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (fragment3 == null) {
            fragment3 = FrameFragment3.newInstance();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment3, FRAGMENT_TAG).commit();
        }

    }
}
