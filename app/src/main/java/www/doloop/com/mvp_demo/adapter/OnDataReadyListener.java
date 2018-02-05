package www.doloop.com.mvp_demo.adapter;

/**
 * Created by ZHAO_NAN on 2017/12/31.
 */

public interface OnDataReadyListener<T> {
    void onDataReady(T data);

    void onError();
}
