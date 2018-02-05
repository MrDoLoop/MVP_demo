package www.doloop.com.mvp_demo.activity;

import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import okhttp3.ResponseBody;
import retrofit2.Call;
import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo.adapter.OnDataReadyListener;
import www.doloop.com.mvp_demo_frame.BaseModelInter;

/**
 * Created by ZHAO_NAN on 2018/1/14.
 */

public class FrameActivityModel implements BaseModelInter {

    void requestData(final OnDataReadyListener l) {
        Request request = ItheimaHttp.newGetRequest("/v2/book/search");
        request.putParams("q", "哈利波特");
        request.putParams("tag", "");
        request.putParams("start", 0);
        request.putParams("count", 20);
        ItheimaHttp.send(request, new HttpResponseListener<Book>() {
            @Override
            public void onResponse(Book data) {
                if(l != null) {

                    l.onDataReady(data);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                super.onFailure(call, e);
            }
        });
    }

}
