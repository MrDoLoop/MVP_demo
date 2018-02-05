package www.doloop.com.mvp_demo_frame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ZHAO_NAN on 2018/1/11.
 */
//http://blog.csdn.net/qq_27630169/article/details/52335483
public abstract class BaseActivity<T extends BasePresenter,V extends BaseViewInter> extends AppCompatActivity {
    protected T presenter;
    protected abstract T getPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(presenter == null) {
            presenter = getPresenter();
        }
        presenter.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null) {
            presenter.deAttach();
        }
    }
}
