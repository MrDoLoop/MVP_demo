package www.doloop.com.mvp_demo.activity;

import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo_frame.BaseViewInter;

/**
 * Created by ZHAO_NAN on 2018/1/14.
 */

public interface FrameActivityView extends BaseViewInter {
    void showLoading(boolean show);

    void showData(Book data);
}
