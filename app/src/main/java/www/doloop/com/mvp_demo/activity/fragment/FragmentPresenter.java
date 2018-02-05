package www.doloop.com.mvp_demo.activity.fragment;

import www.doloop.com.mvp_demo.adapter.OnDataReadyListener;
import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo_frame.BasePresenter;

/**
 * Created by ZHAO_NAN on 2018/2/4.
 */

public class FragmentPresenter extends BasePresenter<FragmentView, FragmentModel> {
    @Override
    protected FragmentModel getModel() {
        return new FragmentModel();
    }

    public void loadData() {
        getView().showLoading(true);
        getModel().requestData(new OnDataReadyListener<Book>() {
            @Override
            public void onDataReady(Book data) {
                getView().showLoading(false);
                getView().showData(data);
            }
        });
    }
}
