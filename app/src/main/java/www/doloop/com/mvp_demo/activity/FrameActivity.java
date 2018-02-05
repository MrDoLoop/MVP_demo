package www.doloop.com.mvp_demo.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import www.doloop.com.mvp_demo.R;
import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo.adapter.SingleItemAdapter;
import www.doloop.com.mvp_demo_frame.BaseActivity;
import zlc.season.practicalrecyclerview.PracticalRecyclerView;

/**
 * Created by ZHAO_NAN on 2018/1/14.
 */

public class FrameActivity extends BaseActivity<FrameActivityPresenter, FrameActivityView>
        implements FrameActivityView, EasyPermissions.PermissionCallbacks {

    //在线生成pojo http://www.sojson.com/json2entity.html
    // http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2016/1104/6746.html
    ProgressDialog mProgressDialog;
    PracticalRecyclerView mPracticalRecyclerView;
    SingleItemAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPerm();

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("正在加载数据");
        mPracticalRecyclerView = (PracticalRecyclerView) findViewById(R.id.recycler);
        mAdapter = new SingleItemAdapter();
        mPracticalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPracticalRecyclerView.setAdapterWithLoading(mAdapter);
        mPracticalRecyclerView.setRefreshListener(new PracticalRecyclerView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadData();
            }
        });
        mPracticalRecyclerView.setLoadMoreListener(new PracticalRecyclerView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                presenter.loadData();
            }
        });
        presenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showLoading(boolean show) {
        if(show) {
            mProgressDialog.show();
        } else {
            mProgressDialog.dismiss();
        }
    }

    public static final int WRITE_EXTERNAL_STORAGE = 100;

    @AfterPermissionGranted(WRITE_EXTERNAL_STORAGE)
    private void checkPerm() {
        String[] params={Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if(EasyPermissions.hasPermissions(this,params)){
            Toast.makeText(this, "具有使用sd卡的权限", Toast.LENGTH_LONG).show();
        }else{
            EasyPermissions.requestPermissions(this,"需要读写本地权限",WRITE_EXTERNAL_STORAGE,params);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        // Some permissions have been granted
        // 请求权限已经被授权
        // ...
        Toast.makeText(this, "请求权限已经被授权", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
        // Some permissions have been denied
        // 请求权限被拒绝
        // ...
        Toast.makeText(this, "请求权限被拒绝", Toast.LENGTH_LONG).show();
    }

    @Override
    protected FrameActivityPresenter getPresenter() {
        return new FrameActivityPresenter();
    }

    @Override
    public void showData(Book data) {
        mAdapter.addAll(data.getBooks());
    }
}
