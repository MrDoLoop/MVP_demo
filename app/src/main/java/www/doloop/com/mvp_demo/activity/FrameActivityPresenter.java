package www.doloop.com.mvp_demo.activity;

import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo.adapter.OnDataReadyListener;
import www.doloop.com.mvp_demo_frame.BasePresenter;

/**
 * Created by ZHAO_NAN on 2018/1/14.
 */

public class FrameActivityPresenter extends BasePresenter<FrameActivity, FrameActivityModel> {
    @Override
    protected FrameActivityModel getModel() {
        return new FrameActivityModel();
    }

    public void loadData(){
        getView().showLoading(true);
        getModel().requestData(new OnDataReadyListener<Book>(){
            @Override
            public void onDataReady(Book data) {
                getView().showLoading(false);
                if(isViewAttached()) {
                    getView().showData(data);
                }
            }

            @Override
            public void onError() {

            }
        });
    }
}
