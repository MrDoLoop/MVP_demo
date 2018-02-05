package www.doloop.com.mvp_demo.activity.fragment;

import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo_frame.BaseViewInter;

/**
 * Created by ZHAO_NAN on 2018/2/4.
 */

public interface FragmentView extends BaseViewInter {

    void showLoading(boolean show);

    void showError();

    void showData(Book data);
}
