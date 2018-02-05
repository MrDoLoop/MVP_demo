package www.doloop.com.mvp_demo.activity.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import www.doloop.com.mvp_demo.R;
import www.doloop.com.mvp_demo.adapter.RecyclerViewAdapter;
import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo_frame.BaseFragment;

/**
 * Created by ZHAO_NAN on 2018/2/3.
 */

public class FrameFragment3 extends BaseFragment<FragmentPresenter, FragmentView> implements FragmentView, PullLoadMoreRecyclerView.PullLoadMoreListener {

    public static FrameFragment3 newInstance() {
        FrameFragment3 fragment = new FrameFragment3();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ProgressDialog mProgressDialog;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private int mCount = 1;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setTitle("正在加载数据");
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout3, container,false);
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) rootView.findViewById(R.id.pullLoadMoreRecyclerView);
        //获取mRecyclerView对象
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        //代码设置scrollbar无效？未解决！
        mRecyclerView.setVerticalScrollBarEnabled(true);
        //设置下拉刷新是否可见
        //mPullLoadMoreRecyclerView.setRefreshing(true);
        //设置是否可以下拉刷新
        //mPullLoadMoreRecyclerView.setPullRefreshEnable(true);
        //设置是否可以上拉刷新
        //mPullLoadMoreRecyclerView.setPushRefreshEnable(false);
        //显示下拉刷新
        mPullLoadMoreRecyclerView.setRefreshing(true);
        //设置上拉刷新文字
        mPullLoadMoreRecyclerView.setFooterViewText("loading");
        //设置上拉刷新文字颜色
        //mPullLoadMoreRecyclerView.setFooterViewTextColor(R.color.white);
        //设置加载更多背景色
        //mPullLoadMoreRecyclerView.setFooterViewBackgroundColor(R.color.colorBackground);
        mPullLoadMoreRecyclerView.setLinearLayout();

        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity());
        mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);


        mPresenter.loadData();
        return rootView;
    }
    
    @Override
    protected FragmentPresenter getPresenter() {
        return new FragmentPresenter();
    }


    @Override
    public void showLoading(boolean show) {
        if(show) {
            mProgressDialog.show();
        } else {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showData(Book data) {
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        mRecyclerViewAdapter.append(data.getBooks());
    }

    @Override
    public void showError() {

    }

    @Override
    public void onRefresh() {
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPresenter.loadData();
    }

    @Override
    public void onLoadMore() {
        mPresenter.loadData();
    }
}
