package www.doloop.com.mvp_demo;

import android.app.Application;

import com.itheima.retrofitutils.ItheimaHttp;

/**
 * Created by ZHAO_NAN on 2018/1/14.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ItheimaHttp.init(this, "https://api.douban.com");
    }
}
