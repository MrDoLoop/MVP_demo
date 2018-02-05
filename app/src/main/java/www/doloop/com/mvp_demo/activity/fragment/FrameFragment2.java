package www.doloop.com.mvp_demo.activity.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;

import www.doloop.com.mvp_demo.R;
import www.doloop.com.mvp_demo.activity.view.ClassicRefreshHeaderView;
import www.doloop.com.mvp_demo.activity.view.LoadMoreFooterView;
import www.doloop.com.mvp_demo.adapter.FragmentListAdapter;
import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo_frame.BaseFragment;

/**
 * Created by zhaonan on 18/2/5.
 */

public class FrameFragment2 extends BaseFragment<FragmentPresenter, FragmentView> implements FragmentView,
        OnRefreshListener, OnLoadMoreListener {

    public static FrameFragment2 newInstance() {
        FrameFragment2 fragment = new FrameFragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    ProgressDialog mProgressDialog;
    IRecyclerView mRecyclerView;
    private LoadMoreFooterView loadMoreFooterView;

    private FragmentListAdapter mAdapter;

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
        View rootView = inflater.inflate(R.layout.fragment_layout2, container,false);
        mRecyclerView = (IRecyclerView) rootView.findViewById(R.id.iRecyclerView);

        loadMoreFooterView = (LoadMoreFooterView) mRecyclerView.getLoadMoreFooterView();

        mAdapter = new FragmentListAdapter(getContext());
        mRecyclerView.setIAdapter(mAdapter);

        mRecyclerView.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);

        ClassicRefreshHeaderView classicRefreshHeaderView = new ClassicRefreshHeaderView(getContext());
        classicRefreshHeaderView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        // we can set view
        mRecyclerView.setRefreshHeaderView(classicRefreshHeaderView);

        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setRefreshing(true);
                mPresenter.refreshData();
            }
        });
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
        //mAdapter.setList(data.getBooks());
        //mAdapter.addAll(data.getBooks());
        //mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }
}
