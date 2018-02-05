package www.doloop.com.mvp_demo_frame;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by ZHAO_NAN on 2018/2/3.
 */

public abstract class BaseFragment<T extends BasePresenter,V extends BaseViewInter> extends Fragment {

    protected T mPresenter;
    protected abstract T getPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mPresenter == null) {
            mPresenter = getPresenter();
        }
        mPresenter.attach((V)this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null) {
            mPresenter.deAttach();
        }
    }
}
